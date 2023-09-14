package n1exercici1;
import java.util.ArrayList;

public class Venda {
    private ArrayList<Producte> llistaProductes;
    private float preuTotal;

    public Venda (ArrayList<Producte> llistaProductes) {
        this.llistaProductes = llistaProductes;
        preuTotal = 0;
    }

    //Getters
    public float getPreuTotal() {
        return preuTotal;
    }

    public void calculaTotal() throws VendaBuidaException {
        if (llistaProductes.size() == 0) {
            throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
        } else {
            for (Producte p: llistaProductes) {
                //Afegir ArrayIndexOutOfBoundsException?
                preuTotal += p.getPreu();
            }
        }
    }
}
