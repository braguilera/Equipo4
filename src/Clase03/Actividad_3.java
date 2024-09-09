package Clase03;

import java.util.ArrayList;

public class Actividad_3 {

    public static void main(String[] args) {
        ArrayList<Clientes> clientes = new ArrayList<>();
        clientes.add(new Clientes(1,"Agus",2.2));
        clientes.add(new Clientes(2,"Braian",1.2));
        clientes.add(new Clientes(3,"Juli",2.7));
        clientes.add(new Clientes(4,"Pepe",1.9));
        clientes.add(new Clientes(5,"Ana",2.3));
        Clientes[] maxClientes = scoringMaximos(clientes);
        System.out.println("Primer cliente con scoring máximo: " + maxClientes[0]);
        System.out.println("Segundo cliente con scoring máximo: " + maxClientes[1]);
    }

    private static Clientes[] scoringMaximos(ArrayList<Clientes> clientes) {
        return scoringMaximos(clientes, 0, clientes.size());
    }

    private static Clientes[] scoringMaximos(ArrayList<Clientes> clientes, int i, int f) {
        if (i == f - 1) {
            return new Clientes[]{clientes.get(i), null};
        }

        int mitad = (f + i) / 2;
        Clientes[] izq = scoringMaximos(clientes, i, mitad);
        Clientes[] der = scoringMaximos(clientes, mitad, f);

        return mergeMaximos(izq, der);
    }   

    private static Clientes[] mergeMaximos(Clientes[] izq, Clientes[] der) {
        Clientes[] maxClientes = new Clientes[2];

        // Compara y coloca el mayor scoring en la primera posición.
        if (izq[0].getScoring() > der[0].getScoring()) {
            maxClientes[0] = izq[0];
            maxClientes[1] = (izq[1] != null && izq[1].getScoring() > der[0].getScoring()) ? izq[1] : der[0];
        } else {
            maxClientes[0] = der[0];
            maxClientes[1] = (der[1] != null && der[1].getScoring() > izq[0].getScoring()) ? der[1] : izq[0];
        }

        return maxClientes;
    }
}

class Clientes {
    private int idCliente;
    private String nombre;
    private double scoring;

    public Clientes(int idCliente, String nombre, double scoring) {
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
        return " -> " +"idCliente="+idCliente+" nombre="+nombre+" scoring=" + scoring;
    }
}

//O(n)