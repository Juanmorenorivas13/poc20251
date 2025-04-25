package MomentoII;

public class Camara extends Producto {
    private String marca;
    private String modelo;
    private int año;

    public Camara(int numero, int año, String marca, String modelo) {
        super(numero); // llama al constructor
        this.año = año;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Camara#" + numero + "- Marca:" + marca +
                " Modelo:" + modelo + " Año:" + año);
    }
}
