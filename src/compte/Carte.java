package compte;

import java.util.Random;

public final class Carte {
  private final TypeCarte typeCarte;
  private final Compte compte;

  private final int codePin;

  public Carte(TypeCarte typeCarte, Compte compte) {
    this.typeCarte = typeCarte;
    this.compte = compte;
    codePin = new Random().nextInt(1111, 10000);
  }

  public TypeCarte getTypeCarte() {
    return typeCarte;
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
}
