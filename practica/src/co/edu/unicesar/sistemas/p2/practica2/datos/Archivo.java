/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicesar.sistemas.p2.practica2.datos;

import co.edu.unicesar.sistemas.p2.practica2.dominio.AudioLibro;
import co.edu.unicesar.sistemas.p2.practica2.dominio.Libro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eucogar
 */
public class Archivo {
    
    public static void GuardarLibro(Libro libro) {
       
        FileWriter Archivo; 
        PrintWriter escritor = null;
       
            try{
                
                Archivo = new FileWriter("Libro.txt",true);
                escritor = new PrintWriter(Archivo);
                
                escritor.print(libro.toString()+"\n");
                
               
        }catch(IOException e)
        {
            System.out.println("ERROR AL CREAR EL ARCHIVO");
        }
            finally
            {
            if(escritor != null){
                escritor.close();
            }
        }
            
 }
    
public static void GuardarAudioLibro(AudioLibro Audiolibro) {
       
        FileWriter Archivo; 
        PrintWriter escritor = null;
       
            try{
                
                Archivo = new FileWriter("AudioLibro.txt",true);
                escritor = new PrintWriter(Archivo);
                
                escritor.print(Audiolibro.toString()+"\n");
                
               
        }catch(IOException e)
        {
            System.out.println("ERROR AL CREAR EL ARCHIVO");
        }
            finally
            {
            if(escritor != null){
                escritor.close();
            }
        }
        
            
        


    }
    public static ArrayList<Libro> consultaLibro(){
        
        ArrayList<Libro> Libros = new ArrayList <Libro>();        
        
        FileReader Archivo;
        BufferedReader Lector = null;
        
        try {
            
            Archivo = new FileReader(new File("Libro.txt"));
            Lector = new BufferedReader(Archivo);
            String linea = "";
            
            while((linea = Lector.readLine()) != null ){
            
                Libro libro = DatosLibro(linea);
                Libros.add(libro);
        }
            
        } catch (Exception e) {
        }finally{
            
            if(Lector != null){
                
                try {
                    
                    Lector.close();
                    
                } catch (Exception e) {
                }
                
            }
            
        }
        
        return Libros;
    }
    
        public static ArrayList<AudioLibro> consultaAudioLibro(){
        
        ArrayList<AudioLibro> AudioLibros = new ArrayList <AudioLibro>();        
        
        FileReader Archivo;
        BufferedReader Lector = null;
        
        try {
            
            Archivo = new FileReader(new File("AudioLibro.txt"));
            Lector = new BufferedReader(Archivo);
            String linea = "";
            
            while((linea = Lector.readLine()) != null ){
            
                AudioLibro audiolibro = DatosAudioLibro(linea);
                AudioLibros.add(audiolibro);
        }
            
        } catch (Exception e) {
        }finally{
            
            if(Lector != null){
                
                try {
                    
                    Lector.close();
                    
                } catch (Exception e) {
                }
                
            }
            
        }
        
        return AudioLibros;
    }
    //--------------------------------------------------------------------------
    
    private static Libro DatosLibro(String linea) {
        
        String[] datos = linea.split(",");
        int nPaginas = 0,edicion=0,anio=0;
        double costo=0;
        
        nPaginas = TryParseInt(datos[5]);
        edicion = TryParseInt(datos[6]);
        anio = TryParseInt(datos[3]);
        costo = TryParseInt(datos[4]);
        
        Libro libro = new Libro(nPaginas, edicion, datos[0],datos[1], datos[2], anio, costo);

        return libro;
    }
    
    public static Integer TryParseInt(String someText) {
        try {
            return Integer.parseInt(someText);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
     private static AudioLibro DatosAudioLibro(String linea) {
        
        String[] datos = linea.split(";");
        
        AudioLibro audiolibro = null;
        
     
        return audiolibro;
    }
//------------------------------------------------------------------------------
    
    public static ArrayList<String[]> AbrirArchivo(){
        
        ArrayList<String[]> ListaIngreso = new ArrayList<>();
        
        String[] datos;
        
        FileReader Archivo;
        BufferedReader Lector = null;
        
        try {
            
            Archivo = new FileReader(new File("Libro.txt"));
            Lector = new BufferedReader(Archivo);
             String linea = "";
            
            while((linea = Lector.readLine()) != null ){
                
                datos = linea.split(";");
                ListaIngreso.add(datos);
            }
            
            
        } catch (Exception e) {
        }finally{
            
            if(Lector != null){
                
                try {
                    
                    Lector.close();
                    
                } catch (Exception e) {
                }
                
            }
            
        }
        
        return ListaIngreso;
    }
    public static ArrayList<String[]> AbrirArchivoAudio(){
        
        ArrayList<String[]> ListaIngreso = null;
        
        String[] datos ;
        
        FileReader Archivo;
        BufferedReader Lector = null;
        
        try {
            ListaIngreso = new ArrayList<>();
            
            Archivo = new FileReader(new File("Libro.txt"));
            Lector = new BufferedReader(Archivo);
             String linea = "";
            
            while((linea = Lector.readLine()) != null ){
                
                datos = linea.split(";");
                ListaIngreso.add(datos);
            }
            
            
        } catch (Exception e) {
        }finally{
            
            if(Lector != null){
                
                try {
                    
                    Lector.close();
                    
                } catch (Exception e) {
                }
                
            }
            
        }
        
        return ListaIngreso;
    }
    //---------------------------------------------------------------------------
    public static void EliminarLibro(String CodigoISBM) {

        ArrayList<Libro> Libros = consultaLibro();

        System.out.println("Entro al Metodo");
        if (Libros != null) {
            File Archivo = new File("Libro.txt");

            Archivo.delete();

            for (Libro i : Libros) {
                System.out.println("Entro al for");
                if (CodigoISBM == i.getIsbn()) {
                    System.out.println("Datos a eliminar");
                    System.out.println(i.toString());
                } else {
                    GuardarLibro(i);
                    System.out.println("Registro eliminado");
                }
            }
        } else {
            System.out.println("No se tiene registros");
        }

    }    
    public static void EliminarAudioLibro(String CodigoISBM) {
        
               ArrayList<AudioLibro>AudioLibros = consultaAudioLibro();
        Scanner sc = new Scanner(System.in);
        
        if(AudioLibros == null)
        {
            System.out.println("No se tiene registros");
        }
        else
        {
            File Archivo = new File("AudioLibro.txt");
            
            if (Archivo.delete())
            {
                
            }
                
            else
                System.out.println("Error al modificar el archivo");
            
            for(AudioLibro i:AudioLibros)
            {
                if(CodigoISBM == i.getIsbn())
                {
                    System.out.println("Datos a eliminar");
                    System.out.println(i.toString());
                    sc.nextLine();
                   
                }
                else
                {
                    GuardarAudioLibro(i);
                    System.out.println("Registro eliminado");
                }
            }
        }

    }
    //--------------------------------------------------------------------------
    public static void BusquedaLibro(String ISBM){
        ArrayList<Libro>lista = consultaLibro();
        for(Libro item:lista){
            if(ISBM.equalsIgnoreCase(item.getIsbn())){
                System.out.println(item.toString());
            }
        }
        
    }
        public static void BusquedaAudioLibro(String ISBM){
        ArrayList<AudioLibro>lista = consultaAudioLibro();
        for(AudioLibro item:lista){
            if(ISBM.equals(item.getIsbn())){
                System.out.println(item.toString());
            }
        }
        
    }
        //----------------------------------------------------------------------
        
  
        
    }
   
        
        
        

