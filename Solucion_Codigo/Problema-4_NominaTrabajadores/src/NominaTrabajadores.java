public class NominaTrabajadores {

    public static void main(String[] args) {
        Jefe jefe1 = new Jefe(2000.0, "Leandro", "Saquisari", "Loja", "0104579859");
        Jefe jefe2 = new Jefe(1800.0, "Israel", "Espinosa", "Quito", "0351161616");
        Jefe jefe3 = new Jefe(1500.0, "Armando", "Mendoza", "Esmeraldas", "0704525");

        FijoMensual fijoMensual = new FijoMensual(800.0, "Ana", "Gomez", "Catamayo", "87654321B");

        Comisionista comisionista = new Comisionista(0.1, "Carlos", "Lopez", "Loja", "87654321");
        comisionista.setventasRealizadas(10000.0);

        PorHora porHora = new PorHora(20.0, 25.0, "Maria", "Martinez", "Catamayo", "0104579859");
        porHora.establecerHorasTrabajadas(50);

        
        System.out.println("\n========= Nominas de los trabajadores =========");
        System.out.println(jefe1);
        System.out.println("\n"+fijoMensual.toString());
        System.out.println("----> Nomina Empleado Fijo Mensual: " +fijoMensual.calcularNomina());
        
        System.out.println("");
        System.out.println(jefe2);
        System.out.println("\n"+comisionista.toString());
        System.out.println("----> Nomina Empleado Comisionista: " + comisionista.calcularNomina());
        
        System.out.println("");
        System.out.println(jefe3);
        System.out.println("\n"+porHora.toString());
        System.out.println("----> Nomina Empleado Por Hora: " + porHora.calcularNomina());

    }
}

class Trabajador {

    public String nombre;
    public String apellido;
    public String direccion;
    public String dni;

    public Trabajador(String nombre, String apellido, String direccion, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + '}';
    }


}

class FijoMensual extends Trabajador {

    public double salarioFijo;

    public FijoMensual(double salarioFijo, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.salarioFijo = salarioFijo;
    }

    public double calcularNomina() {
        return salarioFijo;
    }

    @Override
    public String toString() {
        return "FijoMensual{" + super.toString() + "salarioFijo=" + salarioFijo + '}';
    }
}

class Comisionista extends Trabajador {

    public double porcentajeComision;
    public double ventas;

    public Comisionista(double porcentajeComision, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.porcentajeComision = porcentajeComision;
    }

    public void setventasRealizadas(double ventas) {
        this.ventas = ventas;
    }

    public double calcularNomina() {
        return ventas * porcentajeComision;
    }

    @Override
    public String toString() {
        return "Comisionista{" + super.toString() + "porcentajeComision=" + porcentajeComision + ", ventas=" + ventas + '}';
    }
}

class PorHora extends Trabajador {

    public double precioHoraRegular;
    public double precioHoraExtra;
    public double horasTrabajadas;

    public PorHora(double precioHora, double precioHoraExtra, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.precioHoraRegular = precioHora;
        this.precioHoraExtra = precioHoraExtra;
    }

    public void establecerHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double calcularNomina() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * precioHoraRegular;
        } else {
            return 40 * precioHoraRegular + (horasTrabajadas - 40) * precioHoraExtra;
        }
    }

    @Override
    public String toString() {
        return "PorHora{" + super.toString() + "precioHoraRegular=" + precioHoraRegular + ", precioHoraExtra=" + precioHoraExtra + ", horasTrabajadas=" + horasTrabajadas + '}';
    }

}

class Jefe extends Trabajador {

    public double sueldoFijo;

    public Jefe(double sueldoFijo, String nombre, String apellido, String direccion, String dni) {
        super(nombre, apellido, direccion, dni);
        this.sueldoFijo = sueldoFijo;
    }

    public double calcularNomina() {
        return sueldoFijo;
    }

    @Override
    public String toString() {
        return "Jefe{" + super.toString() + "sueldoFijo=" + sueldoFijo + '}';
    }

}
