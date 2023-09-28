package n3exercici1;
import java.util.ArrayList;

public class GestioButaques { //Done
    private ArrayList<Butaca> butaques;
    public GestioButaques() {
        butaques = new ArrayList<Butaca>();
    }
    public ArrayList<Butaca> getButaques() {
        return butaques;
    }
    public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada{
        if(cercarButaca(butaca.getFila(), butaca.getSeient()) == -1) {
            butaques.add(butaca);
        }
        else {
            throw new ExcepcioButacaOcupada("ExcepcioButacaOcupada: butaca ocupada");
        }
    }
    public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure {
        int index = cercarButaca(fila, seient);
        if (index != -1) {
            butaques.remove(index);
        } else {
            throw new ExcepcioButacaLliure("ExcepcioButacaLliure: butaca lliure");
        }
    }

    public int cercarButaca(int fila, int seient) {
        int size = butaques.size();
        int index = size - 1;
        boolean found = false;
        Butaca butaca;
        while (!found && index >= 0) {
            butaca = butaques.get(index);
            if (fila == butaca.getFila() && seient == butaca.getSeient()) {
                found = true;
            }
            else {
                index--;
            }
        }
        return index;
    }
}
