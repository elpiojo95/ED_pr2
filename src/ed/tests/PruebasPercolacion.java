package ed.tests;

import ed.grafo.*;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

        Grafo<NullType> gTest1 = new Grafo<>(nets[2]);
        Percolacion<NullType> pTest1 = new Percolacion<>(gTest1);
        pTest1.evaluacionPercolacion('R');

        try {
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
            for (int i = 1; i < 100; i++) {
                gTest1 = new Grafo<>(nets[2]);
                pTest1 = new Percolacion<>(gTest1);
                pTest1.evaluacionPercolacion('R');
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
            for (int i = 0; i < lineas.size()-1 ; i++) {
                f.write((matrix[i][0]/100) + ","
                        +(matrix[i][1]/100) +","
                        +(matrix[i][2]/100) +","
                        +(matrix[i][3]/100) +"\n");
            }
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
