
import java.util.ArrayList;
import java.util.List;

public class TestCapituloLibro {

    public static void main(String[] args) {
        CapituloLibro capitulo = new CapituloLibro();

        Seccion seccion = new Seccion();

        Parrafo parrafo = new Parrafo();

        Sentencia sentencia = new Sentencia();
    }
}

class CapituloLibro {

    public List<Seccion> secciones;

    public CapituloLibro() {
        this.secciones = new ArrayList<>();
    }

    public void agregarSeccion(Seccion seccion) {
        this.secciones.add(seccion);
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }
}

class Seccion {

    public List<Parrafo> parrafos;
    public List<Figura> figuras;

    public Seccion() {
        this.parrafos = new ArrayList<>();
        this.figuras = new ArrayList<>();
    }

    public void agregarParrafo(Parrafo parrafo) {
        this.parrafos.add(parrafo);
    }

    public void agregarFigura(Figura figura) {
        this.figuras.add(figura);
    }

    public List<Parrafo> getParrafos() {
        return parrafos;
    }

    public List<Figura> getFiguras() {
        return figuras;
    }
}

class Parrafo {

    public List<Sentencia> sentencias;

    public Parrafo() {
        this.sentencias = new ArrayList<>();
    }

    public void agregarSentencia(Sentencia sentencia) {
        this.sentencias.add(sentencia);
    }

    public List<Sentencia> getSentencias() {
        return sentencias;
    }
}

class Sentencia {

    public List<Palabra> palabras;

    public Sentencia() {
        this.palabras = new ArrayList<>();
    }

    public void agregarPalabra(Palabra palabra) {
        this.palabras.add(palabra);
    }

    public List<Palabra> getPalabras() {
        return palabras;
    }
}

class Palabra {

    public String texto;

    public Palabra(String texto) {
        this.texto = texto;
    }
}

class Figura {

    public String descripcion;

    public Figura(String descripcion) {
        this.descripcion = descripcion;
    }
}
