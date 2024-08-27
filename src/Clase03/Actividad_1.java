package Clase03;

import java.util.ArrayList;

public class Actividad_1 {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1,"Agus",1.1));
        clientes.add(new Cliente(2,"Braian",1.2));
        clientes.add(new Cliente(3,"Juli",2.3));
        clientes.add(new Cliente(4,"Pepe",1.9));
        System.out.println("Scoring máximo "+scoringMaximo(clientes));
    }

    private static Cliente scoringMaximo(ArrayList<Cliente> clientes) {
        return scoringMaximo(clientes,0,clientes.size());
    }

    private static Cliente scoringMaximo(ArrayList<Cliente> clientes, int i, int f){
        if(i==f-1)return clientes.get(i);
        int mitad= (f+i)/2;
        Cliente izq = scoringMaximo(clientes,i,mitad);
        Cliente der = scoringMaximo(clientes,mitad,f);
        return izq.getScoring()>der.getScoring()?izq:der;
    }
}

class Cliente {
    private int idCliente;
    private String nombre;
    private double scoring;

    public Cliente(int idCliente, String nombre, double scoring) {
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

