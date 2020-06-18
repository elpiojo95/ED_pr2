package ed.grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grafo<T> {
    private ArrayList<Nodo<T>> listaNodos;
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

    /**
     * Copy constructor
     * @param other Grafo a copiar
     */
    public Grafo(Grafo<T> other) {
        this.nNodos = other.nNodos;
        this.listaNodos = new ArrayList<>();
        for (Nodo<T> n: other.listaNodos) {
            if (n!=null) {
                this.listaNodos.add(new Nodo<>(n));
            }
            else this.listaNodos.add(null);
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
     * Metodo para añadir un nodo a la red
     * @param id identificador
     * @param info informacion extra TAG
     */
    public void addNodo(int id, T info) {
        Nodo<T> temp = new Nodo<>(id, info);
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
        Enlace temp = new Enlace(nodoB, peso);
        Enlace tempInverso = new Enlace(nodoA, peso);
        if (this.nNodos < nodoA){
            System.out.println("Error: nodo " +nodoA +" no existe.");
        }else if (this.nNodos < nodoB){
            System.out.println("Error: nodo " +nodoB +" no existe.");
        }else {
            if (enlaceExiste(nodoA, nodoB)) {
                System.out.println("Enlace ya existente. N1 = " + nodoA + ", N2 = " + nodoB);
            } else {
                listaNodos.get(nodoA).anadirEnlace(temp);
                listaNodos.get(nodoB).anadirEnlace(tempInverso);
            }
        }
    }

    /**
     * Metodo para comprovar si este enlace existe
     * @param idNodoA origen
     * @param idNodoB destino
     */
    public Boolean enlaceExiste(int idNodoA, int idNodoB){
        return this.listaNodos.get(idNodoA).existeEnlace(idNodoB);
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
    public ArrayList<Nodo<T>> getListaNodos() {
        return listaNodos;
    }

    /**
     * to String de Grafo
     * @return String grafo
     */
    @Override
    public String toString() {
        return "Grafo{" +
                "nNodos=" + nNodos +
                "\nlistaNodos=" + listaNodos +
                '}';
    }
}
