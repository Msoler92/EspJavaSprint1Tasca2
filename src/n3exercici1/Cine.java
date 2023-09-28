package n3exercici1;
import java.util.ArrayList;

public class Cine {
    int numFiles;
    int numSeients;
    GestioButaques gestor;
    public Cine() {
        gestor = new GestioButaques();
        demanarDadesInicials();
    }
    private void demanarDadesInicials() {
        numFiles = Entrada.llegirInt("Introdueixi el nombre de files a la sala:");
        numSeients = Entrada.llegirInt("Introdueixi el nombre de seients per fila:");
    }
    public void iniciar() {
        boolean run = true;
        while (run) {
            switch (menu()) {
                case 1:
                    mostrarButaques();
                    break;
                case 2:
                    mostrarButaquesPersona(Entrada.llegirString("Introdueixi el nom de la persona:"));
                    break;
                case 3:
                    reservarButaca();
                    break;
                case 4:
                    anularReserva();
                    break;
                case 5:
                    anularReservaPersona();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Opció no reconeguda.");
            }
        }
        System.out.println("Tancant aplicació.");
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
        ArrayList<Butaca> butaques = gestor.getButaques();
        if (butaques.size() > 0) {
            for (Butaca butaca: butaques) {
                System.out.println(butaca);
            }
        } else {
            System.out.println("No hi ha butaques reservades.");
        }

    }

    private void mostrarButaquesPersona(String idPersona) {
        ArrayList<Butaca> butaques = gestor.getButaques();
        boolean found = false;
        for (Butaca butaca: butaques) {
            if (butaca.getIdPersona().equalsIgnoreCase(idPersona)) {
                System.out.println(butaca);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No hi ha butaques reservades a nom de " + idPersona + ".");
        }
    }

    private void reservarButaca() {
        int fila;
        int seient;
        String idPersona;
        try {
            fila = introduirFila();
            seient = introduirSeient();
            idPersona = introduirPersona();
            gestor.afegirButaca(new Butaca (fila, seient, idPersona));
            System.out.println("Butaca reservada.");
        } catch (ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte | ExcepcioNomPersonaIncorrecte | ExcepcioButacaOcupada e) {
            System.out.println(e.getMessage());
        }
    }

    private void anularReserva() {
        int fila;
        int seient;
        try {
            fila = introduirFila();
            seient = introduirSeient();
            gestor.eliminarButaca(fila, seient);
            System.out.println("Reserva anulada.");
        } catch (ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte | ExcepcioButacaLliure e) {
            System.out.println(e.getMessage());
        }
    }

    private void anularReservaPersona() {
        String idPersona;
        boolean found = false;
        ArrayList<Butaca> butaques = (ArrayList<Butaca>)gestor.getButaques().clone();
        try {
            idPersona = introduirPersona();
            for (Butaca butaca : butaques) {
                if (butaca.getIdPersona().equalsIgnoreCase(idPersona)) {
                    try {
                        gestor.eliminarButaca(butaca.getFila(), butaca.getSeient());
                        found = true;
                    } catch (ExcepcioButacaLliure e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            if (found) {
                System.out.println("Reserva anulada.");
            } else {
                System.out.println("No hi ha butaques reservades a nom de " + idPersona + ".");
            }
        } catch (ExcepcioNomPersonaIncorrecte e) {
            System.out.println(e.getMessage());
        }

    }

    private int introduirFila() throws ExcepcioFilaIncorrecta {
        int fila = Entrada.llegirInt("Introdueixi el número de fila.");
        if (fila <= 0 || fila > numFiles) {
            throw new ExcepcioFilaIncorrecta ("ExcepcioFilaIncorrecta: número de fila incorrecte.");
        }
        return fila;
    }

    private int introduirSeient() throws ExcepcioSeientIncorrecte {
        int seient = Entrada.llegirInt("Introdueixi el número de seient.");
        if (seient <= 0 || seient > numSeients) {
            throw new ExcepcioSeientIncorrecte ("ExcepcioSeientIncorrecte: número de seient incorrecte.");
        }
        return seient;
    }

    private String introduirPersona() throws ExcepcioNomPersonaIncorrecte {
        String idPersona = Entrada.llegirString("Introdueixi el nom de la persona que fa la reserva.");
        if (hasDigits(idPersona)) {
            throw new ExcepcioNomPersonaIncorrecte("ExcepcioNomPersonaIncorrecte: el nom no pot contenir dígits.");
        }
        return idPersona;
    }
    //No explicitament demanat per l'enunciat
    private boolean hasDigits (String word) {
        boolean digitFound = false;
        char[] charArray = word.toCharArray();
        int length = word.length();
        int i = 0;
        while (!digitFound && i < length) {
            if (Character.isDigit(charArray[i])) {
                digitFound = true;
            }
            i++;
        }
        return digitFound;
    }
}
