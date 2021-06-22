package co.edu.unicesar.sistemas.p2.practica2.dominio;

public class Libro extends Publicacion {
    private int nPaginas, edicion;

    public Libro() {
    }

    public Libro(String isbn) {
        super(isbn);
    }

    public Libro(int nPaginas, int edicion, String isbn, String titulo, String autor, int anio, double costo) {
        super(isbn, titulo, autor, anio, costo);
        this.nPaginas = nPaginas;
        this.edicion = edicion;
    }

    /**
     * @return the nPaginas
     */
    public int getnPaginas() {
        return nPaginas;
    }

    /**
     * @param nPaginas the nPaginas to set
     */
    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    /**
     * @return the edicion
     */
    public int getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    @Override
    public String getInfo() {
        return this.nPaginas+","+this.edicion;
    }
    
    
}
