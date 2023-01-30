package guichetAutomatique;

import compte.Carte;
import compte.Compte;
import compte.TypeCarte;

import java.util.Map;

public interface GuichetAutomatique {
  default double solde(Carte carte) {
    return carte.getSolde();
  }
  default void tirer(Carte carte, double valeur) {
    if (carte.getSolde() < valeur) {
      avanceFonds(carte, valeur);
      return;
    }

    carte.removeFromSolde(valeur);
  }

  void alimenterGA(Map<Integer, Integer> argents);


  private void avanceFonds(Carte carte, double valeur) {
    if (carte.getTypeCarte() == TypeCarte.DEBIT) {
      return;
    }

    carte.removeFromSolde(valeur);
  }
}
