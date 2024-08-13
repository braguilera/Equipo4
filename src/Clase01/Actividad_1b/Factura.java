package Clase01.Actividad_1b;

public class Factura {
    private int idFactura;
    private int idCliente;
    private double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }

    public int getIdFactura() {
        return idFactura;
    }
    public void setIdFactura(int idFactura) {this.idFactura = idFactura;}
    public int getIdCliente() {return idCliente;}
    public void setIdCliente(int idCliente) {this.idCliente = idCliente;}
    public double getImporte() {return importe;}
    public void setImporte(double importe) {this.importe = importe;}

    @Override
    public String toString() {return "Factura" +"  IdFactura=" + idFactura +"  IdCliente=" + idCliente +"  Importe=" + importe ;}
}