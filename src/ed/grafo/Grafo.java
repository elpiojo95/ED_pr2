package ed.grafo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Grafo<T1, T2> {
    private ArrayList<Nodo> listaNodos;
    private int nNodos;

    /**
     * Constructor de Grafo
     * @param nNodos nNodos
     */
    public  Grafo(int nNodos) {
        this.listaNodos = new ArrayList<>();
        for (int i = 0; i <= nNodos; i++){
            this.listaNodos.add(null);
        }
        this.nNodos = nNodos;
    }

    /**
     * Constructor de Grafo desde fichero
     * @param filePath Path del fichero .net
     */
    public  Grafo(String filePath) {
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

    /**
     * Clase Nodo, contine el identificador del nodo, su informacion y sus enlaces
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

        /**
         * Metodo toSting
         * @return String
         */
        public String toString(){
            return Integer.toString(this.id);
        }
    }

    /**
     * Clase Enlace, almacena la relacion etre dos nodos y el peso
     */
    private class Enlace {
        private int nodoA;
        private int nodoB;
        private T2 peso;

        /**
         * Constructor de Enlace
         * @param nodoA origen
         * @param nodoB destino
         * @param peso peso
         */
        public Enlace(int nodoA, int nodoB, T2 peso) {
            this.nodoA = nodoA;
            this.nodoB = nodoB;
            this.peso = peso;
        }

        /**
         * Metodo toSting
         * @return String
         */
        public String toString(){
            return "[" +nodoA +","
                    + nodoB +","
                    +this.peso.toString() +"]";
        }
    }

    /**
     * Metodo para añadir un nodo a la red
     * @param id identificador
     * @param info informacion extra TAG
     */
    public void addNodo(int id, T1 info) {
        Nodo temp = new Nodo(id, info);
        if (listaNodos.get(id) == null) {
            listaNodos.set(id, temp);
        }
        else System.out.println("Nodo repetido. ID = " + id);
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
     * @param nodoA origen
     * @param nodoB destino
     * @param peso peso
     */
    public void addEnlace(int nodoA, int nodoB, T2 peso) {
        int idx=0, size;
        Enlace temp = new Enlace(nodoA, nodoB, peso);
        Enlace tempInverso = new Enlace(nodoB, nodoA, peso);

        size = listaNodos.get(nodoA).listaDeEnlaces.size();
        System.out.println("tam:" +size);
        if (size == 0){
            listaNodos.get(nodoA).listaDeEnlaces.add(temp);
            listaNodos.get(nodoB).listaDeEnlaces.add(tempInverso);
        }else {
            while ((listaNodos.get(nodoA).listaDeEnlaces.get(idx).nodoB != nodoB) && (idx < size)){
                idx++;
            }
            if (idx < size){
                System.out.println("Enlace ya existente. N1 = " + nodoA + ", N2 = " + nodoB);
            }else {
                listaNodos.get(nodoA).listaDeEnlaces.add(temp);
                listaNodos.get(nodoB).listaDeEnlaces.add(tempInverso);
            }
        }
    }

    /**
     * Metodo que lee un fichero .net dado un Scanner
     * @param sc scanner
     */
    private void cargarNetwork(Scanner sc) {
        sc.useDelimiter(" ");
        for (int i = 0; i < this.nNodos; i++) {
            String st = sc.nextLine();
            String[] stAr = st.split(" ");
            int j = 0;
            while (stAr[j].equals("")) j++;
            this.addNodo(Integer.parseInt(stAr[j]));

            //TODO leer enlaces y crearlos
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

}
