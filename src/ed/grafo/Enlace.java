package ed.grafo;

public class Enlace {
    private final int nodoB;
    private final Double peso;

    /**
     * Constructor de Enlace
     * @param nodoB destino
     * @param peso peso
     */
    public Enlace(int nodoB, Double peso) {
        this.nodoB = nodoB;
        this.peso = peso;
    }

    /**
     * getter del id del nodoB
     * @return nodoB
     */
    public int getNodoB() {
        return nodoB;
    }

    /**
     * getter del peso del enlace
     * @return peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * Metodo toSting
     * @return String
     */
    public String toString(){
        return "[" + nodoB +","
                +peso +"]";
    }
}
