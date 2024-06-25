
public class Banco {

    public static void main(String[] args) {
        // Crear cuentas
        CuentaCheque cuentaCheques = new CuentaCheque(1312312131, "Alice");
        CuentaAhorro cuentaAhorros = new CuentaAhorro(0.05, 56465465, "Bob");
        CuentaPlatino cuentaPlatino = new CuentaPlatino(256156156, "Charlie");

        System.out.println("======= Estado de cuenta - Cuenta de Cheques =======");
        cuentaCheques.depositar(1500);
        cuentaCheques.retirar(500);
        cuentaCheques.retirar(1200);
        System.out.println(cuentaCheques.toString());

        System.out.println("\n======= Estado de cuenta - Cuenta de Ahorros =======");
        cuentaAhorros.depositar(3000);
        cuentaAhorros.calcularInteres();
        cuentaAhorros.retirar(500);
        System.out.println(cuentaAhorros.toString());

        System.out.println("\n======= Estado de cuenta - Cuenta Platino =======");
        cuentaPlatino.depositar(5000);
        cuentaPlatino.calcularInteres();
        cuentaPlatino.retirar(1000);
        System.out.println(cuentaPlatino.toString());
    }
}

class Cuenta {

    public int numeroCuenta;
    public String nombreCliente;
    public double balance;

    public Cuenta(int numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0.0;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            balance += monto;
            System.out.println("----> Deposito de: $" + monto + " realizado. Balance: $" + balance);
        }
    }

    public void retirar(double monto) {
        if (monto > 0) {
            balance -= monto;
            System.out.println("----> Retiro de: $" + monto + " realizado. Balance: $" + balance);
        }
    }

    public double obtenerBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", nombreCliente=" + nombreCliente + ", balance=" + balance + '}';
    }
}

class CuentaCheque extends Cuenta {

    public CuentaCheque(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    @Override
    public void retirar(double cantidad) {
        super.retirar(cantidad);
    }
}

class CuentaAhorro extends Cuenta {

    public double tasaInteres;

    public CuentaAhorro(double tasaInteres, int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = tasaInteres;
    }

    public void calcularInteres() {
        if (balance > 0) {
            balance += balance * tasaInteres / 100;
            System.out.println("----> Interes mensual calculado y agregado. Balance: $" + balance);
        }
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= balance) {
            balance -= cantidad;
            System.out.println("----> Retiro de: $" + cantidad + " realizado. Balance: $" + balance);
        } else {
            System.out.println("----> Fondos insuficientes.");
        }
    }
}

class CuentaPlatino extends Cuenta {

    public double tasaInteres = 10.0;

    public CuentaPlatino(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    public void calcularInteres() {
        balance += balance * tasaInteres / 100;
        System.out.println("----> Interes mensual calculado y agregado. Balance: $" + balance);
    }

    @Override
    public void retirar(double cantidad) {
        balance -= cantidad;
        System.out.println("----> Retiro de: $" + cantidad + " realizado. Balance: $" + balance);
    }
}
