import banque.carte.Carte;
import guichetAutomatique.GuichetAutomatique;
import guichetAutomatique.GuichetAutomatiqueCaissePopulaire;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public final class Console {
  private static final List<Carte> cartes = List.of();
  private static Carte currentCarte;
  private static final Scanner scanner = new Scanner(System.in);
  private static final GuichetAutomatique guichetAutomatique = new GuichetAutomatiqueCaissePopulaire(
      Map.of(
          100, 10,
          50, 4,
          20, 7
      ),
      100
  );
  private Console() {}

  public static boolean authentifier() {
      System.out.println("Authentification: ");

      System.out.print("Identifiant de la carte: ");
      int carteId = scanner.nextInt();

      System.out.print("Code PIN: ");
      int codePin = scanner.nextInt();

    Optional<Carte> currentCarteOptional = cartes.stream()
        .filter(carte -> carte.getId() == carteId)
        .findFirst();

      if (currentCarteOptional
          .stream()
          .anyMatch(carte -> carte.getCodePin() == codePin)) {
        currentCarte = currentCarteOptional.get();
        return true;
      }
      return false;
  }

  public static void menu() {
    System.out.println("1 -> Consulter votre solde");
    System.out.println("2 -> Tirer de l'argent");
    System.out.println("3 -> Déposer de l'argent");
    System.out.println("4 -> Payer une facture");
    System.out.println("5 -> Payer plusieurs factures");
    System.out.println("6 -> Transférer de l'argent");
    System.out.println("7 -> Alimenter le guichet automatique");
    System.out.println("Saisir n'importe quel autre nombre pour quitter");

    int value = scanner.nextInt();

    switch (value) {
      case 1 -> {
        consulterSolde();
        menu();
      }
      case 2 -> {
        tirerArgent();
        menu();
      }
      case 3 -> {
        deposerArgent();
        menu();
      }
    }
  }

  private static void consulterSolde() {
    System.out.println("Votre solde: " + guichetAutomatique.solde(currentCarte));
  }
  private static void tirerArgent() {
    System.out.println("Donner le montant à tirer: ");
    int montant = scanner.nextInt();
    if (!guichetAutomatique.tirer(currentCarte, montant)) {
      System.out.println("L'opération n'a pas pu s'effectuer");
    }
  }
  private static void deposerArgent() {
    System.out.println("Donner le montant à déposer: ");
    int montant = scanner.nextInt();
    guichetAutomatique.deposer(currentCarte, montant);
  }
}
