package compte;

import java.util.Random;

public final class Carte {
  private final TypeCarte type;
  private final FabricateurCarte fabricateur;
  private final Compte compte;

  private final int codePin;

  public Carte(TypeCarte type, Compte compte, FabricateurCarte fabricateur) {
    this.type = type;
    this.compte = compte;
    this.fabricateur = fabricateur;
    codePin = new Random().nextInt(1111, 10000);
  }

  public TypeCarte getType() {
    return type;
  }

  public double getSolde() {
    return compte.getSolde();
  }

  public void removeFromSolde(double value) {
    compte.removeFromSolde(value);
  }

  public int getCodePin() {
    return codePin;
  }

  public FabricateurCarte getFabricateur() {
    return fabricateur;
  }
}
