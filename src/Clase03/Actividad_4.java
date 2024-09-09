package Clase03;

import java.util.ArrayList;

public class Actividad_4 {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1,"Agus",1.1));
        clientes.add(new Cliente(2,"Braian",1.2));
        clientes.add(new Cliente(3,"Juli",2.3));
        clientes.add(new Cliente(4,"Pepe",1.9));
        clientes.add(new Cliente(5,"Leo",3.1));
        clientes.add(new Cliente(6,"Nina",2.7));

        int n = 3;
        System.out.println("Clientes con los " + n + " scorings más altos: ");
        ArrayList<Cliente> maximos = nMaximos(clientes, n);
        for (Cliente cliente : maximos) {
            System.out.println(cliente);
        }
    }

    private static ArrayList<Cliente> nMaximos(ArrayList<Cliente> clientes, int n) {
        return nMaximos(clientes, 0, clientes.size(), n);
    }

    private static ArrayList<Cliente> nMaximos(ArrayList<Cliente> clientes, int i, int f, int n) {
        ArrayList<Cliente> maximos = new ArrayList<>();
        if (f - i <= n) {
            for (int j = i; j < f; j++) {
                agregarSiEsMayor(maximos, clientes.get(j), n);
            }
            return maximos;
        }

        int mitad = (f + i) / 2;
        ArrayList<Cliente> izq = nMaximos(clientes, i, mitad, n);
        ArrayList<Cliente> der = nMaximos(clientes, mitad, f, n);

        for (Cliente cliente : izq) {
            agregarSiEsMayor(maximos, cliente, n);
        }
        for (Cliente cliente : der) {
            agregarSiEsMayor(maximos, cliente, n);
        }

        return maximos;
    }

    private static void agregarSiEsMayor(ArrayList<Cliente> maximos, Cliente cliente, int n) {
        if (maximos.size() < n) {
            maximos.add(cliente);
        } else {
            // Encuentra el menor scoring en la lista de maximos
            int menorIndice = 0;
            for (int k = 1; k < maximos.size(); k++) {
                if (maximos.get(k).getScoring() < maximos.get(menorIndice).getScoring()) {
                    menorIndice = k;
                }
            }
            // Reemplaza el menor si el actual es mayor
            if (cliente.getScoring() > maximos.get(menorIndice).getScoring()) {
                maximos.set(menorIndice, cliente);
            }
        }
    }
}

class Clientess {
    private int idCliente;
    private String nombre;
    private double scoring;

    public Clientess(int idCliente, String nombre, double scoring) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getScoring() {
        return scoring;
    }

    public void setScoring(double scoring) {
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", scoring=" + scoring +
                '}';
    }
}

//O(nlogn)