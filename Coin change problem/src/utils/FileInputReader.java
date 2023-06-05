package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInputReader {

    public FileInputReader(){}
    public static Description read(String file){

        Description descripcion = null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int parametro1 = Integer.parseInt(br.readLine().trim());

            String[] numeros = br.readLine().trim().split(" ");
            int[] parametro2 = new int[numeros.length];
            for (int i = 0; i < numeros.length; i++) {
                parametro2[i] = Integer.parseInt(numeros[i]);
            }

            descripcion = new Description(parametro1, parametro2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return descripcion;
    }
}
