package Clase03;

import java.util.ArrayList;

public class Actividad_1 {

    public static void main(String[] args) {
        ArrayList<Clientes> clientes = new ArrayList<>();
        clientes.add(new Clientes(1,"Agus",1.1));
        clientes.add(new Clientes(2,"Braian",1.2));
        clientes.add(new Clientes(3,"Juli",2.3));
        clientes.add(new Clientes(4,"Pepe",1.9));
        System.out.println("Scoring máximo "+scoringMaximo(clientes));
    }

    private static Clientes scoringMaximo(ArrayList<Clientes> clientes) {
        return scoringMaximo(clientes,0,clientes.size());
    }

    private static Clientes scoringMaximo(ArrayList<Clientes> clientes, int i, int f){
        if(i==f-1)return clientes.get(i);
        int mitad= (f+i)/2;
        Clientes izq = scoringMaximo(clientes,i,mitad);
        Clientes der = scoringMaximo(clientes,mitad,f);
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

//f(n)=O(n)