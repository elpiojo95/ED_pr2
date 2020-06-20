package ed.tests;

import ed.grafo.Enlace;
import ed.grafo.Grafo;
import ed.grafo.MaxHeap;
import ed.grafo.Nodo;

import javax.lang.model.type.NullType;

public class PruebasHeap {
    public static void main(String[] args) {

        int count = 0;
        String[] nets = new String[3];
        nets[0] = "networks\\nets_test\\heap1.net";
        nets[1] = "networks\\nets_test\\heap2.net";
        nets[2] = "networks\\nets_test\\noConexa.net";

        /*TEST GRADO*/
        Grafo<NullType> g = new Grafo<>(nets[0]);
        MaxHeap<NullType> h = new MaxHeap<>();

        for (int i = 1; i <= g.getnNodos() ; i++) {
            h.add(g.getListaNodos().get(i));
        }

        if (h.ver().getId() == 8){
            System.out.println("t1: ok");
            count++;
        }
        h.eliminar();
        if (h.ver().getId() == 2){
            System.out.println("t2: ok");
            count++;
        }
        h.eliminar();
        if (h.ver().getId() == 3){
            System.out.println("t3: ok");
            count++;
        }
        h.eliminar();
        if (h.ver().getId() == 6){
            System.out.println("t4: ok");
            count++;
        }
        h.eliminar();
        if (h.ver().getId() == 5){
            System.out.println("t5: ok");
            count++;
        }
        h.eliminar();
        if (h.ver().getId() == 1){
            System.out.println("t6: ok");
            count++;
        }
        h.eliminar();
        if (h.ver().getId() == 7){
            System.out.println("t7: ok");
            count++;
        }
        h.eliminar();
        if (h.ver().getId() == 4){
            System.out.println("t8: ok");
            count++;
        }
        h.eliminar();
        if (h.isVacio()){
            System.out.println("t9: ok");
            count++;
        }
        System.out.println("aciertos:" +count +"/9");

        /*TEST2*/
        count = 0;
        Grafo<NullType> g2 = new Grafo<>(nets[1]);
        for (int i = 1; i <= g2.getnNodos() ; i++) {
            h.add(g2.getListaNodos().get(i));
        }
        Nodo<NullType> n1 = new Nodo<>(9,null);
        Enlace e1 = new Enlace(1,20.5);
        Enlace e2 = new Enlace(5,25.6);
        Enlace e3 = new Enlace(6,85.0);
        Enlace e4 = new Enlace(2,62.58);
        Enlace e5 = new Enlace(8,64.2);

        n1.anadirEnlace(e1);
        n1.anadirEnlace(e2);
        n1.anadirEnlace(e3);
        n1.anadirEnlace(e4);
        n1.anadirEnlace(e5);

        if (h.ver().getId() == 4){
            System.out.println("t1: ok");
            count++;
        }
        h.add(n1);
        if (h.ver().getId() == 9){
            System.out.println("t2: ok");
            count++;
        }
        System.out.println("aciertos:" +count +"/2");








    }
}
