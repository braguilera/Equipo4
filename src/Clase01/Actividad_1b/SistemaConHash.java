package Clase01.Actividad_1b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SistemaConHash {
    private HashMap<Integer, Cliente> clientes;
    private ArrayList<Factura> facturas;

    public SistemaConHash(HashMap<Integer, Cliente> clientes, ArrayList<Factura> facturas) {
        this.clientes = clientes;
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "SistemaConHash" +" Clientes="+clientes+"   Facturas="+facturas;
    }

    public ArrayList<ResultadoDto> getResultados() {
        // Inicializar un HashMap para almacenar el total de facturas por cliente
        HashMap<Integer, Double> totales = new HashMap<>();

        // Recorre las facturas y acumula los importes por cliente
        for (Factura f : facturas) {
            int idCliente = f.getIdCliente();
            double importe = f.getImporte();

            // Actualiza el total en el HashMap
            totales.put(idCliente, totales.getOrDefault(idCliente, 0.0) + importe);
        }

        // Crear la lista de resultados a partir del HashMap
        ArrayList<ResultadoDto> rta = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : totales.entrySet()) {
            int idCliente = entry.getKey();
            double total = entry.getValue();
            Cliente cliente = clientes.get(idCliente);
            if (cliente != null) {
                rta.add(new ResultadoDto(idCliente, total));
            }
        }

        return rta;
    }

    public static void main(String[] args) {
        System.out.println("Version con HashMap");
        HashMap<Integer, Cliente> clientes = new HashMap<>();
        ArrayList<Factura> facturas = new ArrayList<>();

        Cliente cliente1 = new Cliente(100,"Carlos");
        Cliente cliente2 = new Cliente(101,"Juan");
        Cliente cliente3 = new Cliente(102,"Pepe");

        Factura factura1 = new Factura(1,100,1000.0);
        Factura factura2 = new Factura(2,100,33.3);
        Factura factura3 = new Factura(3,101,43.2);
        Factura factura4 = new Factura(4,101,25.2);
        Factura factura5 = new Factura(5,102,0.0);

        clientes.put(cliente1.getIdCliente(),cliente1);
        clientes.put(cliente2.getIdCliente(),cliente2);
        clientes.put(cliente3.getIdCliente(),cliente3);

        facturas.add(factura1);
        facturas.add(factura2);
        facturas.add(factura3);
        facturas.add(factura4);
        facturas.add(factura5);

        SistemaConHash sistema = new SistemaConHash(clientes, facturas);
        ArrayList<ResultadoDto> resultados = sistema.getResultados();

        for (ResultadoDto resultado : resultados) {
            System.out.println("Cliente ID: " + resultado.getIdCliente() + ", Total: " + resultado.getTotalFacturas());
        }
    }
}