package Clase01.Actividad_1b;

public class ResultadoDto {
    private int idCliente;
    private double totalFacturas;

    public ResultadoDto(int idClienteM, double totalFacturas) {
        this.idCliente = idClienteM;
        this.totalFacturas = totalFacturas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idClienteM) {
        this.idCliente = idClienteM;
    }

    public double getTotalFacturas() {
        return totalFacturas;
    }

    public void setTotalFacturas(double totalFacturas) {
        this.totalFacturas = totalFacturas;
    }

    @Override
    public String toString() {
        return "->"+"IdCliente="+idCliente +".....TotalFacturas($)="+totalFacturas;
    }
}