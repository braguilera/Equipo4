package Clase05;

public class Actividad_2 {
    private int[][] matrizAdyacencia;
    private int numVertices;

    // Inicialización del grafo con un número fijo de vértices
    public Actividad_2(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Agregar arista entre dos vértices
    public void agregarArista(int origen, int destino) {
        if (esVerticeValido(origen) && esVerticeValido(destino)) {
            matrizAdyacencia[origen][destino] = 1;
        }
    }

    // Eliminar arista entre dos vértices
    public void eliminarArista(int origen, int destino) {
        if (esVerticeValido(origen) && esVerticeValido(destino)) {
            matrizAdyacencia[origen][destino] = 0;
        }
    }

    // Verificar si existe una arista entre dos vértices
    public boolean verificarArista(int origen, int destino) {
        if (esVerticeValido(origen) && esVerticeValido(destino)) {
            return matrizAdyacencia[origen][destino] == 1;
        }
        return false;
    }

    // Listar los vértices adyacentes a un vértice dado
    public void listarAdyacentes(int vertice) {
        if (esVerticeValido(vertice)) {
            System.out.print("Vértices adyacentes a " + vertice + ": ");
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }

    // Contar el grado de salida de un vértice (número de aristas que salen)
    public int contarGradoSalida(int vertice) {
        if (esVerticeValido(vertice)) {
            int gradoSalida = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    gradoSalida++;
                }
            }
            return gradoSalida;
        }
        return -1; // Retorna -1 si el vértice no es válido
    }

    // Contar el grado de entrada de un vértice (número de aristas que entran)
    public int contarGradoEntrada(int vertice) {
        if (esVerticeValido(vertice)) {
            int gradoEntrada = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    gradoEntrada++;
                }
            }
            return gradoEntrada;
        }
        return -1; // Retorna -1 si el vértice no es válido
    }

    // Método auxiliar para verificar si un vértice es válido
    private boolean esVerticeValido(int vertice) {
        return vertice >= 0 && vertice < numVertices;
    }

    public static void main(String[] args) {
        Actividad_2 grafo = new Actividad_2(5); // Grafo con 5 vértices

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        System.out.println("Verificar arista entre 0 y 1: " + grafo.verificarArista(0, 1));
        System.out.println("Verificar arista entre 1 y 3: " + grafo.verificarArista(1, 3));

        grafo.listarAdyacentes(0);
        grafo.listarAdyacentes(2);

        System.out.println("Grado de salida de 2: " + grafo.contarGradoSalida(2));
        System.out.println("Grado de entrada de 2: " + grafo.contarGradoEntrada(2));

        grafo.eliminarArista(2, 3);
        System.out.println("Verificar arista entre 2 y 3 después de eliminar: " + grafo.verificarArista(2, 3));
    }

}
