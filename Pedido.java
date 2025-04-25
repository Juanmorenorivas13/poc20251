package MomentoII;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Cliente cliente; // Cliente que hace el pedido
    private List<Producto> productos; // Lista de productos en el pedido
    private Date fecha; // Fecha del pedido
    private int numeroTarjetaDebito; // Numero de tarjeta usado en el pago

    // Constructor
    public Pedido(Cliente cliente, List<Producto> productos, Date fecha, int numeroTarjetaDebito) {
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
        this.numeroTarjetaDebito = numeroTarjetaDebito;
    }

    // Metodo para mostrar los detalles del pedido
    public void mostrarDetalle() {
        System.out.println("-------DETALLE DEL PRODUCTO-----");
        System.out.println("Cliente: " + cliente.getNombre() + " Cedula: " + cliente.getCedula());
        System.out.println("Fecha: " + fecha);
        System.out.println("Numero de tarjeta:" + numeroTarjetaDebito);
        System.out.println("Productos del pedido");

        for (Producto p : productos) {
            p.mostrarDetalle(); // usa polimorfismo para mostrar los detalles de impresion o camara
        }
    }
}
