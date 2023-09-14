package n1exercici1;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producte> stock = new ArrayList<Producte>();
        stock.add(new Producte("Pa", 2));
        stock.add(new Producte("Carn", 15));
        stock.add(new Producte("Espinacs", 5));
        stock.add(new Producte("Tomàquets", 4));
        stock.add(new Producte("Ous", 3));
        stock.add(new Producte("Llet", 2));

        Venda novaVenda = new Venda(stock);
        try {
            novaVenda.calculaTotal();
            System.out.println("Preu total de la venda: " + novaVenda.getPreuTotal());
        } catch (VendaBuidaException e) {
            System.out.println("VendaBuidaException: " + e.getMessage());
        }

    }

}
