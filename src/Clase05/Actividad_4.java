package Clase05;

import java.util.*;

public class Actividad_4 {

    // Clase para representar el grafo
    public static class Grafo {
        private Map<String, List<Arista>> listaAdyacencia;
        private Map<String, Integer> indiceVertice;
        private int contadorIndice;

        // Constructor
        public Grafo() {
            listaAdyacencia = new HashMap<>();
            indiceVertice = new HashMap<>();
            contadorIndice = 0;
        }

        // Método para agregar un vértice
        public void agregarVertice(String vertice) {
            if (!listaAdyacencia.containsKey(vertice)) {
                listaAdyacencia.put(vertice, new ArrayList<>());
                indiceVertice.put(vertice, contadorIndice++);
            }
        }

        // Método para agregar una arista
        public void agregarArista(String vertice1, String vertice2, int tiempo) {
            listaAdyacencia.get(vertice1).add(new Arista(vertice2, tiempo));
            listaAdyacencia.get(vertice2).add(new Arista(vertice1, tiempo));
        }

        // Método para obtener la lista de adyacencia
        public Map<String, List<Arista>> getListaAdyacencia() {
            return listaAdyacencia;
        }

        // Método para obtener el índice de un vértice
        public int getIndice(String vertice) {
            return indiceVertice.get(vertice);
        }

        // Clase para representar una arista en el grafo
        private static class Arista {
            String destino;
            int tiempo;

            Arista(String destino, int tiempo) {
                this.destino = destino;
                this.tiempo = tiempo;
            }
        }
    }

    // Clase para implementar el algoritmo de Dijkstra
    public static class AlgoritmoDijkstra {
        public static void dijkstra(String origen, Grafo grafo) {
            Map<String, List<Grafo.Arista>> listaAdyacencia = grafo.getListaAdyacencia();
            PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(a -> a.tiempo));
            Map<String, Integer> tiempos = new HashMap<>();
            Set<String> visitados = new HashSet<>();

            // Inicialización
            for (String vertice : listaAdyacencia.keySet()) {
                tiempos.put(vertice, Integer.MAX_VALUE);
            }
            tiempos.put(origen, 0);
            colaPrioridad.add(new Arista(origen, 0));

            while (!colaPrioridad.isEmpty()) {
                Arista aristaActual = colaPrioridad.poll();
                String verticeActual = aristaActual.destino;

                if (visitados.contains(verticeActual)) continue;
                visitados.add(verticeActual);

                // Procesar vecinos
                for (Grafo.Arista vecino : listaAdyacencia.get(verticeActual)) {
                    String destino = vecino.destino;
                    int tiempo = vecino.tiempo;

                    int tiempoNuevo = tiempos.get(verticeActual) + tiempo;
                    if (tiempoNuevo < tiempos.get(destino)) {
                        tiempos.put(destino, tiempoNuevo);
                        colaPrioridad.add(new Arista(destino, tiempoNuevo));
                    }
                }
            }

            // Mostrar los resultados
            mostrarResultados(origen, tiempos);
        }

        private static void mostrarResultados(String origen, Map<String, Integer> tiempos) {
            System.out.println("Centro de Distribución Principal: " + origen);
            System.out.println("Tiempo Mínimo de Entrega a Cada Ciudad:");
            for (Map.Entry<String, Integer> entry : tiempos.entrySet()) {
                String ciudad = entry.getKey();
                int tiempo = entry.getValue();
                System.out.println("Ciudad: " + ciudad + ", Tiempo: " + (tiempo == Integer.MAX_VALUE ? "Inaccesible" : tiempo + " minutos"));
            }
        }

        // Clase para representar una arista en el algoritmo de Dijkstra
        private static class Arista {
            String destino;
            int tiempo;

            Arista(String destino, int tiempo) {
                this.destino = destino;
                this.tiempo = tiempo;
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregar vértices
        grafo.agregarVertice("Centro1");
        grafo.agregarVertice("Centro2");
        grafo.agregarVertice("Centro3");
        grafo.agregarVertice("Centro4");
        grafo.agregarVertice("Centro5");

        // Agregar aristas con tiempos
        grafo.agregarArista("Centro1", "Centro2", 10);  // Tiempo de 10 minutos
        grafo.agregarArista("Centro1", "Centro3", 15);  // Tiempo de 15 minutos
        grafo.agregarArista("Centro2", "Centro3", 12);  // Tiempo de 12 minutos
        grafo.agregarArista("Centro2", "Centro4", 20);  // Tiempo de 20 minutos
        grafo.agregarArista("Centro3", "Centro4", 10);  // Tiempo de 10 minutos
        grafo.agregarArista("Centro3", "Centro5", 30);  // Tiempo de 30 minutos
        grafo.agregarArista("Centro4", "Centro5", 25);  // Tiempo de 25 minutos

        // Aplicar el algoritmo de Dijkstra
        AlgoritmoDijkstra.dijkstra("Centro1", grafo);
    }
}
