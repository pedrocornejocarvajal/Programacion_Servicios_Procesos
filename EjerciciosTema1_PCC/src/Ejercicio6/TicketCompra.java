package Ejercicio6;

public class TicketCompra {
    private int codigoProducto;
    private double precioProducto;
    private int cantidad;

    public TicketCompra() {

    }

    public TicketCompra(int codigoProducto, double precioProducto, int cantidad) {
        this.codigoProducto = codigoProducto;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    private double getTotal() {
        return this.precioProducto * this.cantidad;
    }

    @Override
    public String toString() {
        return codigoProducto +
                "-" + precioProducto +
                "-" + cantidad +
                "-" + getTotal();
    }


}
