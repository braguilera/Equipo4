package Clase06;

public class Actividad_3 {
    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int beneficioMaximo = seleccionarProyectos(costos, beneficios, presupuesto);
        System.out.println("El beneficio máximo es: " + beneficioMaximo);
    }

    public static int seleccionarProyectos(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] tabla = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            int costoProyecto = costos[i - 1];
            int beneficioProyecto = beneficios[i - 1];
            for (int w = 1; w <= presupuesto; w++) {
                if (costoProyecto <= w) {
                    tabla[i][w] = Math.max(tabla[i - 1][w], tabla[i - 1][w - costoProyecto] + beneficioProyecto);
                } else {
                    tabla[i][w] = tabla[i - 1][w];
                }
            }
        }

        return tabla[n][presupuesto]; //si el valor optoimo esta en el utlimo valor de la celda
    }

}
