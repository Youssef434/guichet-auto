package client;

import java.time.LocalDate;
import java.util.Date;

public final class Client {
  private String nom;
  private String prenom;
  private String CIN;
  private String adresse;

  public Client(String nom, String prenom, String CIN, String adresse) {
    this.nom = nom;
    this.prenom = prenom;
    this.CIN = CIN;
    this.adresse = adresse;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public String getCIN() {
    return CIN;
  }

  public String getAdresse() {
    return adresse;
  }
}
