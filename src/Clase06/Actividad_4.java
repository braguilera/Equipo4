package Clase06;

public class Actividad_4 {
    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        int gananciaMaxima = fuerzaBruta(costos, ganancias, presupuesto, 0);
        System.out.println("Ganancia máxima (Fuerza Bruta): " + gananciaMaxima);
    }

    public static int fuerzaBruta(int[] costos, int[] ganancias, int presupuesto, int i) {
        if (i == costos.length) {
            return 0;
        }

        int sinTomar = fuerzaBruta(costos, ganancias, presupuesto, i + 1);

        int tomar = 0;
        if (costos[i] <= presupuesto) {
            tomar = ganancias[i] + fuerzaBruta(costos, ganancias, presupuesto - costos[i], i + 1);
        }

        return Math.max(sinTomar, tomar);
    }
}
