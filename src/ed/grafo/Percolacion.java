package ed.grafo;

public class Percolacion<T> {
    Grafo<T> g;
    // TODO crear lista de nodos activos

    public Percolacion(Grafo<T> g) {
        this.g = g.copy();
    }

    public void evaluar() {
        //TODO evaluar la red
    }

    /*TODO crear metodo que haga todo el bucle de la percolacio
        publico y con eleccion de tipo de eliminacion
     */


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
