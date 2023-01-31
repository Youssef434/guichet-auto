package guichetAutomatique;

import banque.Compte;
import banque.carte.Carte;
import facture.Facture;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class GuichetAutomatiqueCaissePopulaire implements GuichetAutomatique {
  private Map<Integer, Integer> argents;
  private int papiers;

  public GuichetAutomatiqueCaissePopulaire(Map<Integer, Integer> argents, int papiers) {
    this.argents = argents;
    this.papiers = papiers;
  }

  @Override
  public boolean tirer(Carte carte, int valeur) {
    if (!isMontantValid(valeur)) {
      return false;
    }

    if (carte.getSolde() < valeur) {
      return GuichetAutomatique.super.avanceFonds(carte, valeur);
    }

    carte.removeFromSolde(valeur);
    return true;
  }

  @Override
  public void deposer(Carte carte, int valeur) {
    carte.addToSolde(valeur);
  }

  @Override
  public void alimenterGA(Map<Integer, Integer> argents, int papiers) {
    this.papiers += papiers;

    this.argents = this.argents.entrySet().stream()
        .map(entry -> Map.entry(entry.getKey(), entry.getValue() + argents.get(entry.getKey())))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @Override
  public boolean isMontantValid(int montant) {
    int[] values = {100, 50, 20};
    Map<Integer, Integer> map = new HashMap<>();

    for (int value : values) {
      if (montant == 0) {
        updateArgents(map);
        return true;
      }
      if (montant < 0) return false;

      int coeff = Math.min(montant / value, argents.get(value));
      montant -= value * coeff;
      map.put(value, coeff);
    }

    if (montant == 0) {
      updateArgents(map);
      return true;
    }

    return false;
  }

  private void updateArgents(Map<Integer, Integer> map) {
    System.out.println(map);
    argents = argents.entrySet().stream()
        .map(entry -> Map.entry(entry.getKey(),  entry.getValue() - map.getOrDefault(entry.getKey(), 0)))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @Override
  public void payerFacture(Carte carte, Facture facture) {

  }

  @Override
  public synchronized void transferer(Carte carte, Compte beneficier, int montant) {
    if (!tirer(carte, montant)) {
      throw new RuntimeException();
    }

    beneficier.addToSolde(montant);
  }
}
