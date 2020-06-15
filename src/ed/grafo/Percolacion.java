package ed.grafo;

import java.util.ArrayList;
import java.util.Stack;

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
        this.op = 0;
        this.ncc = 0;
        this.gcc = 0;
        this.slcc = 0;
        this.evaluar();
    }

    public void evaluar() {
        op = 0; ncc = 0; gcc = 0; slcc = 0;
        // Calcular op
        op = (double) nNodosActivos/g.getnNodos();
        //DFS
        ArrayList<Integer> explorados = new ArrayList<>();
        while (explorados.size() < nNodosActivos) {
            Stack<Nodo<T>> s = new Stack<>();
            ncc++;
            int cc = 0;
            s.push(g.getListaNodos().get(listaNodosActivos.indexOf(true)));
            while (!s.empty()) {
                Nodo<T> n = s.pop();
                if (!explorados.contains(n.getId())) {
                    explorados.add(n.getId());
                    cc++;
                    for (Enlace enclace : n.getListaDeEnlaces()) {
                        s.push(g.getListaNodos().get(enclace.getNodoB()));
                    }
                }
            }
            this.actualizarGccSlcc(cc);
        }
        ncc = ncc/g.getnNodos();
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
        this.g.getListaNodos().get(idNodoEliminado).eliminarEnlaces();
        return idNodoEliminado;
    }

    private int eliminarNodoGrado() {
        int idNodoEliminado = 0, maxGrado = 0, j = 0;
        //encontrar id nodo con mas grado y actualizar la listaNodosActivos
        for (int i = 0; i < this.nNodosActivos ; i++) {
            while (!this.listaNodosActivos.get(j)){
                j++;
            }
            if (this.g.getListaNodos().get(j).gradoNodo() > maxGrado){
                maxGrado = this.g.getListaNodos().get(j).gradoNodo();
                idNodoEliminado = j;
            }
            j++;
        }
        this.nNodosActivos--;
        this.listaNodosActivos.set(idNodoEliminado, false);
        //eliminar Enlaces de idNodoEliminado
        this.g.getListaNodos().get(idNodoEliminado).eliminarEnlaces();
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
            if (this.g.getListaNodos().get(j).pesoTotalEnlacesNodo() > maxStr){
                maxStr = this.g.getListaNodos().get(j).pesoTotalEnlacesNodo();
                idNodoEliminado = j;
            }
            j++;
        }
        this.nNodosActivos--;
        this.listaNodosActivos.set(idNodoEliminado, false);
        //eliminar Enlaces de idNodoEliminado
        this.g.getListaNodos().get(idNodoEliminado).eliminarEnlaces();
        return idNodoEliminado;
    }

    private void actualizarGccSlcc(int i) {
        double d = (double) i / g.getnNodos();
        if (d > this.gcc) {
            this.slcc = this.gcc;
            this.gcc = d;
        }
        else if (d > this.slcc) {
            this.slcc = d;
        }
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
