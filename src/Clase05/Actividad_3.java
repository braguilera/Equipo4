package Clase05;

import java.util.*;

public class Actividad_3 {
    private static final int INF = Integer.MAX_VALUE;

    public static void primMST(int numVertices, List<List<int[]>> graph) {
        int[] key = new int[numVertices];
        int[] parent = new int[numVertices];
        boolean[] inMST = new boolean[numVertices];

        Arrays.fill(key, INF);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minKey(numVertices, key, inMST);
            inMST[u] = true;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                }
            }
        }

        printMST(parent, numVertices, graph);
    }

    private static int minKey(int numVertices, int[] key, boolean[] inMST) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printMST(int[] parent, int numVertices, List<List<int[]>> graph) {
        int costoTotal = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < numVertices; i++) {
            for (int[] neighbor : graph.get(i)) {
                if (neighbor[0] == parent[i]) {
                    System.out.println(parent[i] + " - " + i + "\t" + neighbor[1]);
                    costoTotal += neighbor[1];
                }
            }
        }
        System.out.println("Costo total del Árbol de Recubrimiento Mínimo: " + costoTotal);
    }

    public static void main(String[] args) {
        int numVertices = 4;
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new int[]{1, 1});
        graph.get(0).add(new int[]{2, 4});
        graph.get(1).add(new int[]{0, 1});
        graph.get(1).add(new int[]{3, 3});
        graph.get(2).add(new int[]{0, 4});
        graph.get(2).add(new int[]{3, 2});
        graph.get(3).add(new int[]{1, 3});
        graph.get(3).add(new int[]{2, 2});

        primMST(numVertices, graph);
    }
}
