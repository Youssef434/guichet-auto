package facture;

public final class Facture {
  private final String id;
  private final String description;
  private final double prix;

  public Facture(String id, String description, double prix) {
    this.id = id;
    this.description = description;
    this.prix = prix;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public double getPrix() {
    return prix;
  }
}
