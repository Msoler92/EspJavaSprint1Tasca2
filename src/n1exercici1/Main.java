package n1exercici1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //TODO: ArrayIndexOutOfBoundsException
    public static void main(String[] args) {
        byte input;
        ArrayList<Producte> stock = new ArrayList<Producte>();
        ArrayList<Producte> emptyStock = new ArrayList<Producte>();
        Scanner sc = new Scanner(System.in);
        boolean run = true;


        stock.add(new Producte("Pa", 2));
        stock.add(new Producte("Carn", 15));
        stock.add(new Producte("Espinacs", 5));
        stock.add(new Producte("Tomàquets", 4));
        stock.add(new Producte("Ous", 3));
        stock.add(new Producte("Llet", 2));

        while (run) {
            System.out.println("Esculli una opció:");
            System.out.println("1.- Genera venda i calcula preu total");
            System.out.println("2.- Inspecciona producte per número d'ordre");
            input = sc.nextByte();
            switch (input) {
                case 1:
                    try {
                        generaVenda(emptyStock); //Exemple VendaBuidaException si passem emptyStock com a parametre.
                        run = false;
                    } catch (VendaBuidaException e) {
                        System.out.println("VendaBuidaException: " + e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Introdueixi el número d'ordre del producte:");
                    input = sc.nextByte();
                    try {
                        inspeccionaStock(stock, input); //Exemple IndexOutOfBoundsException si passem input > 0 or id < 5
                        run = false;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Error");
            }
        }

    }

    static void generaVenda(ArrayList<Producte> productList) throws VendaBuidaException {
        Venda novaVenda = new Venda(productList);
        novaVenda.calculaTotal();
        System.out.println("Preu total de la venda: " + novaVenda.getPreuTotal());
    }

    static void inspeccionaStock(ArrayList<Producte> stock, int id) {
        System.out.println(stock.get(id).toString());
    }

}
