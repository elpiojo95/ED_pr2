package ed.grafo;

import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap<T> {
    private ArrayList<Nodo<T>> heap;
    private final boolean tipo;

    public MaxHeap() {
        this.tipo = false;
        this.heap = new ArrayList<>();
        this.heap.add(null);
    }

    public MaxHeap(boolean str) {
        this.tipo = str;
        this.heap = new ArrayList<>();
        this.heap.add(null);
    }

    private int padre(int idx) {
        return idx / 2;
    }

    private int izqHijo(int idx) {
        return idx * 2;
    }

    private int dchHijo(int idx) {
        return idx * 2 + 1;
    }

    private boolean tienePadre(int idx) {
        return idx > 1;
    }

    private boolean tieneIzqHijo(int idx) {
        return this.izqHijo(idx) < heap.size();
    }

    private boolean tieneDchHijo(int idx) {
        return this.dchHijo(idx) < heap.size();
    }

    private void ascender() {
        int idx = this.heap.size()-1;
        while (tienePadre(idx) && this.heap.get(padre(idx)).compareTo(this.heap.get(idx), tipo) < 0)
        {
            Collections.swap(this.heap, idx, padre(idx));
            idx = padre(idx);
        }
    }

    public void descender(Nodo<T> n) {
        int idx = this.heap.indexOf(n);
        while (this.tieneIzqHijo(idx)){
            int grande = this.izqHijo(idx);
            if (tieneDchHijo(idx) && this.heap.get(izqHijo(idx)).compareTo(this.heap.get(dchHijo(idx)), tipo) < 0)
            {
                grande = this.dchHijo(idx);
            }
            if (this.heap.get(idx).compareTo(this.heap.get(grande), tipo) < 0)
            {
                Collections.swap(this.heap, idx, grande);
            }
            else break;
            idx = grande;
        }
    }

    public void add(Nodo<T> n) {
        this.heap.add(n);
        this.ascender();
    }

    public void eliminar() {
        Collections.swap(this.heap, 1, this.heap.size()-1);
        this.heap.remove(heap.size()-1);
        if (!this.isVacio()) {
            this.descender(this.heap.get(1));
        }
    }

    public Nodo<T> ver() {
        if (this.isVacio()) return null;
        return heap.get(1);
    }

    public Nodo<T> verYeliminar() {
        Nodo<T> n = this.ver();
        if (!this.isVacio()) this.eliminar();
        return n;
    }

    public boolean isVacio() {
        return this.heap.size() == 1;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "heap=" + heap +
                '}';
    }
}
