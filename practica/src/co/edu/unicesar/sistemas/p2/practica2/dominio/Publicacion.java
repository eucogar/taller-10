package co.edu.unicesar.sistemas.p2.practica2.dominio;

public abstract class Publicacion {
    private String isbn, titulo, autor;
    private int anio;
    private double costo;

    public Publicacion() {
    }

    public Publicacion(String isbn) {
        this.isbn = isbn;
    }

    public Publicacion(String isbn, String titulo, String autor, int anio, double costo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.costo = costo;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public abstract String getInfo();

    @Override
    public String toString() {
        return  isbn + "," + titulo + "," + autor + "," + anio + "," + costo + "," + this.getInfo();
    }
    
    
    
}
