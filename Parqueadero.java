package TarifadorParqueadero;

import java.util.Scanner; // Para capturar datos del usuario
import java.util.HashMap; // Estructura para guardar información (clave - valor)
import java.util.Map;     // Interfaz base de HashMap

// Clase principal
public class Parqueadero {

    // Arreglo para guardar disponibilidad de 20 puestos para motos < 400cc
    private boolean[] bajoCCSlots = new boolean[20];

    // Arreglo para guardar disponibilidad de 10 puestos para motos >= 400cc
    private boolean[] altoCCSlots = new boolean[10];

    // HashMap para guardar las motos que están parqueadas, con número de puesto como clave
    private Map<Integer, Moto> motosParqueadas = new HashMap<>();

    // Scanner para leer entrada del usuario
    private Scanner scanner = new Scanner(System.in);

    // Método que muestra el menú y permite interactuar con el usuario
    public void showMenu() {
        while (true) {
            System.out.println("\n--- ParkingNow ---");
            System.out.println("1. Registrar moto");
            System.out.println("2. Cobrar estacionamiento");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpieza del buffer

            switch (option) {
                case 1:
                    registerMotorcycle(); // Registrar una moto
                    break;
                case 2:
                    chargeParking(); // Cobrar a una moto que se va
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return; // Sale del menú
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método para registrar una moto
    private void registerMotorcycle() {
        System.out.print("Ingrese el cilindraje de la moto: ");
        int cc = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Determina en qué arreglo buscar espacio (bajo o alto cilindraje)
        boolean[] slots = (cc < 400) ? bajoCCSlots : altoCCSlots;

        // Buscar el primer puesto libre en el arreglo correspondiente
        int slotNumber = findAvailableSlot(slots);

        if (slotNumber == -1) {
            System.out.println("No hay espacios disponibles.");
        } else {
            // Pedir placa de la moto
            System.out.print("Ingrese la placa de la moto: ");
            String placa = scanner.nextLine();

            // Marcar el puesto como ocupado
            slots[slotNumber] = true;

            // Guardar el tiempo actual (en milisegundos)
            long tiempoEntrada = System.currentTimeMillis();

            // Crear un objeto tipo Moto y guardarlo en el mapa
            Moto moto = new Moto(placa, tiempoEntrada);
            motosParqueadas.put(slotNumber, moto);

            // Mostrar en qué puesto quedó registrada
            System.out.println("Moto con placa " + placa + " registrada en el puesto " + (slotNumber + 1));
        }
    }

    // Método para buscar el primer espacio libre en un arreglo de puestos
    private int findAvailableSlot(boolean[] slots) {
        for (int i = 0; i < slots.length; i++) {
            if (!slots[i]) {
                return i; // Retorna el índice del primer puesto libre
            }
        }
        return -1; // No hay puestos disponibles
    }

    // Método para calcular el cobro de una moto
    private void chargeParking() {
        System.out.print("Ingrese el número de puesto: ");
        int slotNumber = scanner.nextInt() - 1; // -1 porque el usuario ve desde 1, pero los arreglos empiezan en 0
        scanner.nextLine(); // Limpiar buffer

        // Verificamos si ese puesto tiene una moto registrada
        if (!motosParqueadas.containsKey(slotNumber)) {
            System.out.println("El puesto está vacío.");
            return;
        }

        // Obtener la moto y calcular el tiempo de parqueo
        Moto moto = motosParqueadas.get(slotNumber);
        long tiempoEntrada = moto.getTiempoEntrada();
        long tiempoActual = System.currentTimeMillis();

        // Convertir el tiempo en minutos
        long minutos = (tiempoActual - tiempoEntrada) / (60 * 1000);

        // Cálculo del valor a pagar según el tiempo
        int costo = (minutos <= 30) ? 0 : (minutos <= 60) ? 800 : 2000;

        // Mostrar la información
        System.out.println("Placa: " + moto.getPlaca());
        System.out.println("Tiempo: " + minutos + " minutos.");
        System.out.println("Total a pagar: $" + costo);

        // Liberar el puesto
        if (slotNumber < 20) {
            bajoCCSlots[slotNumber] = false;
        } else {
            altoCCSlots[slotNumber - 20] = false;
        }

        // Quitar la moto del mapa
        motosParqueadas.remove(slotNumber);
    }

    // Método principal
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        parqueadero.showMenu(); // Inicia el menú
    }
}
