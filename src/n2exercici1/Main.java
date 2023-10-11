package n2exercici1;

public class Main {
    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("""
                    1.- Byte
                    2.- Int
                    3.- Float
                    4.- Double
                    5.- Char
                    6.- String
                    7.- Boolean
                    """);

            switch (Entrada.llegirByte("Mètode a testar:")) {
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
