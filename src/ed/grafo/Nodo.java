package ed.grafo;

import java.util.LinkedList;

public class Nodo<T1> {

    private int id;
    private T1 info;
    private LinkedList<Enlace> listaDeEnlaces;

    /**
     * Constructor Nodo
     * @param id identificador nodo
     * @param info informacion extra del nodo TAG
     */
    public Nodo(int id, T1 info) {
        this.id = id;
        this.info = info;
        this.listaDeEnlaces = new LinkedList<>();
    }

    /**
     * Copy Constructor
     * @param n: nodo
     */
    public Nodo (Nodo<T1> n) {
        if (n != null) {
            this.id = n.id;
            this.info = n.info;
            this.listaDeEnlaces = new LinkedList<>(n.listaDeEnlaces);
        }
    }

    /**
     * metodo que retorna el grado del nodo
     * @return grado del nodo
     */
    public int gradoNodo(){
        return this.listaDeEnlaces.size();
    }

    /**
     * metodo que me retorna el peso total de todos los enlaces del nodo
     * @return pesoTot
     */
    public double pesoTotalEnlacesNodo(){
        double pesoTot = 0;
        for (Enlace listaDeEnlace : this.listaDeEnlaces) {
            pesoTot = pesoTot + listaDeEnlace.getPeso();
        }
        return pesoTot;
    }

    public void eliminarEnlaces(){
        this.listaDeEnlaces.clear();
    }

    public void anadirEnlace(Enlace enlace){
        this.listaDeEnlaces.add(enlace);
    }

    public boolean existeEnlace(int idNodoB){
        if (this.listaDeEnlaces.size() == 0) return false;
        for (Enlace listaDeEnlace : this.listaDeEnlaces) {
            if (listaDeEnlace.getNodoB() == idNodoB) return true;
        }
        return false;
    }

    /**
     * getter Id del nodo
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * getter información del nodo
     * @return info
     */
    public T1 getInfo() {
        return info;
    }

    public LinkedList<Enlace> getListaDeEnlaces() {
        return listaDeEnlaces;
    }

    /**
     * Metodo toSting
     * @return String
     */
    @Override
    public String toString() {
        return "\nNodo{" +
                "id=" + id +
                ", info=" + info +
                ", listaDeEnlaces=" + listaDeEnlaces +
                '}';
    }
}
