package guichetAutomatique;

import compte.Carte;
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

  void alimenterGA(Map<Integer, Integer> argents, int papiers);


  private void avanceFonds(Carte carte, double valeur) {
    if (carte.getType() == TypeCarte.DEBIT) {
      return;
    }

    carte.removeFromSolde(valeur);
  }
}
