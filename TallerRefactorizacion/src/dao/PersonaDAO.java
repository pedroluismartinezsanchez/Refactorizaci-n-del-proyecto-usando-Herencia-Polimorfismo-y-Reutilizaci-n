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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(personas);
        } catch (IOException e) {
            System.err.println("Error guardando personas: " + e.getMessage());
        }
    }

    public List<Persona> cargarPersonas() {
        List<Persona> personas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            personas = (List<Persona>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
        return personas;
    }
}
