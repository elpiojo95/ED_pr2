package ed.tests;

import ed.grafo.Enlace;
import ed.grafo.Grafo;
import ed.grafo.MaxHeap;
import ed.grafo.Nodo;

import javax.lang.model.type.NullType;


public class PruebasHeap {
    public static void main(String[] args) {

        int count = 0, funciona;
        String[] nets = new String[3];
        nets[0] = "networks\\nets_test\\heap1.net";
        nets[1] = "networks\\nets_test\\heap2.net";
        nets[2] = "networks\\nets_test\\heap3.net";

        /*TEST GRADO*/
        System.out.println("HEAP GRADO:");
        System.out.println("Prueba 1:");
        Grafo<NullType> gg1 = new Grafo<>(nets[0]);
        MaxHeap<NullType> h = new MaxHeap<>();

        for (int i = 1; i <= gg1.getnNodos() ; i++) {
            h.add(gg1.getListaNodos().get(i));
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
        funciona = count;

        /*TEST2*/
        System.out.println("Prueba 2:");
        count = 0;
        Grafo<NullType> gg2 = new Grafo<>(nets[1]);
        for (int i = 1; i <= gg2.getnNodos() ; i++) {
            h.add(gg2.getListaNodos().get(i));
        }
        Nodo<NullType> n1 = new Nodo<>(9,null);
        Enlace e1 = new Enlace(1,100.0);
        Enlace e2 = new Enlace(5,300.0);
        Enlace e3 = new Enlace(6,50.0);
        Enlace e4 = new Enlace(2,62.58);
        Enlace e5 = new Enlace(8,64.2);

        n1.anadirEnlace(e1);
        n1.anadirEnlace(e2);
        n1.anadirEnlace(e3);
        n1.anadirEnlace(e4);
        n1.anadirEnlace(e5);

        if (h.ver().getId() == 4 ){
            System.out.println("t1: ok");
            count++;
        }
        h.add(n1);
        if (h.ver().getId() == 9){
            System.out.println("t2: ok");
            count++;
        }
        System.out.println("aciertos:" +count +"/2");
        funciona += count;

        /*TEST3*/
        System.out.println("Prueba 3:");
        while (!h.isVacio()) h.eliminar();
        count = 0;

        Grafo<NullType> gg3 = new Grafo<>(nets[2]);
        for (int i = 1; i <= gg3.getnNodos() ; i++) {
            h.add(gg3.getListaNodos().get(i));
        }
        if (h.ver().getId() == 6){
            System.out.println("t1: ok");
            count++;
        }
        h.verYeliminar();
        if (h.ver().getId() == 5){
            System.out.println("t2: ok");
            count++;
        }
        h.verYeliminar();
        if (h.ver().getId() == 4){
            System.out.println("t3: ok");
            count++;
        }
        h.verYeliminar();
        if (h.ver().getId() == 3){
            System.out.println("t4: ok");
            count++;
        }
        h.verYeliminar();
        if (h.ver().getId() == 2){
            System.out.println("t5: ok");
            count++;
        }
        h.verYeliminar();
        if (h.ver().getId() == 1){
            System.out.println("t6: ok");
            count++;
        }
        h.verYeliminar();
        if (h.isVacio()){
            System.out.println("t7: ok");
            count++;
        }
        System.out.println("aciertos:" +count +"/7");
        funciona += count;
        funciona = (funciona*100/18);
        System.out.println("test ha passado el: " +funciona +"% de las pruebas");
        System.out.println();

        /*STRENGTH*/
        count = 0;
        System.out.println("HEAP STRENGTH");
        System.out.println("Prueba 1:");
        Grafo<NullType> g = new Grafo<>(nets[0]);
        MaxHeap<NullType> h2 = new MaxHeap<>(true);
        /*TEST1*/
        for (int i = 1; i <= g.getnNodos() ; i++) {
            h2.add(g.getListaNodos().get(i));
        }

        if (h2.ver().getId() == 8){
            System.out.println("t1: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 2){
            System.out.println("t2: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 6){
            System.out.println("t3: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 3){
            System.out.println("t4: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 4){
            System.out.println("t5: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 5){
            System.out.println("t6: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 7){
            System.out.println("t7: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 1){
            System.out.println("t8: ok");
            count++;
        }
        h2.eliminar();
        if (h2.isVacio()){
            System.out.println("t9: ok");
            count++;
        }
        System.out.println("aciertos:" +count +"/9");
        funciona = count;

        /*TEST2*/
        System.out.println("Prueba 2:");
        while (!h2.isVacio()) h2.eliminar();
        count = 0;
        Grafo<NullType> g2 = new Grafo<>(nets[1]);
        for (int i = 1; i <= g2.getnNodos() ; i++) {
            h2.add(g2.getListaNodos().get(i));
        }
        if (h2.ver().getId() == 3){
            System.out.println("t1: ok");
            count++;
        }
        h2.add(n1);
        if (h2.ver().getId() == 9){
            System.out.println("t2: ok");
            count++;
        }
        System.out.println("aciertos:" +count +"/2");
        funciona += count;

        /*TEST3*/
        System.out.println("Prueba 3:");
        while (!h2.isVacio()) h2.eliminar();
        count = 0;

        Grafo<NullType> g3 = new Grafo<>(nets[2]);
        for (int i = 1; i <= g3.getnNodos() ; i++) {
            h2.add(g3.getListaNodos().get(i));
        }

        if (h2.ver().getId() == 5){
            System.out.println("t1: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 6){
            System.out.println("t2: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 4){
            System.out.println("t3: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 3){
            System.out.println("t4: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 2){
            System.out.println("t5: ok");
            count++;
        }
        h2.eliminar();
        if (h2.ver().getId() == 1){
            System.out.println("t6: ok");
            count++;
        }
        h2.eliminar();
        if (h2.isVacio()){
            System.out.println("t7: ok");
            count++;
        }
        System.out.println("aciertos:" +count +"/7");
        funciona += count;
        funciona = (funciona*100/18);
        System.out.println("test ha passado el: " +funciona +"% de las pruebas");
    }
}
