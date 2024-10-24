package Clase10;

import java.util.Arrays;

public class Actividad_2 {
    private static final int N = 4;
    private static int[] posiciones;

    private static void colocarElementos(int fila) {
        if (fila == N) {
            imprimirTablero();
            return;
        }

        for (int columna = 0; columna < N; columna++) {
            if (esPosicionValida(fila, columna)) {
                posiciones[fila] = columna;
                colocarElementos(fila + 1);
                posiciones[fila] = -1;
            }
        }
    }

    private static boolean esPosicionValida(int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (posiciones[i] == columna) {
                return false;
            }
        }
        return true;
    }

    private static void imprimirTablero() {
        System.out.println("Configuración:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (posiciones[i] == j) {
                    System.out.print("E ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        posiciones = new int[N];
        Arrays.fill(posiciones, -1);
        colocarElementos(0);
    }

}
