
public class EnvioMensajes {

    public static void main(String[] args) {

        Movil remitente = new Movil("0997983215", "Alan");
        Movil destinatario = new Movil("0980131016", "Tania");

        SMS mensajeTexto = new SMS(remitente.getNumero(), destinatario.getNumero(), "Hola que tal...");
        System.out.println(mensajeTexto);

        MMS mensajeImagen = new MMS(remitente.getNumero(), destinatario.getNumero(), "imagen.jpg");
        System.out.println(mensajeImagen);
    }
}

class Movil {

    public String numero;
    public String nombre;

    public Movil(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }
}

class Mensaje {

    public String remitente;
    public String destinatario;

    public Mensaje(String remitente, String destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "remitente=" + remitente + ", destinatario=" + destinatario + '}';
    }

}

class SMS extends Mensaje {

    public String texto;

    public SMS(String remitente, String destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    public void enviarMensaje() {
        System.out.println("Enviando SMS: " + texto);
    }

    public void visualizarMensaje() {
        System.out.println("SMS de " + remitente + " a " + destinatario + ": " + texto);
    }

    @Override
    public String toString() {
        return "SMS{" + super.toString() + "texto=" + texto + '}';
    }
}

class MMS extends Mensaje {

    public String nombreFichero;

    public MMS(String remitente, String destinatario, String nombreFichero) {
        super(remitente, destinatario);
        this.nombreFichero = nombreFichero;
    }

    public void enviarMensaje() {
        System.out.println("Enviando MMS con imagen: " + nombreFichero);
    }

    public void visualizarMensaje() {
        System.out.println("MMS de " + remitente + " a " + destinatario + " con imagen: " + nombreFichero);
    }

    @Override
    public String toString() {
        return "MMS - " + super.toString() + ", Imagen: " + nombreFichero;
    }
}
