package banque;

import client.Client;
import facture.Facture;
import guichetAutomatique.GuichetAutomatique;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public final class Compte {
  private double solde;
  private Banque banque;
  private Client client;
  private List<Facture> factures;

  public Compte(double solde, Banque banque, Client client, List<Facture> factures) {
    this.solde = solde;
    this.banque = banque;
    this.client = client;
    this.factures = factures;
  }

  public void addToSolde(int value) {
    solde += value;
  }

  public void removeFromSolde(int value) {
    solde -= value;
  }

  public double getSolde() {
    return solde;
  }

  public Banque getBanque() {
    return banque;
  }

  public Client getClient() {
    return client;
  }

  public List<Facture> getFactures() {
    return new ArrayList<>(factures);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Compte.class.getSimpleName() + "[", "]")
        .add("solde=" + solde)
        .add("banque=" + banque)
        .add("client=" + client)
        .add("factures=" + factures)
        .toString();
  }
}
