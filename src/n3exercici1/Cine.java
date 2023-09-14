package n3exercici1;

public class Cine {
    int numFiles;
    int numColumnes;
    GestioButaques gestor;
    public Cine() {
        gestor = new GestioButaques();
        demanarDadesInicials();
    }
    private void demanarDadesInicials() {
        numFiles = Entrada.llegirInt("Introdueixi el nombre de files a la sala:");
        numColumnes = Entrada.llegirInt("Introdueixi el nombre de seients per fila:");
    }
    public void iniciar() {
        switch(menu()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 0:
                break;
            default:
        }
    }
    private byte menu() {
        System.out.println("MENÚ PRINICPAL");
        System.out.println("1.- Mostrar totes les butaques reservades.");
        System.out.println("2.- Mostrar les butaques reservades per una persona.");
        System.out.println("3.- Reservar una butaca.");
        System.out.println("4.- Anul·lar la reserva d’una butaca.");
        System.out.println("5.- Anul·lar totes les reserves d’una persona.");
        System.out.println("0.- Sortir.");
        return Entrada.llegirByte("Introdueixi el nombre corresponent a la opció desitjada.");
    }

    private void mostrarButaques() {

    }
}
