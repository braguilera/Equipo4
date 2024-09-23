package Clase7;

import java.util.Scanner;

public class Actividad_3 {

    public static class FloydWarshall {

        void floydWarshall(int graph[][], int V) {
            int dist[][] = new int[V][V];    // Matriz de distancias mínimas
            int next[][] = new int[V][V];    // Matriz de predecesores para reconstruir el camino

            // Inicializar la matriz de distancias y predecesores
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = graph[i][j];
                    if (graph[i][j] != INF && i != j) {
                        next[i][j] = j;  // El predecesor de j en el camino desde i es j si hay una arista directa
                    } else {
                        next[i][j] = -1; // No hay predecesor si no hay camino directo
                    }
                }
            }

            // Actualizar la matriz de distancias y predecesores usando Floyd-Warshall
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            next[i][j] = next[i][k]; // Actualizar predecesor
                        }
                    }
                }
            }

            // Imprimir la matriz de distancias
            printSolution(dist, V);

            // Solicitar origen y destino para encontrar el camino más corto
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese el vértice de origen: ");
            int origen = sc.nextInt();
            System.out.print("Ingrese el vértice de destino: ");
            int destino = sc.nextInt();

            // Imprimir el camino más corto y la distancia
            printShortestPath(origen, destino, dist, next);
        }

        // Función para imprimir la matriz de distancias más cortas
        void printSolution(int dist[][], int V) {
            System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] == INF)
                        System.out.print("INF ");
                    else
                        System.out.print(dist[i][j] + "   ");
                }
                System.out.println();
            }
        }

        // Función para imprimir el camino más corto entre origen y destino
        void printShortestPath(int origen, int destino, int dist[][], int next[][]) {
            if (dist[origen][destino] == INF) {
                System.out.println("No existe un camino entre " + origen + " y " + destino);
                return;
            }

            System.out.println("La distancia más corta entre " + origen + " y " + destino + " es: " + dist[origen][destino]);
            System.out.print("El camino más corto es: ");
            printPath(origen, destino, next);
            System.out.println();
        }

        // Función recursiva para reconstruir el camino más corto utilizando la matriz de predecesores
        void printPath(int origen, int destino, int next[][]) {
            if (origen == destino) {
                System.out.print(origen);
                return;
            }
            if (next[origen][destino] == -1) {
                System.out.print("No hay camino disponible");
                return;
            }

            System.out.print(origen + " -> ");
            printPath(next[origen][destino], destino, next);
        }
    }

    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();

        // Matriz de adyacencia con tiempos de viaje (positivos y negativos)
        int graph[][] = {
                {0, 2, INF, 5},
                {INF, 0, INF, 4},
                {INF, INF, 0, INF},
                {INF, INF, 2, 0}
        };

        int V = graph.length;
        fw.floydWarshall(graph, V);
    }
}
