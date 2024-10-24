package Clase7;

public class Actividad_1 {

    public static class FloydWarshall {

        void floydWarshall(int graph[][], int V) {
            int dist[][] = new int[V][V];
            // Inicializar la matriz de distancias
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = graph[i][j];
                }
            }
            // Actualizar la matriz de distancias
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            // Imprimir la matriz de distancias
            printSolution(dist, V);
        }

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


    }
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int graph[][] = {
                {0, 4, 7, INF},
                {INF, 0, INF, 1},
                {INF, INF, 0, INF},
                {INF, INF, 1, 0}
        };
        int V = graph.length;
        fw.floydWarshall(graph, V);
    }

}
