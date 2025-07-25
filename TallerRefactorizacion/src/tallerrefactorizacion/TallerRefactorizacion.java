/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallerrefactorizacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.Propietario;
import modelo.Veterinario;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class TallerRefactorizacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Propietario("Laura", "123", null));
        personas.add(new Veterinario("Pedro", "456", "Cirugía"));

        for (Persona p : personas) {
            System.out.println(p.getTipo() + ": " + p.getNombre());
            String mensaje = p.toString();

            if (p instanceof Veterinario) {
                Veterinario vet = (Veterinario) p;
                String especialidad = vet.getEspecialidad();
                mensaje += "\nEspecialidad: " + especialidad;
            }

            JOptionPane.showMessageDialog(null, mensaje);
        }

    }

}
