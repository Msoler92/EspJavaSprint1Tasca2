package n2exercici1;

public class Main {
    public static void main(String[] args) {
        byte e;
        boolean run = true;
        byte b;
        int i;
        float f;
        double d;
        char c;
        String s;
        boolean sn;

        while (run) {
            System.out.println("1.- Byte\n" +
                    "2.- Int\n" +
                    "3.- Float\n" +
                    "4.- Double\n" +
                    "5.- Char\n" +
                    "6.- String\n" +
                    "7.- Boolean\n");
            e = Entrada.llegirByte("Mètode a testar:");
            switch (e) {
                case 1:
                    System.out.println(Entrada.llegirByte("Introdueixi un Byte:"));
                    break;
                case 2:
                    System.out.println(Entrada.llegirInt("Introdueixi un Integer:"));
                    break;
                case 3:
                    System.out.println(Entrada.llegirFloat("Introdueixi un Float:"));
                    break;
                case 4:
                    System.out.println(Entrada.llegirDouble("Introdueixi un Double:"));
                    break;
                case 5:
                    System.out.println(Entrada.llegirChar("Introdueixi un Char:"));
                    break;
                case 6:
                    System.out.println(Entrada.llegirString("Introdueixi un String:"));
                    break;
                case 7:
                    System.out.println(Entrada.llegirSiNo("Introdueixi 's' (Si) o 'n' (No):"));
                    break;
                default:
                    run = false;
            }
        }
    }
}
