package banque.carte;

import banque.Compte;

import java.util.Random;
import java.util.StringJoiner;

public final class Carte {
  private final int id;
  private final TypeCarte type;
  private final FabricateurCarte fabricateur;
  private final Compte compte;

  private final int codePin;

  public Carte(int id, TypeCarte type, Compte compte, FabricateurCarte fabricateur) {
    this.id = id;
    this.type = type;
    this.compte = compte;
    this.fabricateur = fabricateur;
    codePin = new Random().nextInt(1111, 10000);
  }

  public int getId() {
    return id;
  }

  public TypeCarte getType() {
    return type;
  }

  public double getSolde() {
    return compte.getSolde();
  }

  public void removeFromSolde(int value) {
    compte.removeFromSolde(value);
  }

  public void addToSolde(int value) {
    compte.addToSolde(value);
  }

  public int getCodePin() {
    return codePin;
  }

  public FabricateurCarte getFabricateur() {
    return fabricateur;
  }

  public Compte getCompte() {
    return compte;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Carte.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("type=" + type)
        .add("fabricateur=" + fabricateur)
        .add("compte=" + compte)
        .add("codePin=" + codePin)
        .toString();
  }
}
