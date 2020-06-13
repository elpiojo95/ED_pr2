package ed.grafo;

import javax.swing.*;
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
        this.g = new Grafo<>(g);
        this.listaNodosActivos = new ArrayList<>();
        this.listaNodosActivos.add(false);
        for (int i = 1; i <= g.getnNodos() ; i++) {
            this.listaNodosActivos.add(true);
        }
        this.nNodosActivos = g.getnNodos();
        this.evaluar();
    }


    public void evaluar() {
        // Calcular op
        int count = 0;
        for (Boolean b : listaNodosActivos) {
            if (b) {
                count++;
            }
        }
        op = count;
        //TODO calcular ncc
        //TODO calcular gcc
        //TODO calcular slcc
    }

    public void evaluacionPercolacion(){
        /*TODO crear metodo que haga todo el bucle de la percolacio
           publico y con eleccion de tipo de eliminacion
        */
    }

    private int eliminarNodoAleatorio() {
        int idNodoEliminado = 0;
        //generar el nodo aleatorio i actualizar la lista de nodos activos
        int idRand = (int) (Math.random() * this.nNodosActivos + 1);
        for (int i = 0; i < idRand ; i++) {
            if (this.listaNodosActivos.get(idNodoEliminado)){
                idNodoEliminado++;
            }
            while (!this.listaNodosActivos.get(idNodoEliminado)) {
                idNodoEliminado++;
            }
        }
        this.listaNodosActivos.set(idNodoEliminado, false);
        this.nNodosActivos--;
        //eliminar enlaces
        this.g.eliminarEnlace(idNodoEliminado);
        return idNodoEliminado;
    }

    private int eliminarNodoGrado() {
        int idNodoEliminado = 0, maxGrado = 0, j = 0;
        //encontrar id nodo con mas grado y actualizar la listaNodosActivos
        for (int i = 0; i < this.nNodosActivos ; i++) {
            while (!this.listaNodosActivos.get(j)){
                j++;
            }
            if (this.g.gradoNodo(j) > maxGrado){
                maxGrado = this.g.gradoNodo(j);
                idNodoEliminado = j;
            }
            j++;
        }
        this.nNodosActivos--;
        this.listaNodosActivos.set(idNodoEliminado, false);
        //eliminar Enlaces de idNodoEliminado
        this.g.eliminarEnlace(idNodoEliminado);
        return idNodoEliminado;
    }

    private int eliminarNodoStr() {
        //encontrar idNodo con mas strength y actualizar listaNodosActivos
        int idNodoEliminado = 0, j = 0;
        double maxStr = 0;
        for (int i = 0; i < this.nNodosActivos; i++) {
            while (!this.listaNodosActivos.get(j)){
                j++;
            }
            if (this.g.pesoTotalEnlacesNodo(j) > maxStr){
                maxStr = this.g.pesoTotalEnlacesNodo(j);
                idNodoEliminado = j;
            }
            j++;
        }
        this.nNodosActivos--;
        this.listaNodosActivos.set(idNodoEliminado, false);

        //eliminar Enlaces de idNodoEliminado
        this.g.eliminarEnlace(idNodoEliminado);
        return idNodoEliminado;
    }

    public double getOp() {
        return op;
    }

    public double getNcc() {
        return ncc;
    }

    public double getGcc() {
        return gcc;
    }

    public double getSlcc() {
        return slcc;
    }
}
