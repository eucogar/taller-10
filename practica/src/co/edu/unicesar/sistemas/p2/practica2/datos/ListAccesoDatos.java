package co.edu.unicesar.sistemas.p2.practica2.datos;

import co.edu.unicesar.sistemas.p2.practica2.dominio.Publicacion;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import java.util.List;

public class ListAccesoDatos implements IAccesoDatos {

    @Override
    public void insertarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionAccesoDatos {
        return null;
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        return null;
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        return null;
    }
    
}
