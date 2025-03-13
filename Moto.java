package TarifadorParqueadero;

public class Moto {
    private String placa;
    private long tiempoEntrada;

    public Moto(String placa, long tiempoEntrada) {
        this.placa = placa;
        this.tiempoEntrada = tiempoEntrada;
    }

    public String getPlaca() {
        return placa;
    }

    public long getTiempoEntrada() {
        return tiempoEntrada;
    }
}
