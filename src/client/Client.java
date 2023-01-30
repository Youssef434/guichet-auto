package client;

import compte.Carte;

import java.time.LocalDate;
import java.util.List;

public final class Client {
  private String nom;
  private String prenom;
  private String CIN;
  private String adresse;
  private LocalDate dateNaissance;
  private List<Carte> cartes;
}
