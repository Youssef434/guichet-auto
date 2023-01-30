package compte;

import java.util.List;

public final class Compte {
  private double solde;
  private boolean isBanqueClient;

  public void addToSolde(double value) {
    solde += value;
  }

  public void removeFromSolde(double value) {
    solde -= value;
  }

  public double getSolde() {
    return solde;
  }
}
