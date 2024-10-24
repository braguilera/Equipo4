package Clase11;
import java.util.*;

// Clase Usuario que representa un nodo en la red social
class Usuario {
    private int id;
    private String nombre;

    // Constructor
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Obtener el ID del usuario
    public int getId() {
        return id;
    }

    // Obtener el nombre del usuario
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

// Clase RedSocial que gestiona el grafo de usuarios y amistades
class RedSocial {
    private Map<Integer, Usuario> usuarios;
    private LinkedList<Integer>[] amistades;
    private int V;


    public RedSocial(int V) {
        this.V = V;
        usuarios = new HashMap<>();
        amistades = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            amistades[i] = new LinkedList<>();
        }
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    // Método para conectar dos usuarios como amigos (relación bidireccional)
    public void conectarAmigos(int id1, int id2) {
        amistades[id1].add(id2);
        amistades[id2].add(id1); // Relación bidireccional
    }

    // Método para realizar un recorrido DFS desde un usuario de inicio
    public void DFS(int inicio) {
        boolean[] visitado = new boolean[V];
        System.out.println("Recorrido DFS desde " + usuarios.get(inicio).getNombre() + ":");
        DFSUtil(inicio, visitado);
        System.out.println();
    }

    // Método auxiliar recursivo para DFS
    private void DFSUtil(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(usuarios.get(v).getNombre() + " ");

        for (int n : amistades[v]) {
            if (!visitado[n]) {
                DFSUtil(n, visitado);
            }
        }
    }

    // Método para realizar un recorrido BFS desde un usuario de inicio
    public void BFS(int inicio) {
        boolean[] visitado = new boolean[V];
        LinkedList<Integer> cola = new LinkedList<>();

        visitado[inicio] = true;
        cola.add(inicio);

        System.out.println("Recorrido BFS desde " + usuarios.get(inicio).getNombre() + ":");
        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(usuarios.get(actual).getNombre() + " ");

            for (int n : amistades[actual]) {
                if (!visitado[n]) {
                    visitado[n] = true;
                    cola.add(n);
                }
            }
        }
        System.out.println();
    }
}

// Clase principal para probar la funcionalidad de la red social
public class Actividad_4 {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial(5);

        // Crear usuarios
        Usuario u1 = new Usuario(0, "Carlos");
        Usuario u2 = new Usuario(1, "Ana");
        Usuario u3 = new Usuario(2, "Pedro");
        Usuario u4 = new Usuario(3, "Lucía");
        Usuario u5 = new Usuario(4, "María");

        // Agregar usuarios a la red social
        redSocial.agregarUsuario(u1);
        redSocial.agregarUsuario(u2);
        redSocial.agregarUsuario(u3);
        redSocial.agregarUsuario(u4);
        redSocial.agregarUsuario(u5);

        // Conectar usuarios como amigos
        redSocial.conectarAmigos(0, 1);
        redSocial.conectarAmigos(0, 2);
        redSocial.conectarAmigos(1, 3);
        redSocial.conectarAmigos(2, 4);

        // Realizar recorridos DFS y BFS desde el usuario "Carlos"
        redSocial.DFS(0);
        redSocial.BFS(0);
    }
}
