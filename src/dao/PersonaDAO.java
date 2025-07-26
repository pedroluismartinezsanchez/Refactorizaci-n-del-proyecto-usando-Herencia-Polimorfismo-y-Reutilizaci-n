/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    
    private final String archivo = "data/personas.dat";

    
    public void guardarPersonas(List<Persona> personas) {
        File carpeta = new File("data");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }    
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(personas);
        } catch (IOException e) {
            System.err.println("Error guardando personas: " + e.getMessage());
        }
    }

    public List<Persona> cargarPersonas() {
        List<Persona> personas = new ArrayList<>();
        File file = new File(archivo);

        if (!file.exists()) {
            /*System.out.println("El archivo de personas no existe todavía.");*/
            return personas; // devuelve lista vacía
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            personas = (List<Persona>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
        return personas;
    }
   
   

}
