package guichetAutomatique;

import banque.Compte;
import banque.carte.Carte;
import banque.carte.TypeCarte;
import facture.Facture;

import java.util.List;
import java.util.Map;

public interface GuichetAutomatique {
  default double solde(Carte carte) {
    return carte.getSolde();
  }
  boolean tirer(Carte carte, int valeur);

  void deposer(Carte carte, int valeur);

  void alimenterGA(Map<Integer, Integer> argents, int papiers);
  boolean isMontantValid(int montant);

  void payerFacture(Carte carte, Facture facture);

  default void payerFactures(Carte carte, List<Facture> factures) {
    factures.forEach(facture -> payerFacture(carte, facture));
  }

  default boolean avanceFonds(Carte carte, int valeur) {
    if (carte.getType() == TypeCarte.DEBIT) {
      return false;
    }

    carte.removeFromSolde(valeur);
    return true;
  }

  void transferer(Carte carte, Compte beneficier, int montant);

  private boolean isClientBanque(Carte carte) {
    return this.getClass().equals(carte
        .getCompte()
        .getBanque()
        .getGuichetAutomatique()
        .getClass());
  }
}
