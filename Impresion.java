package MomentoII;

import java.util.List;

public class Impresion extends Producto {
    private String color;
    private List<Foto> fotos; // una impresion contiene varias fotos.

    // constructor : Recibe el numero, el color y la lista de fotos.
    public Impresion(int numero, String color, List<Foto> fotos) {
        super(numero); // llama al constructor de Producto
        this.color = color;
        this.fotos = fotos;
    }

    // Metodo que muestra la informacion de la impresion y sus fotos
    @Override
    public void mostrarDetalle() {
        System.out.println("Impresion #" + numero + " Color: " + color);
        System.out.println("Fotos incluidas");
        for (Foto f : fotos) {
            f.print(); // llama al metodo print de cada fto
        }
    }
}
