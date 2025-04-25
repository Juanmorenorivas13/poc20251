package MomentoII;

public abstract class Producto {
    protected int numero;

    public Producto(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // este metodo va ser usado para las clases hijas
    public abstract void mostrarDetalle();

}
