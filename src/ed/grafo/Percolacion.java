package ed.grafo;

import java.util.ArrayList;

public class Percolacion<T> {
    private Grafo<T> g;
    private ArrayList<Boolean> listaNodosActivos;
    private int nNodosActivos;
    private double op;
    private double ncc;
    private double gcc;
    private double slcc;


    public Percolacion(Grafo<T> g) {
        this.g = new Grafo<T>(g)
        this.listaNodosActivos = new ArrayList<>();
        this.listaNodosActivos.add(false);
        for (int i = 1; i <= g.getnNodos() ; i++) {
            this.listaNodosActivos.add(true);
        }
        this.nNodosActivos = g.getnNodos();
        this.evaluar();
    }


    public void evaluar() {
        //TODO evaluar la red
    }

    public void evaluacionPercolacion(){
        /*TODO crear metodo que haga todo el bucle de la percolacio
           publico y con eleccion de tipo de eliminacion
        */
    }

    private int eliminarNodoAleatorio() {
        //TODO elinar un nodo aleatorio de la red "quitar todos sus enlaces"
        int idNodoEliminado;
        return idNodoEliminado;
    }

    private int eliminarNodoGrado() {
        //TODO elinar el nodo de mayor grado de la red "quitar todos sus enlaces"
        int idNodoEliminado;
        return idNodoEliminado;
    }

    private int eliminarNodoStr() {
        //TODO elinar el nodo de mayor strengh de la red "quitar todos sus enlaces"
        int idNodoEliminado;
        return idNodoEliminado;
    }

}
