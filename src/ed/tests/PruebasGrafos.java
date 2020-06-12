package ed.tests;

import ed.grafo.Grafo;

import javax.lang.model.type.NullType;

public class PruebasGrafos {
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

        //Crear Grafo
        //Grafo<NullType> grafoTest1 = new Grafo<NullType>(nets[6]);
        //Grafo<NullType> grafoTest1 = new Grafo<NullType>(3);

        /*
         * Test1: funcionamiento correcto
         * fichero: basico.net
         */
        System.out.println("TEST1: FUNCIONAMIENTO CORRECTO");
        System.out.println("basico.net");
        Grafo<NullType> gTest1 = new Grafo<NullType>(nets[0]);
        gTest1.mostrarListaNodos();
        System.out.println();

        /*
         * Test2: funcionamiento correcto
         * fichero: airports_UW.net
         */
        System.out.println("TEST2: FUNCIONAMIENTO CORRECTO");
        System.out.println("airports_UW.net");
        Grafo<NullType> gTest2 = new Grafo<NullType>(nets[1]);
        gTest2.mostrarListaNodos();
        System.out.println();

        /*
         * Test3: funcionamiento correcto
         * fichero: email_URV-edges_betw.net
         */
        System.out.println("TEST3: FUNCIONAMIENTO CORRECTO");
        System.out.println("email_URV-edges_betw.net");
        Grafo<NullType> gTest3 = new Grafo<NullType>(nets[2]);
        gTest3.mostrarListaNodos();
        System.out.println();

        /*
         * Test4: error enlaces repetidos
         * fichero: enlaces_repetidos.net
         */
        System.out.println("TEST4: ERROR ENLACES REPETIDOS");
        System.out.println("enlaces_repetidos.net");
        Grafo<NullType> gTest4 = new Grafo<NullType>(nets[5]);
        gTest4.mostrarListaNodos();
        System.out.println();

        /*
         * Test5: error nodo de origen no creado
         * fichero: nodo_origen_no_creado.net
         */
        System.out.println("TEST5: ERROR NODO DE ORIGEN NO CREADO");
        System.out.println("nodo_origen_no_creado.net");
        Grafo<NullType> gTest5 = new Grafo<NullType>(nets[6]);
        gTest5.mostrarListaNodos();
        System.out.println();

        /*
         * Test6: error nodo de destino no creado
         * fichero: nodo_destino_no_creado.net
         */
        System.out.println("TEST6: ERROR NODO DE DESTINO NO CREADO");
        System.out.println("nodo_destino_no_creado.net");
        Grafo<NullType> gTest6 = new Grafo<NullType>(nets[7]);
        gTest6.mostrarListaNodos();
        System.out.println();

        /*
         * Test7:todos los errores anteriores en un mismo fichero
         * fichero: errores.net
         */
        System.out.println("TEST7: TODOS LOS ERRORES");
        System.out.println("errores.net");
        Grafo<NullType> gTest7 = new Grafo<NullType>(nets[8]);
        gTest7.mostrarListaNodos();
    }
}
