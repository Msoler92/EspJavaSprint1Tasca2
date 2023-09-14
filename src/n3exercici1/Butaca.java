package n3exercici1;

public class Butaca { //Done
    int fila;
    int seient;
    String idPersona;
    public Butaca(int fila, int seient, String idPersona) {
        this.fila = fila;
        this.seient = seient;
        this.idPersona = idPersona;
    }
    //Getters
    public int getFila() {
        return fila;
    }
    public int getSeient() {
        return seient;
    }
    public String getIdPersona() {
        return idPersona;
    }
    //Class methods
    public boolean equals(Butaca butaca) {
        return fila == butaca.getFila() && seient == butaca.getSeient();
    }

    public String toString() {
        return "Fila: " + fila + ", Seient: " + seient + ", Persona: " + idPersona;
    }
}
