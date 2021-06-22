package co.edu.unicesar.sistemas.p2.practica2.vista;

import co.edu.unicesar.sistemas.p2.practica2.datos.Archivo;
import co.edu.unicesar.sistemas.p2.practica2.datos.ArrayAccesoDatos;
import co.edu.unicesar.sistemas.p2.practica2.datos.IAccesoDatos;
import co.edu.unicesar.sistemas.p2.practica2.dominio.AudioLibro;
import co.edu.unicesar.sistemas.p2.practica2.dominio.Libro;
import co.edu.unicesar.sistemas.p2.practica2.dominio.Publicacion;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import co.edu.unicesar.sistemas.p2.practica2.negocio.RegistroPublicacion;
import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    
    private String titulos[] ={ "1. Registrar publicacion",
                              "2. Ver publicaciones",
                              "3. Buscar publicacion",
                              "4. Eliminar publicacion",
                              "0. Salir"};
    
    private int opcion;
    private Scanner lector;
    private RegistroPublicacion logica;

    public VistaConsola() {
        this.lector = new Scanner(System.in);
        this.logica = new RegistroPublicacion();
        
        
    }
    
    public void ejecutarMenu(){
         do{
            
            this.imprimirTitulos();
            this.leerOpcion();
            this.ejecutarOpion();
            
         }while(this.opcion!=0);   
    }
    
    public void imprimirTitulos(){
        
        System.out.println("\nMENU DE LA APLICACION");
        for(int i=0; i< this.titulos.length;i++){
            System.out.println(this.titulos[i]);
        }
    }
    
    public void leerOpcion(){
        
        boolean excepcion=true;
        do{
            try{
                System.out.print("\nSelecciones una opcion: ");
                this.opcion = this.lector.nextInt();
                 excepcion = false;
            }catch(java.util.InputMismatchException ime){
                System.out.println("Se requiere valor entero, intente nuevamente");
                excepcion = true;
                this.lector.nextLine();
            } 
        }while(excepcion);   
    }
    
    public void ejecutarOpion(){
        switch(this.opcion){
            
            case 1: this.vitaInsertarPublicacion();
                    break;
            case 2: this.vitaLeerPublicaciones();
                    break;
            case 3: this.vitaBuscarPublicacion();
                    break;
            case 4: this.vitaEliminarPublicacion();
                    break;
            case 0:  System.out.println("Ha salido de la aplicacion");
                     break;
            default: System.out.println("Opcion no valida, intente nuevamente");
        }
    }
    
    public void vitaInsertarPublicacion(){
        
         Scanner sc = new Scanner(System.in);
        int i;
        System.out.println("Seleccione una opcion");
        System.out.println("Libro --->1");
        System.out.println("AudioLibro --->2");
        i = sc.nextInt();
        if(i ==1)
        {   
            Libro libro = new Libro();
            
            sc.nextLine();
            System.out.println("ISBN");
            libro.setIsbn(sc.nextLine());
            
            System.out.println("TITULO");
            libro.setTitulo(sc.nextLine());
            
            System.out.println("AUTOR");
            libro.setAutor(sc.nextLine());
            
            System.out.println("Numero de paginas");
            libro.setnPaginas(sc.nextInt());
            sc.nextLine();
            System.out.println("COSTO");
            libro.setCosto(sc.nextDouble());
            
            System.out.println("EDICION");
            libro.setEdicion(sc.nextInt());
            
            System.out.println("FECHA");
            libro.setAnio(sc.nextInt());
            
            Archivo.GuardarLibro(libro);
            
            
        }else if(i == 2)
        {
            AudioLibro audiolibro = new AudioLibro();
            
            sc.nextLine();
            System.out.println("ISBN");
            audiolibro.setIsbn(sc.nextLine());
            
            System.out.println("TITULO");
            audiolibro.setTitulo(sc.nextLine());
            
            System.out.println("AUTOR");
            audiolibro.setAutor(sc.nextLine());
    
            System.out.println("COSTO");
            audiolibro.setCosto(sc.nextDouble());
            sc.nextLine();
            System.out.println("EDICION");
            audiolibro.setPeso(sc.nextDouble());
            
            System.out.println("FECHA");
            audiolibro.setAnio(sc.nextInt());
            sc.nextLine();
            System.out.println("DURACION");
            audiolibro.setDuracion(sc.nextDouble());
            sc.nextLine();
            System.out.println("FORMATO");
            audiolibro.setFormato(sc.nextLine());
            
            Archivo.GuardarAudioLibro(audiolibro);
            
        }else
        {
            System.out.println("Valor fuera de rango");
        }
        
    }
    public void vitaLeerPublicaciones(){
        System.out.println(this.titulos[this.opcion-1]);
         // construir el codigo 
         
    }
    public void vitaBuscarPublicacion(){
       
        System.out.println("");
        System.out.println(this.titulos[this.opcion-1]);
        System.out.print("Isbn a buscar: ");
        String isbn = this.lector.next();
        try{
         Publicacion pub = this.logica.buscarPublicacion(new Libro(isbn));
         if(pub==null){
             System.out.println("La publicacion no esta registrada");
         }
         else{
             System.out.println(pub);
         }
        }catch(ExcepcionAccesoDatos ex){
            System.out.println(ex.getMessage());
        }  
        
    }
    public void vitaEliminarPublicacion(){
        int i = 0; 
        String CodigoISBM;
        Scanner sc = new Scanner(System.in);
        System.out.println(this.titulos[this.opcion-1]);
        
        
        System.out.println("Ingrese el codigo ISBN");
        CodigoISBM = sc.nextLine();
        
        System.out.println("Seleccione una opcion");
        System.out.println("Libro --->1");
        System.out.println("AudioLibro --->2");
        i = sc.nextInt();
        if(i ==1)
        {   
            Archivo.EliminarLibro(CodigoISBM);
            
        }else if(i == 2)
        {
            Archivo.EliminarAudioLibro(CodigoISBM);
        }else
        {
            System.out.println("Valor fuera de rango");
        }
            
        
    }
    
}
