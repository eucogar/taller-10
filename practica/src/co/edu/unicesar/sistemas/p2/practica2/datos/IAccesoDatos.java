package co.edu.unicesar.sistemas.p2.practica2.datos;

import co.edu.unicesar.sistemas.p2.practica2.dominio.Publicacion;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import java.util.List;

public interface IAccesoDatos {
    
    void insertarPublicacion(Publicacion p) throws ExcepcionAccesoDatos;
    List<Publicacion> leerPublicaciones()throws ExcepcionAccesoDatos ;
    Publicacion buscarPublicacion(Publicacion p) throws ExcepcionAccesoDatos;
    Publicacion eliminarPublicacion(Publicacion p) throws ExcepcionAccesoDatos;
}
