package co.edu.unicesar.sistemas.p2.practica2.datos;

import co.edu.unicesar.sistemas.p2.practica2.dominio.Publicacion;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import java.util.*;

public class ArrayAccesoDatos implements IAccesoDatos{
    
    private Publicacion arreglo[];
    private int n;

    public ArrayAccesoDatos(int tam) {
        this.arreglo = new Publicacion[tam];
    }
    
    @Override
    public void insertarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        
        if(this.n>=this.arreglo.length) // no hay espacio
            throw new ExcepcionAccesoDatos("El limite del arreglo fue excedido");
        if(p==null)
            throw new ExcepcionAccesoDatos("El objetoa insertar en de tipo NULL");
        if(p.getIsbn()==null)
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene ISBN");
        
        this.arreglo[this.n]=p;
        this.n++;
        
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionAccesoDatos {
        
        if(this.n==0)// no hay elemento
            throw new ExcepcionAccesoDatos("No hay publicaciones registradas");
        
        List<Publicacion> resultado = new ArrayList();
        //opcion 1
            //Publicacion lista[];
            //lista = Arrays.copyOf(arreglo, n);
            //resultado = Arrays.asList(lista);
        
        //opcion 2    
        for(int i=0; i<this.n;i++){
            Publicacion p = this.arreglo[i];
            resultado.add(p);
        }
        return resultado;
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        if(this.n==0)// no hay elemento
            throw new ExcepcionAccesoDatos("No hay publicaciones registradas");
        if(p==null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if(p.getIsbn()==null)
            throw new ExcepcionAccesoDatos("El ISBN a buscar es de tipo NULL");
        
        Publicacion encontrado = null;
        for(int i=0; i<this.n;i++){
            Publicacion pub = this.arreglo[i];
            if(pub.getIsbn().equals(p.getIsbn())){
                encontrado = pub;
                break;
            }
        }
        
        return encontrado;
        
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) throws ExcepcionAccesoDatos {
        
        return null;
    }
    
}
