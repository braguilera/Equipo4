package Clase7;

public class Actividad_2 {

    public static class FloydWarshall {

        void floydWarshall(int graph[][], int V) {
            int dist[][] = new int[V][V];

            // Inicializar la matriz de distancias
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = graph[i][j];
                }
            }

            // Actualizar la matriz de distancias usando Floyd-Warshall
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            // Imprimir la matriz de distancias
            printSolution(dist, V);

            // Verificar si hay ciclos negativos
            detectNegativeCycle(dist, V);
        }

        void printSolution(int dist[][], int V) {
            System.out.println("Matriz de distancias más cortas entre cada par de centros de distribución:");
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

        void detectNegativeCycle(int dist[][], int V) {
            boolean hasNegativeCycle = false;
            for (int i = 0; i < V; i++) {
                if (dist[i][i] < 0) {
                    hasNegativeCycle = true;
                    break;
                }
            }

            if (hasNegativeCycle) {
                System.out.println("¡Se ha detectado un ciclo negativo en el sistema de rutas!");
            } else {
                System.out.println("No se han detectado ciclos negativos.");
            }
        }

    }

    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        // Matriz de adyacencia con tiempos de viaje (positivos y negativos)
        int graph[][] = {
                {0, 2, INF, -5},
                {INF, 0, INF, 4},
                {INF, INF, 0, INF},
                {INF, INF, 2, 0}
        };
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }
}
