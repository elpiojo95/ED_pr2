package ed.grafo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo<T1, T2> {
    private ArrayList<Nodo> listaNodos;

    public  Grafo(int nNodos) {
        this.listaNodos = new ArrayList<>(nNodos);
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
    }

    private class Enlace {
        int nodoA;
        int nodoB;
        T2 peso;

        public Enlace(int nodoA, int nodoB, T2 peso) {
            this.nodoA = nodoA;
            this.nodoB = nodoB;
            this.peso = peso;
        }
    }


}
