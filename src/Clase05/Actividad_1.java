package Clase05;
import java.util.*;

class Usuario {
    private String id;
    private String nombre;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}

class Follower {
    private Map<Usuario, List<Usuario>> followers;

    public Follower() {
        this.followers = new HashMap<>();
    }

    public boolean agregarUsuario(Usuario usuario) {
        if (!followers.containsKey(usuario)) {
            followers.put(usuario, new ArrayList<>());
            return true;
        }
        return false; // El usuario ya existe
    }

    public boolean agregarSeguidor(Usuario usuario, Usuario seguidor) {
        if (followers.containsKey(usuario) && followers.containsKey(seguidor)) {
            List<Usuario> listaSeguidores = followers.get(usuario);
            if (!listaSeguidores.contains(seguidor)) {
                listaSeguidores.add(seguidor);
                return true;
            }
        }
        return false; // El usuario o el seguidor no existen o ya sigue
    }

    public boolean dejarDeSeguir(Usuario usuario, Usuario seguidor) {
        if (followers.containsKey(usuario) && followers.containsKey(seguidor)) {
            List<Usuario> listaSeguidores = followers.get(usuario);
            if (listaSeguidores.contains(seguidor)) {
                listaSeguidores.remove(seguidor);
                return true;
            }
        }
        return false; // El usuario o el seguidor no existen o no sigue
    }

    public List<Usuario> listarSeguidores(Usuario usuario) {
        if (followers.containsKey(usuario)) {
            return followers.get(usuario);
        }
        return new ArrayList<>(); // El usuario no existe
    }

    public List<Usuario> listarSeguidoresDe(Usuario seguidor) {
        List<Usuario> resultado = new ArrayList<>();
        for (Map.Entry<Usuario, List<Usuario>> entry : followers.entrySet()) {
            if (entry.getValue().contains(seguidor)) {
                resultado.add(entry.getKey());
            }
        }
        return resultado;
    }
}

public class Actividad_1 {
    public static void main(String[] args) {
        Follower redSocial = new Follower();

        Usuario juan = new Usuario("1", "Juan");
        Usuario maria = new Usuario("2", "Maria");
        Usuario pedro = new Usuario("3", "Pedro");

        redSocial.agregarUsuario(juan);
        redSocial.agregarUsuario(maria);
        redSocial.agregarUsuario(pedro);

        redSocial.agregarSeguidor(juan, maria);
        redSocial.agregarSeguidor(maria, pedro);
        redSocial.agregarSeguidor(pedro, juan);

        System.out.println("Usuarios que sigue Juan: " + redSocial.listarSeguidores(juan));
        System.out.println("Usuarios que sigue Maria: " + redSocial.listarSeguidores(maria));
        System.out.println("Usuarios que sigue Pedro: " + redSocial.listarSeguidores(pedro));

        System.out.println("Usuarios que siguen a Juan: " + redSocial.listarSeguidoresDe(juan));
        System.out.println("Usuarios que siguen a Maria: " + redSocial.listarSeguidoresDe(maria));
        System.out.println("Usuarios que siguen a Pedro: " + redSocial.listarSeguidoresDe(pedro));

        redSocial.dejarDeSeguir(juan, maria);
        System.out.println("Usuarios que sigue Juan después de dejar de seguir a Maria: " + redSocial.listarSeguidores(juan));
    }
}