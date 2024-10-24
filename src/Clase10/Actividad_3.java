package Clase10;

public class Actividad_3 {
    private static final int N = 4;
    private static char[][] tablero;
    private static boolean[] columnasComputadoras;
    private static boolean[] columnasImpresoras;

    private static void colocarEquipos(int fila) {
        if (fila == N) {
            imprimirTablero();
            return;
        }

        // Intentar colocar una computadora en la fila actual
        for (int columna = 0; columna < N; columna++) {
            if (!columnasComputadoras[columna] && !columnasImpresoras[columna]) {
                tablero[fila][columna] = 'C';
                columnasComputadoras[columna] = true;
                colocarEquipos(fila + 1);
                columnasComputadoras[columna] = false;
                tablero[fila][columna] = '.';
            }
        }

        // Intentar colocar una impresora en la fila actual
        for (int columna = 0; columna < N; columna++) {
            if (!columnasComputadoras[columna] && !columnasImpresoras[columna]) {
                tablero[fila][columna] = 'I';
                columnasImpresoras[columna] = true;
                colocarEquipos(fila + 1);
                columnasImpresoras[columna] = false;
                tablero[fila][columna] = '.';
            }
        }
    }

    // Método para imprimir el tablero
    private static void imprimirTablero() {
        System.out.println("Configuración válida:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        tablero = new char[N][N];
        columnasComputadoras = new boolean[N];
        columnasImpresoras = new boolean[N];

        // Llena el tablero con espacios vacíos
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '.';
            }
        }

        colocarEquipos(0);
    }

}
