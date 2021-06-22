package co.edu.unicesar.sistemas.p2.practica2.dominio;

public class AudioLibro extends Publicacion {
    private double duracion, peso;
    private String formato;

    public AudioLibro() {
    }

    public AudioLibro(String isbn) {
        super(isbn);
    }

    public AudioLibro(double duracion, double peso, String formato, String isbn, String titulo, String autor, int anio, double costo) {
        super(isbn, titulo, autor, anio, costo);
        this.duracion = duracion;
        this.peso = peso;
        this.formato = formato;
    }

    /**
     * @return the duracion
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String getInfo() {
        return this.duracion+","+this.peso+","+this.formato;
    }
    
    
    
}
