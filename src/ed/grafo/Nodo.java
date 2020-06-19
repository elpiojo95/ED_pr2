package ed.grafo;

import java.util.LinkedList;

/**
 * @param <T> Tipo especifico de Nodo
 */
public class Nodo<T> {

    private int id;
    private T info;
    private LinkedList<Enlace> listaDeEnlaces;
    private int grado;
    private double strength;

    /**
     * Constructor Nodo
     * @param id identificador nodo
     * @param info informacion extra del nodo TAG
     */
    public Nodo(int id, T info) {
        this.id = id;
        this.info = info;
        this.listaDeEnlaces = new LinkedList<>();
        this.grado = 0;
        this.strength = 0;
    }

    /**
     * Copy Constructor
     * @param n: nodo
     */
    public Nodo (Nodo<T> n) {
        if (n != null) {
            this.id = n.id;
            this.info = n.info;
            this.listaDeEnlaces = new LinkedList<>(n.listaDeEnlaces);
            this.grado = n.grado;
            this.strength = n.strength;
        }
    }

    /**
     * metodo que retorna el grado del nodo
     * @return grado del nodo
     */
    public int gradoNodo(){ return this.listaDeEnlaces.size(); }

    /**
     * metodo que me retorna el peso total de todos los enlaces del nodo
     * @return pesoTot
     */
    public double pesoTotalEnlacesNodo(){
        double pesoTot = 0;
        for (Enlace Enlace : this.listaDeEnlaces) {
            pesoTot = pesoTot + Enlace.getPeso();
        }
        return pesoTot;
    }

    /**
     * metodo par eliminar todos los enlaces
     */
    public void eliminarEnlaces(){
        this.listaDeEnlaces.clear();
        this.grado = 0;
        this.strength = 0;
    }

    /**
     * metodo para añadir un enlace
     * @param enlace Enlace
     */
    public void anadirEnlace(Enlace enlace){
        this.grado++;
        this.strength += enlace.getPeso();
        this.listaDeEnlaces.add(enlace);
    }

    /**
     * Metodo para consultar si tiene un enlace con el nodo
     * @param idNodoB Nodo destino
     * @return bolean
     */
    public boolean existeEnlace(int idNodoB){
        if (this.listaDeEnlaces.size() == 0) return false;
        for (Enlace listaDeEnlace : this.listaDeEnlaces) {
            if (listaDeEnlace.getNodoB() == idNodoB) return true;
        }
        return false;
    }

    /**
     * Metodo para obtener el id del nodo en la posicion
     * @param idx posicion
     * @return id
     */
    public int idNodoDestino(int idx){ return this.listaDeEnlaces.get(idx).getNodoB(); }

    /**
     * metodo para eliminar el enlace con un nodo
     * @param idNodo Nodo destino
     */
    public void eliminarEnlace(int idNodo){
        int i = 0;
        while (this.idNodoDestino(i) != idNodo){
            i++;
        }
        this.grado--;
        this.strength = this.pesoTotalEnlacesNodo();
        this.listaDeEnlaces.remove(i);
    }

    /**
     * getter Id del nodo
     * @return id
     */
    public int getId() { return id; }

    /**
     * getter información del nodo
     * @return info
     */
    public T getInfo() { return info; }

    /**
     * getter grado del nodo
     * @return grado
     */
    public int getGrado() { return grado; }

    /**
     * getter del strength del nodo
     * @return strength
     */
    public double getStrength() { return strength; }

    /**
     * getter de listaDeEnlaces
     * @return LinkedList
     */
    public LinkedList<Enlace> getListaDeEnlaces() { return listaDeEnlaces; }

    /**
     * Metodo que compara dos nodos
     * @param n Nodo
     * @param str
     * <p> true STR
     * <p> false Grado
     * @return <p> -1 0 2
     */
    public int compareTo(Nodo<T> n, boolean str) {
        if (str) {
            return Double.compare(this.getStrength(), n.strength);
        }
        else {
            return Integer.compare(this.getGrado(), n.grado);
        }
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
