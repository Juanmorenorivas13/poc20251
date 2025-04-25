package MomentoII;

public class Foto {
    private String fichero;

    // constructor
    public Foto(String fichero) {
        this.fichero = fichero;
    }

    // Metodo para imprimir el nombre del fichero
    public void print() {
        System.out.println("Foto:" + fichero);
    }
}
