package ed.grafo;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grafo<T1> {
    private ArrayList<Nodo> listaNodos;
    private int nNodos;

    /**
     * Constructor de Grafo
     * @param nNodos nNodos
     */
    public Grafo(int nNodos) {
        this.listaNodos = new ArrayList<>();
        for (int i = 0; i <= nNodos; i++) {
            this.listaNodos.add(null);
        }
        this.nNodos = nNodos;
    }

    /**
     * Constructor de Grafo desde fichero
     * @param filePath Path del fichero .net
     */
    public Grafo(String filePath) {
        Scanner sc;
        this.listaNodos = new ArrayList<>();
        try {
            sc = new Scanner(new File(filePath));
            this.nNodos = Integer.parseInt(sc.nextLine().split(" ")[1]);
            for (int i = 0; i <= this.nNodos; i++){
                this.listaNodos.add(null);
            }
            this.cargarNetwork(sc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Grafo(Grafo<T1> other) {
        this.nNodos = other.nNodos;
        this.listaNodos = new ArrayList<>();
        for (Nodo n: other.listaNodos) {
            if (n!=null) {
                this.listaNodos.add(new Nodo(n));
            }
            else this.listaNodos.add(null);
        }
    }

    /**
     * getter de nNodos
     * @return nNodos
     */
    public int getnNodos() {
        return nNodos;
    }

    /**
     * getter listaNodos
     * @return listaNodos
     */
    public ArrayList<Nodo> getListaNodos() {
        return listaNodos;
    }

    /**
     * Clase Nodo, contiene el identificador del nodo, su informacion y sus enlaces
     */
    private class Nodo {
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

        public Nodo (Nodo n) {
            if (n != null) {
                this.id = n.id;
                this.info = n.info;
                this.listaDeEnlaces = new LinkedList<>(n.listaDeEnlaces);
            }
        }


        /**
         * Metodo toSting
         * @return String
         */
        public String toString(){
            return Integer.toString(this.id);
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
    }

    /**
     * Clase Enlace, almacena la relacion etre dos nodos y el peso
     */
    private class Enlace {
        private int nodoB;
        private Double peso;

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
         * Metodo toSting
         * @return String
         */
        public String toString(){
            return "[" + nodoB +","
                    +peso +"]";
        }

        /**
         * getter del peso del enlace
         * @return peso
         */
        public Double getPeso() {
            return peso;
        }
    }

    /**
     * Metodo para añadir un nodo a la red
     * @param id identificador
     * @param info informacion extra TAG
     */
    public void addNodo(int id, T1 info) {
        Nodo temp = new Nodo(id, info);
        if (id > nNodos) {
            System.out.println("Nodo Fuera de limites. ID = " + id);
        }
        else {
            if (listaNodos.get(id) == null) {
                listaNodos.set(id, temp);
            } else System.out.println("Nodo repetido. ID = " + id);
        }
    }

    /**
     * Metodo para añadir un nodo sin informacion TAG
     * @param id identificador
     */
    public void addNodo(int id) {
        this.addNodo(id, null);
    }

    /**
     * Metodo para añadir un enlace entre dos nodos
     * @param nodoB destino
     * @param peso peso
     */
    public void addEnlace(int nodoA, int nodoB, Double peso) {
        int size;
        Enlace temp = new Enlace(nodoB, peso);
        Enlace tempInverso = new Enlace(nodoA, peso);
        if (this.nNodos < nodoA){
            System.out.println("Error: nodo " +nodoA +" no existe.");
        }else if (this.nNodos < nodoB){
            System.out.println("Error: nodo " +nodoB +" no existe.");
        }else {
            size = listaNodos.get(nodoA).listaDeEnlaces.size();
            if (size == 0){
                listaNodos.get(nodoA).listaDeEnlaces.add(temp);
                listaNodos.get(nodoB).listaDeEnlaces.add(tempInverso);
            }else {
                if (!enlaceExiste(nodoA,nodoB,size)){
                    listaNodos.get(nodoA).listaDeEnlaces.add(temp);
                    listaNodos.get(nodoB).listaDeEnlaces.add(tempInverso);
                }else System.out.println("Enlace ya existente. N1 = " + nodoA + ", N2 = " + nodoB);
            }
        }
    }

    /**
     * Metodo que lee un fichero .net dado un Scanner
     * @param sc scanner
     */
    private void cargarNetwork(Scanner sc) {
        Pattern p = Pattern.compile("^[\\s]*([\\d]*)[\\s]*([^\\r\\n]*)?");
        Matcher m;
        for (int i = 0; i < this.nNodos; i++) {
            m = p.matcher(sc.nextLine());
            if (m.matches()) this.addNodo(Integer.parseInt(m.group(1)));
        }
        sc.nextLine();
        p = Pattern.compile("^[\\s]*([\\d]*)[\\s]*([\\d]*)[\\s]*([\\d]*.[\\d]*)");
        while (sc.hasNextLine()) {
            m = p.matcher(sc.nextLine());
            if (m.matches()) {
                this.addEnlace(Integer.parseInt(m.group(1)),
                        Integer.parseInt(m.group(2)),
                        Double.parseDouble(m.group(3)));
            }
        }
        sc.close();
    }

    /**
     * Metodo para mostrar todos los nodos
     */
    public void mostrarListaNodos(){
        System.out.println(listaNodos.toString());
    }

    /**
     * Metodo para mostrar todos los enlaces de un nodo
     * @param nodoID Identificador
     */
    public void mostrarEnlaces(int nodoID){
        System.out.println(listaNodos.get(nodoID).listaDeEnlaces.toString());
    }

    /**
     * metodo para eliminar los enlaces de un nodo
     * @param idNodo: identificador de nodo
     */
    public void eliminarEnlace(int idNodo){
        this.listaNodos.get(idNodo).listaDeEnlaces.clear();
    }

    /**
     * metodo que retorna el grado del nodo con indice que le pasamos por parametro
     * @param idNodo: identificador del nodo
     * @return grado del nodo
     */
    public int gradoNodo(int idNodo){
        return this.listaNodos.get(idNodo).listaDeEnlaces.size();
    }

    /**
     * metodo que me retorna el peso total de todos los enlaces del nodo pasado por parametro
     * @param idNodo
     * @return
     */
    public double pesoTotalEnlacesNodo(int idNodo){
        double pesoTot = 0;
        int tam = this.listaNodos.get(idNodo).listaDeEnlaces.size();
        for (int i = 0; i < tam; i++) {
            pesoTot = pesoTot + listaNodos.get(idNodo).listaDeEnlaces.get(i).peso;
        }
        return pesoTot;
    }

    /**
     * Metodo para comprovar si este enlace existe
     * @param nodoA origen
     * @param nodoB destino
     * @param sizeEnlaces tamaño listaEnlaces del nodo de origen
     */
    public Boolean enlaceExiste(int nodoA, int nodoB, int sizeEnlaces){
        for (int idx = 0; idx< sizeEnlaces; idx++){
            if (nodoB == listaNodos.get(nodoA).listaDeEnlaces.get(idx).nodoB){
                return true;
            }
        }
        return false;
    }

}
