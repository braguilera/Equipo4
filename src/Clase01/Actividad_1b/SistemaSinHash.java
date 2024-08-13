package Clase01.Actividad_1b;

import java.util.ArrayList;

public class SistemaSinHash {
    private ArrayList<Cliente> clientes;
    private ArrayList<Factura> facturas;

    public SistemaSinHash(ArrayList<Cliente> clientes, ArrayList<Factura> facturas) {
        this.clientes = clientes;
        this.facturas = facturas;
    }

    public ArrayList<ResultadoDto> getResultados(){
        ArrayList<ResultadoDto> rta = new ArrayList<ResultadoDto>(); //1

        for(Cliente c : this.clientes){                 //n
            double total = 0.0;                         //n
            for(Factura f : this.facturas){             //n*n
                if(c.getIdCliente()==f.getIdCliente()){ //n*n
                    total+=f.getImporte();              //n*n
                }
            }
            rta.add(new ResultadoDto(c.getIdCliente(),total)); //n
        }

        return (rta); //1
    }

    //costo cuadratico -> f(n)=2+5n+3n^2

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(100,"Carlos");
        Cliente cliente2 = new Cliente(101,"Juan");
        Cliente cliente3 = new Cliente(102,"Pepe");

        Factura factura1 = new Factura(1,100,1000.0);
        Factura factura2 = new Factura(2,100,33.3);
        Factura factura3 = new Factura(3,101,43.2);
        Factura factura4 = new Factura(4,101,25.2);
        Factura factura5 = new Factura(5,102,0.0);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Factura> facturas = new ArrayList<>();

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        facturas.add(factura1);
        facturas.add(factura2);
        facturas.add(factura3);
        facturas.add(factura4);
        facturas.add(factura5);

        SistemaSinHash sistema = new SistemaSinHash(clientes,facturas);

        for (ResultadoDto elemento : sistema.getResultados()){
            System.out.println(elemento);
        }
    }
}