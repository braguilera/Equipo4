package Clase03;

import java.util.ArrayList;

public class Actividad_2 {
    private static int[] dosNumerosMaximos(ArrayList<Integer> numeros) {
        return dosNumerosMaximos(numeros, 0, numeros.size());
    }

    private static int[] dosNumerosMaximos(ArrayList<Integer> numeros, int i, int f) {
        if (i == f - 1) {
            return new int[]{numeros.get(i), -404}; //si la lista tiene solo 1 numero
        } else if (i == f - 2) {
            // Si sólo hay dos elementos, devolverlos en orden
            if (numeros.get(i) > numeros.get(i + 1)) {
                return new int[]{numeros.get(i), numeros.get(i + 1)};
            } else {
                return new int[]{numeros.get(i + 1), numeros.get(i)};
            }
        }

        int mitad = (i + f) / 2;
        int[] izq = dosNumerosMaximos(numeros, i, mitad);
        int[] der = dosNumerosMaximos(numeros, mitad, f);

        // Combinación: encontrar los dos mayores entre los cuatro posibles
        int max1, max2;
        if (izq[0] > der[0]) {
            max1 = izq[0];
            max2 = Math.max(izq[1], der[0]);
        } else {
            max1 = der[0];
            max2 = Math.max(der[1], izq[0]);
        }

        return new int[]{max1, max2};
    }

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(10);
        numeros.add(2);
        numeros.add(8);
        numeros.add(9);
        numeros.add(5);
        numeros.add(3);
        numeros.add(10);

        int[] resultado = dosNumerosMaximos(numeros);
        System.out.println("Los dos números mayores son: " + resultado[0] + " y " + resultado[1]);
    }

}

//f(x)=O(n)