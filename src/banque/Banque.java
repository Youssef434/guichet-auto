package banque;

import guichetAutomatique.GuichetAutomatique;

public final class Banque {
  private final String nom;
  private final GuichetAutomatique guichetAutomatique;

  public Banque(String nom, GuichetAutomatique guichetAutomatique) {
    this.nom = nom;
    this.guichetAutomatique = guichetAutomatique;
  }

  public String getNom() {
    return nom;
  }

  public GuichetAutomatique getGuichetAutomatique() {
    return guichetAutomatique;
  }
}
