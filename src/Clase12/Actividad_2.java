package Clase12;

import java.util.*;

class Nodo {
    String destino;
    int costo;

    public Nodo(String destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }
}

class Grafo {
    private Map<String, List<Nodo>> adyacencia = new HashMap<>();

    public void agregarConexion(String origen, String destino, int costo) {
        adyacencia.putIfAbsent(origen, new ArrayList<>());
        adyacencia.get(origen).add(new Nodo(destino, costo));
    }

    public List<Nodo> obtenerVecinos(String nodo) {
        return adyacencia.getOrDefault(nodo, new ArrayList<>());
    }
}

public class Actividad_2 {
    public static int encontrarCaminoMenorCosto(Grafo grafo, String inicio, String destino) {
        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.costo));
        Map<String, Integer> costoMinimo = new HashMap<>();

        cola.add(new Nodo(inicio, 0));
        costoMinimo.put(inicio, 0);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();

            if (actual.destino.equals(destino)) {
                return actual.costo;
            }

            for (Nodo vecino : grafo.obtenerVecinos(actual.destino)) {
                int nuevoCosto = actual.costo + vecino.costo;

                if (nuevoCosto < costoMinimo.getOrDefault(vecino.destino, Integer.MAX_VALUE)) {
                    costoMinimo.put(vecino.destino, nuevoCosto);
                    cola.add(new Nodo(vecino.destino, nuevoCosto));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.agregarConexion("A", "B", 100);
        grafo.agregarConexion("A", "C", 150);
        grafo.agregarConexion("B", "D", 200);
        grafo.agregarConexion("C", "D", 100);
        grafo.agregarConexion("D", "E", 50);

        int costoMinimo = encontrarCaminoMenorCosto(grafo, "A", "E");

        if (costoMinimo != -1) {
            System.out.println("El costo mínimo de A a E es: " + costoMinimo);
        } else {
            System.out.println("No existe un camino de A a E.");
        }
    }
}
