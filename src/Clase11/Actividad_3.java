package Clase11;
import java.util.*;

// Clase Almacen que representa un almacén
class Almacen {
    private int id;
    private String nombre;

    // Constructor
    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos para obtener el ID y el nombre del almacén
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

// Clase Grafo para gestionar la red de almacenes
class Grafo {
    private Map<Integer, Almacen> almacenes;
    private LinkedList<Integer>[] adj;
    private int V;

    // Constructor
    public Grafo(int V) {
        this.V = V;
        almacenes = new HashMap<>();
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Método para agregar un almacén al grafo
    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
    }

    // Método para conectar almacenes mediante una ruta directa
    public void conectarAlmacenes(int id1, int id2) {
        adj[id1].add(id2);
        adj[id2].add(id1); // Asumimos que las rutas son bidireccionales
    }

    // Método para realizar un recorrido DFS desde un almacén de inicio
    public void DFS(int inicio) {
        boolean[] visitado = new boolean[V];
        System.out.println("Recorrido DFS desde " + almacenes.get(inicio).getNombre() + ":");
        DFSUtil(inicio, visitado);
        System.out.println();
    }

    // Método auxiliar recursivo para DFS
    private void DFSUtil(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(almacenes.get(v).getNombre() + " ");

        for (int n : adj[v]) {
            if (!visitado[n]) {
                DFSUtil(n, visitado);
            }
        }
    }

    // Método para realizar un recorrido BFS desde un almacén de inicio
    public void BFS(int inicio) {
        boolean[] visitado = new boolean[V];
        LinkedList<Integer> cola = new LinkedList<>();

        visitado[inicio] = true;
        cola.add(inicio);

        System.out.println("Recorrido BFS desde " + almacenes.get(inicio).getNombre() + ":");
        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(almacenes.get(actual).getNombre() + " ");

            for (int n : adj[actual]) {
                if (!visitado[n]) {
                    visitado[n] = true;
                    cola.add(n);
                }
            }
        }
        System.out.println();
    }
}

// Clase principal para probar la funcionalidad
public class Actividad_3 {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo(5); // Crear un grafo para 5 almacenes

        // Crear almacenes
        Almacen a1 = new Almacen(0, "Almacen A");
        Almacen a2 = new Almacen(1, "Almacen B");
        Almacen a3 = new Almacen(2, "Almacen C");
        Almacen a4 = new Almacen(3, "Almacen D");
        Almacen a5 = new Almacen(4, "Almacen E");

        // Agregar almacenes a la red
        redAlmacenes.agregarAlmacen(a1);
        redAlmacenes.agregarAlmacen(a2);
        redAlmacenes.agregarAlmacen(a3);
        redAlmacenes.agregarAlmacen(a4);
        redAlmacenes.agregarAlmacen(a5);

        // Conectar almacenes entre sí mediante rutas directas
        redAlmacenes.conectarAlmacenes(0, 1);
        redAlmacenes.conectarAlmacenes(0, 2);
        redAlmacenes.conectarAlmacenes(1, 3);
        redAlmacenes.conectarAlmacenes(2, 4);

        // Realizar recorridos DFS y BFS desde el almacén A (id = 0)
        redAlmacenes.DFS(0);
        redAlmacenes.BFS(0);
    }
}
