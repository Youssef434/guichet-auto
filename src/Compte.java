public final class Compte {
  private double solde;

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
