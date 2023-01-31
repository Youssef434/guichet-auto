import banque.Banque;
import banque.Compte;
import banque.carte.Carte;
import banque.carte.FabricateurCarte;
import banque.carte.TypeCarte;
import client.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facture.Facture;
import guichetAutomatique.GuichetAutomatiqueCaissePopulaire;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {

//  public static void initJSONFiles() {
//    Banque banque1 = new Banque("Banque 1", new GuichetAutomatiqueCaissePopulaire(Map.of(
//        100, 10,
//        50, 4,
//        20, 7
//    ), 100));
//    Banque banque2 = new Banque("Banque 2", new GuichetAutomatiqueCaissePopulaire(Map.of(
//        100, 7,
//        50, 14,
//        20, 2
//    ), 170));
//
//    Client client = new Client("AB", "AB", "LEKASC", "DWWDD");
//    Facture facture = new Facture("f1", "whatever", 200);
//    Compte compte = new Compte(10000, banque1, client, List.of(facture));
//    Carte carte1 = new Carte(1, TypeCarte.DEBIT, compte, FabricateurCarte.MASTERCARD);
//    Carte carte2 = new Carte(2, TypeCarte.CREDIT, compte, FabricateurCarte.VISA);
//
//    List<Banque> banques = List.of(banque1, banque2);
//
////    try (Writer writer = Files.newBufferedWriter(Path.of("files/banques.json"), StandardCharsets.UTF_8)) {
////      Gson gson = new GsonBuilder().setPrettyPrinting().create();
////      gson.toJson(gson.toJsonTree(banques), writer);
////    } catch (IOException ignored) {}
//
//    jsonWriter(Path.of("files/banques.json"), banques);
//    jsonWriter(Path.of("files/cartes.json"), List.of(carte1, carte2));
//    jsonWriter(Path.of("files/comptes.json"), List.of(compte));
//    jsonWriter(Path.of("files/factures.json"), List.of(facture));
//    jsonWriter(Path.of("files/clients.json"), List.of(client));
//  }

  private static void jsonWriter(Path path, Object obj) {
    try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(gson.toJsonTree(obj), writer);
    } catch (IOException ignored) {}
  }


  public static void main(String[] args) {
//    initJSONFiles();
    while (!Console.authentifier()) {
      System.out.println("Les données fournis ne sont pas valides");
    }
//    Console.menu();
  }
}
