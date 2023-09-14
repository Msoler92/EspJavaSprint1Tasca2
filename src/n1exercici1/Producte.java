package n1exercici1;

public class Producte {
    private String nom;
    private float preu;

    public Producte(String nom, float preu) {
        this.nom = nom;
        this.preu = preu;
    }

    //Getters
    public float getPreu() {
        return preu;
    }

    public String toString() {
        return "Nom: " + nom + ".\n" + "Preu: " + preu + ".";
    }
}
