package ed.tests;

import ed.grafo.Grafo;
import ed.grafo.Percolacion;

import javax.lang.model.type.NullType;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;


public class mainCLI {
    static int NPRUEBAS = 100;
    public static void main(String[] args) throws IOException {
        //Inicializaciones
        //Ficheros
        String[] nets = new String[5];
        nets[0] = "networks\\basico.net";
        nets[1] = "networks\\airports_UW.net";
        nets[2] = "networks\\email_URV-edges_betw.net";
        nets[3] = "networks\\powergrid_USA-edges_betw.net";
        nets[4] = "networks\\wtw2000-sym.net";

        Grafo<NullType> grafo;
        Percolacion<NullType> perc;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String opt;

        System.out.println("Analisis de percolacion de redes\n");
        System.out.println("1." + nets[0]);
        System.out.println("2." + nets[1]);
        System.out.println("3." + nets[2]);
        System.out.println("4." + nets[3]);
        System.out.println("5." + nets[4]);

        System.out.println("Escoja una red");
        opt = reader.readLine();
        while (!esRedValida(opt)) {
            System.out.println("Opcion no valida");
            opt = reader.readLine();
        }

        grafo = new Grafo<>(nets[Integer.parseInt(opt)-1]);
        perc = new Percolacion<>(grafo);

        System.out.println("1.Metodo aleatorio");
        System.out.println("2.Metodo grado");
        System.out.println("3.Metodo \"strength\"");
        System.out.println("4.Metodo grado con heap");
        System.out.println("5.Metodo \"strength\" con heap");
        System.out.println("Escoja un metodo de extirpacion");
        opt = reader.readLine();
        while (!esMetoValido(opt)) {
            System.out.println("Opcion no valida");
            opt = reader.readLine();
        }

        if (Integer.parseInt(opt) != 1) {
            long startTime = System.nanoTime();
            perc.evaluacionPercolacion(Integer.parseInt(opt)-1);
            long stopTime = System.nanoTime();
            System.out.print("Tiempo de ejecuion: " + (double)(stopTime - startTime)/1000000000);
        }
        else {
            long startTime = System.nanoTime();
            evaluacionMediaAleatoria(grafo, perc);
            long stopTime = System.nanoTime();
            System.out.print("Tiempo de ejecuion: " + ((double)(stopTime - startTime)/1000000000)/NPRUEBAS);
        }
        System.out.println(" segundos");

        //llamar al script de python
        Runtime.getRuntime().exec("python plot.py");
    }

    private static void evaluacionMediaAleatoria(Grafo<NullType> grafo, Percolacion<NullType> perc) throws IOException {
        perc.evaluacionPercolacion(0);
        List<String> lineas = Files.readAllLines(Paths.get("out.csv"));
        double [][] matrix = new double [lineas.size()-1][4];
        Iterator<String> it = lineas.iterator();
        int j = 0;
        String s = it.next();
        String[] str = s.split(",");
        FileWriter f = new FileWriter("out.csv");

        f.write(str[0] + ","
                + str[1] +","
                + str[2] +","
                + str[3] +"\n");
        while (it.hasNext()){
            s = it.next();
            str = s.split(",");
            matrix[j][0] = Double.parseDouble(str[0]);
            matrix[j][1] = Double.parseDouble(str[1]);
            matrix[j][2] = Double.parseDouble(str[2]);
            matrix[j][3] = Double.parseDouble(str[3]);
            j++;
        }
        for (int i = 1; i < NPRUEBAS; i++) {
            System.out.println((i*100/NPRUEBAS) + "%");
            perc = new Percolacion<>(grafo);
            perc.evaluacionPercolacion(0);
            lineas = Files.readAllLines(Paths.get("out.csv"));
            it = lineas.iterator();
            it.next();
            j = 0;
            while (it.hasNext()){
                s = it.next();
                str = s.split(",");
                matrix[j][0] += Double.parseDouble(str[0]);
                matrix[j][1] += Double.parseDouble(str[1]);
                matrix[j][2] += Double.parseDouble(str[2]);
                matrix[j][3] += Double.parseDouble(str[3]);
                j++;
            }
        }
        System.out.println(100 + "%");
        for (int i = 0; i < lineas.size()-1 ; i++) {
            f.write((matrix[i][0]/100) + ","
                    +(matrix[i][1]/100) +","
                    +(matrix[i][2]/100) +","
                    +(matrix[i][3]/100) +"\n");
        }
        f.close();
    }

    private static boolean esRedValida(String i) {
        try {
            return 1 <= Integer.parseInt(i) && Integer.parseInt(i) <= 5;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean esMetoValido(String i) {
        try {
            return 1 <= Integer.parseInt(i) && Integer.parseInt(i) <= 5;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
