package ed.grafo;

import com.sun.source.tree.WhileLoopTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Percolacion<T> {
    private Grafo<T> g;
    private ArrayList<Integer> listaNodosActivos;
    private int nNodosActivos;
    private int nodosEliminar;
    private double op;
    private double ncc;
    private double gcc;
    private double slcc;


    public Percolacion(Grafo<T> g) {
        this.g = new Grafo<>(g);
        this.listaNodosActivos = new ArrayList<>();
        for (int i = 1; i <= g.getnNodos() ; i++) {
            this.listaNodosActivos.add(i);
        }
        this.nNodosActivos = g.getnNodos();
        this.op = 0;
        this.ncc = 0;
        this.gcc = 0;
        this.slcc = 0;
        this.nodosEliminar = (int) Math.ceil((double)g.getnNodos()/1000);
        this.evaluar();
    }

    public void evaluar() {
        this.op = 0; this.ncc = 0; this.gcc = 0; this.slcc = 0;
        // Calcular op
        this.op = (double) nNodosActivos/g.getnNodos();
        //DFS
        ArrayList<Integer> explorados = new ArrayList<>();
        for (int i = 1; i < listaNodosActivos.size(); i++) {
            Stack<Nodo<T>> s = new Stack<>();
            int cc = 0;
            if (!explorados.contains(listaNodosActivos.get(i))) {
                Nodo<T> n = g.getListaNodos().get(i);
                s.push(n);
                while (!s.empty()) {
                    n = s.pop();
                    if (!explorados.contains(n.getId())) {
                        explorados.add(n.getId());
                        cc++;
                        for (Enlace enclace : n.getListaDeEnlaces()) {
                            s.push(g.getListaNodos().get(enclace.getNodoB()));
                        }
                    }
                }
                this.ncc++;
                this.actualizarGccSlcc(cc);
            }
        }
        this.ncc = (this.ncc+g.getnNodos()-nNodosActivos)/g.getnNodos();
    }

    public void evaluacionPercolacion(int opt) {
        try {
            FileWriter outputfile = new FileWriter("out.csv");
            outputfile.write("op,ncc,gcc,slcc\n");
            outputfile.write(this.op + "," +
                    this.ncc + "," +
                    this.gcc + "," +
                    this.slcc +"\n");

            while (!this.listaNodosActivos.isEmpty()) {
                int nodoEliminado;
                for (int i = 0; i < this.nodosEliminar; i++) {
                    if (this.listaNodosActivos.isEmpty()) break;

                    switch (opt) {
                        case 1: // metodo grado
                            nodoEliminado = this.eliminarNodoStr();
                            break;
                        case 2: // metodo strength
                            nodoEliminado = this.eliminarNodoGrado();
                            break;
                        case 3: // metodo grado con heap //TODO
                            nodoEliminado = this.eliminarNodoAleatorio();
                            break;
                        case 4: // metodo strength con heap //TODO
                            nodoEliminado = this.eliminarNodoAleatorio();
                            break;
                        default:
                            nodoEliminado = this.eliminarNodoAleatorio();
                    }
                    if (nodoEliminado != 0){
                        Nodo<T> n = this.g.getListaNodos().get(nodoEliminado);
                        for (int j = 0; j < n.getListaDeEnlaces().size() ; j++) {
                            int id = n.getListaDeEnlaces().get(j).getNodoB();
                            Nodo<T> dest = g.getListaNodos().get(id);
                            int k = 0;
                            while (dest.getListaDeEnlaces().get(k).getNodoB() != n.getId())
                            {
                                k++;
                            }
                            dest.getListaDeEnlaces().remove(k);
                        }
                        n.eliminarEnlaces();
                    }
                }
                this.evaluar();
                outputfile.write(this.op + "," +
                        this.ncc + "," +
                        this.gcc + "," +
                        this.slcc + "\n");
            }
            outputfile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int eliminarNodoAleatorio() {
        //generar el nodo aleatorio i actualizar la lista de nodos activos
        int idRand = (int) (Math.random() * this.nNodosActivos);
        int idNodoEliminado = this.listaNodosActivos.get(idRand);
        this.listaNodosActivos.remove(idRand);
        this.nNodosActivos--;
        return idNodoEliminado;
    }

    private int eliminarNodoGrado() {
        int idNodoEliminado = 0, maxGrado = 0, j = 0;
        //encontrar id nodo con mas grado y actualizar la listaNodosActivos
        for (int i = 0; i < this.nNodosActivos ; i++) {
            int idnodo = this.listaNodosActivos.get(i);
            if (this.g.getListaNodos().get(idnodo).gradoNodo() >= maxGrado) {
                maxGrado = this.g.getListaNodos().get(idnodo).gradoNodo();
                idNodoEliminado = idnodo;
            }
        }
        this.nNodosActivos--;
        this.listaNodosActivos.remove((Integer) idNodoEliminado);
        return idNodoEliminado;
    }

    private int eliminarNodoStr() {
        //encontrar idNodo con mas strength y actualizar listaNodosActivos
        int idNodoEliminado = 0, j = 0;
        double maxStr = 0;
        for (int i = 0; i < this.nNodosActivos; i++) {
            int idnodo = this.listaNodosActivos.get(i);
            if (this.g.getListaNodos().get(idnodo).pesoTotalEnlacesNodo() >= maxStr) {
                maxStr = this.g.getListaNodos().get(idnodo).pesoTotalEnlacesNodo();
                idNodoEliminado = idnodo;
            }
        }
        this.nNodosActivos--;
        this.listaNodosActivos.remove((Integer) idNodoEliminado);
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
