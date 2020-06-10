package ed.grafo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo<T1, T2> {
    private ArrayList<Nodo> listaNodos;

    public  Grafo(int nNodos) {
        this.listaNodos = new ArrayList<>();
        for (int i = 0; i <= nNodos; i++){
            this.listaNodos.add(null);
        }
    }

    private class Nodo {
        private int id;
        private T1 info;
        private LinkedList<Enlace> listaDeEnlaces;

        public Nodo(int id, T1 info) {
            this.id = id;
            this.info = info;
            this.listaDeEnlaces = new LinkedList<>();
        }

        public String toString(){
            return Integer.toString(this.id);
        }
    }

    private class Enlace {
        private int nodoA;
        private int nodoB;
        private T2 peso;

        public Enlace(int nodoA, int nodoB, T2 peso) {
            this.nodoA = nodoA;
            this.nodoB = nodoB;
            this.peso = peso;
        }

        public String toString(){
            return "[" +Integer.toString(nodoA) +","
                    + Integer.toString(nodoB) +","
                    +this.peso.toString() +"]";
        }
    }

    public void addNodo(int id, T1 info) {
        Nodo temp = new Nodo(id, info);
        if (listaNodos.get(id) == null) {
            listaNodos.set(id, temp);
        }
        else System.out.println("Nodo repetido. ID = " + id);
    }
    public void addNodo(int id) {
        this.addNodo(id, null);
    }

    public void addEnlace(int nodoA, int nodoB, T2 peso) {
        Enlace temp = new Enlace(nodoA, nodoB, peso);
        Enlace tempInverso = new Enlace(nodoB, nodoA, peso);
        if (listaNodos.get(nodoA).listaDeEnlaces.contains(temp)) {
            System.out.println("Enlace ya existente. N1 =" + nodoA + "N2 =" + nodoB);
        }
        else if (listaNodos.get(nodoA).listaDeEnlaces.contains(tempInverso)){
            System.out.println("Enlace ya existente. N1 =" + nodoB + "N2 =" + nodoA);
        }
        else {
            listaNodos.get(nodoA).listaDeEnlaces.add(temp);
            listaNodos.get(nodoB).listaDeEnlaces.add(temp);
        }
    }

    public void mostrarListaNodos(){
        System.out.println(listaNodos.toString());
    }

    public void mostrarEnlaces(int nodoID){
        System.out.println(listaNodos.get(nodoID).listaDeEnlaces.toString());
    }


}
