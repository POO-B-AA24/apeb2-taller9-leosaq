
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EntradasTeatro {

    public static Scanner entrada = new Scanner(System.in);
    public static Teatro teatro = new Teatro();

    public static void main(String[] args) {

        while (true) {
            mostrarMenu();
            int opc = leerOpcion();
            ejecutarOpcion(opc);
            if (opc == 3) {
                break;
            }
        }
    }

    public static void mostrarMenu() {
        System.out.print("======= Seleccione una opcion =======");
        System.out.println("\n[1] Vender entrada");
        System.out.println("[2] Consultar entrada");
        System.out.println("[3] Salir");
        System.out.print("------> ");
    }

    private static int leerOpcion() {
        int opcion = entrada.nextInt();
        entrada.nextLine();
        return opcion;
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                venderEntrada();
                break;
            case 2:
                consultarEntrada();
                break;
            case 3:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    private static void venderEntrada() {
        System.out.print("Ingrese el nombre de la zona (Principal, PalcoB, Central, Lateral): ");
        String zona = entrada.nextLine();
        System.out.print("Ingrese el nombre del comprador: ");
        String comprador = entrada.nextLine();
        System.out.print("Ingrese el tipo de entrada (normal, reducida, abonada): ");
        String tipo = entrada.nextLine();

        teatro.venderEntrada(zona, comprador, tipo);
    }

    private static void consultarEntrada() {
        System.out.print("Ingrese el identificador de la entrada: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        teatro.consultarEntrada(id);
    }

}

class Zona {

    public String nombre;
    public int numLocalidades;
    public double precioNormal;
    public double precioAbonado;
    public int localidadesVendidas;

    public Zona(String nombre, int numLocalidades, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.numLocalidades = numLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
        this.localidadesVendidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean hayLocalidadesDisponibles() {
        return localidadesVendidas < numLocalidades;
    }

    public void venderEntrada() {
        localidadesVendidas++;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioAbonado() {
        return precioAbonado;
    }

    @Override
    public String toString() {
        return "Zona{" + "nombre=" + nombre + ", numLocalidades=" + numLocalidades + ", precioNormal=" + precioNormal + ", precioAbonado=" + precioAbonado + ", localidadesVendidas=" + localidadesVendidas + '}';
    }
}

abstract class Entrada {

    public int id;
    public String nombreComprador;
    public Zona zona;

    public Entrada(int id, String nombreComprador, Zona zona) {
        this.id = id;
        this.nombreComprador = nombreComprador;
        this.zona = zona;
    }
    
    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", nombreComprador=" + nombreComprador + ", zona=" + zona + "Precio: "+calcularPrecio()+ '}';
    }
}

class EntradaNormal extends Entrada {

    public EntradaNormal(int id, String nombreComprador, Zona zona) {
        super(id, nombreComprador, zona);
    }

    public double calcularPrecio() {
        return zona.getPrecioNormal();
    }
}

class EntradaReducida extends Entrada {

    public EntradaReducida(int id, String nombreComprador, Zona zona) {
        super(id, nombreComprador, zona);
    }

    public double calcularPrecio() {
        return zona.getPrecioNormal() * 0.85;
    }
}

class EntradaAbonado extends Entrada {

    public EntradaAbonado(int id, String nombreComprador, Zona zona) {
        super(id, nombreComprador, zona);
    }

    public double calcularPrecio() {
        return zona.getPrecioAbonado();
    }
}

class Teatro {

    private Map<Integer, Entrada> entradas;
    private Map<String, Zona> zonas;
    private int nextId;

    public Teatro() {
        entradas = new HashMap<>();
        zonas = new HashMap<>();
        nextId = 1;

        zonas.put("Principal", new Zona("Principal", 200, 25, 17.5));
        zonas.put("PalcoB", new Zona("PalcoB", 40, 70, 40));
        zonas.put("Central", new Zona("Central", 400, 20, 14));
        zonas.put("Lateral", new Zona("Lateral", 100, 15.5, 10));
    }

    public void venderEntrada(String zonaNombre, String nombreComprador, String tipoEntrada) {
        Zona zona = zonas.get(zonaNombre);

        if (zona == null) {
            System.out.println("Zona no encontrada.");
            return;
        }

        if (!zona.hayLocalidadesDisponibles()) {
            System.out.println("La zona está completa.");
            return;
        }

        Entrada entrada = crearEntrada(nextId, nombreComprador, zona, tipoEntrada);
        if (entrada != null) {
            entradas.put(nextId, entrada);
            zona.venderEntrada();
            System.out.println("Entrada vendida: " + entrada);
            nextId++;
        }
    }

    public Entrada crearEntrada(int id, String nombreComprador, Zona zona, String tipoEntrada) {
        switch (tipoEntrada.toLowerCase()) {
            case "normal":
                return new EntradaNormal(id, nombreComprador, zona);
            case "reducida":
                return new EntradaReducida(id, nombreComprador, zona);
            case "abonada":
                return new EntradaAbonado(id, nombreComprador, zona);
            default:
                System.out.println("Tipo de entrada no válido.");
                return null;
        }
    }

    public void consultarEntrada(int id) {
        Entrada entrada = entradas.get(id);

        if (entrada == null) {
            System.out.println("No existe ninguna entrada con ese identificador.");
        } else {
            System.out.println("Detalles de la entrada: " + entrada);
        }
    }
}
