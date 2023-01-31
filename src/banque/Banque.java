package banque;

import guichetAutomatique.GuichetAutomatique;
import guichetAutomatique.GuichetAutomatiqueCaissePopulaire;

import java.util.StringJoiner;

public final class Banque {
  private final String nom;
  private final GuichetAutomatiqueCaissePopulaire guichetAutomatique;

  public Banque(String nom, GuichetAutomatiqueCaissePopulaire guichetAutomatique) {
    this.nom = nom;
    this.guichetAutomatique = guichetAutomatique;
  }

  public String getNom() {
    return nom;
  }

  public GuichetAutomatique getGuichetAutomatique() {
    return guichetAutomatique;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Banque.class.getSimpleName() + "[", "]")
        .add("nom='" + nom + "'")
        .add("guichetAutomatique=" + guichetAutomatique)
        .toString();
  }
}
