package ed.tests;

import ed.grafo.*;

import javax.lang.model.type.NullType;

public class PruebasPercolacion {
    public static void main(String[] args) {
        //Ficheros
        String[] nets = new String[9];
        nets[0] = "networks\\basico.net";
        nets[1] = "networks\\airports_UW.net";
        nets[2] = "networks\\email_URV-edges_betw.net";
        nets[3] = "networks\\powergrid_USA-edges_betw.net";
        nets[4] = "networks\\wtw2000-sym.net";
        nets[5] = "networks\\enlaces_repetidos.net";
        nets[6] = "networks\\nodo_origen_no_creado.net";
        nets[7] = "networks\\nodo_destino_no_creado.net";
        nets[8] = "networks\\errores.net";

        Grafo<NullType> gTest1 = new Grafo<>(nets[0]);
        Percolacion<NullType> pTest1 = new Percolacion<>(gTest1);
        System.out.println("OP: " +pTest1.getOp());
        System.out.println("NCC: " +pTest1.getNcc());
        System.out.println("GCC: " +pTest1.getGcc());
        System.out.println("SLCC: " +pTest1.getSlcc());
    }
}
