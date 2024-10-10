/** 
@author Leo V 
@version 1.0 
@since 2024
@param argumentos de la linea de comandos 
 */

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Main {

    public static void main(String [] args) {
        
        //VARIABLES 
        ArrayList<programa> programas = new ArrayList<>();
        ArrayList<String> resumenEstudiantes = new ArrayList<>();

        //CREACION DE OBJETOS
        programa dibujo = new programa("Dibujo", 2500000, 6, 7);
        programa pintura = new programa("Pintura", 2700000, 8, 9);
        programa escultura = new programa("Escultura", 3000000, 10, 12);

        //AGREGAR LOS OBJETOS Y LLAMARLOS , se agrego a programas(METODOS)
         programas.add(dibujo);
         programas.add(pintura);
         programas.add(escultura);

         boolean seguir = true;  // Para controlar el ingreso de más estudiantes


         // DO WHILE obliga a digitar min 1 dato
        while (seguir) {
            // INGRESAR DATOS DEL NIÑO
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del niño: ");
            String edadTxT = JOptionPane.showInputDialog("Ingrese la edad de " + nombre + ": ");
            int edad = Integer.parseInt(edadTxT);

            // Determinar el programa aplicable
            programa programaAplicable = null;
            for (programa programa : programas) {
                if (edad >= programa.getEdadMinima() && edad <= programa.getEdadMaxima()) {
                    programaAplicable = programa;
                    break;
                }
            }

            // Si no hay programas aplicables
            if (programaAplicable == null) {
                JOptionPane.showMessageDialog(null, "No hay programas aplicables para la edad ingresada.");
                continue;  // Volver a preguntar por un nuevo estudiante
            }

            // Preguntar por opciones adicionales
            int materialesPremium = JOptionPane.showConfirmDialog(null, "¿Desea materiales premium por valor de 300000?", "Opciones", JOptionPane.YES_NO_OPTION);
            int clasesIntensivas = JOptionPane.showConfirmDialog(null, "¿Desea clases intensivaspor valor de 200000?", "Opciones", JOptionPane.YES_NO_OPTION);
            int talleresFinDeSemana = JOptionPane.showConfirmDialog(null, "¿Desea talleres de fin de semana valor de 150000?", "Opciones", JOptionPane.YES_NO_OPTION);

            // Crear el objeto Nino y asignar las opciones adicionales
            nino nuevoNino = new nino(nombre, edad);
            nuevoNino.setTieneMaterialesPremium(materialesPremium == JOptionPane.YES_OPTION);
            nuevoNino.setTieneClaseIntensivas(clasesIntensivas == JOptionPane.YES_OPTION);
            nuevoNino.setTieneTalleresFinDeSemana(talleresFinDeSemana == JOptionPane.YES_OPTION);

            // Agregar el niño al programa
            programaAplicable.obtenerEstudiantes().add(nuevoNino);

            // Calcular el valor final para el niño
            double valorFinal = programaAplicable.calcularValorFinal(nuevoNino);

            // Guardar la información en el ArrayList de resumen
            String resumen = "Nombre: " + nuevoNino.getNombre() + ", Edad: " + nuevoNino.getEdad() +
                             ", Programa: " + programaAplicable.getNombre() + ", Valor Total: $" + valorFinal;
            resumenEstudiantes.add(resumen);  // Agregar resumen a la lista

            // Mostrar el valor final a pagar
            JOptionPane.showMessageDialog(null, "El valor final a pagar para " + nuevoNino.getNombre() + " es: $" + valorFinal);

            // Preguntar si desea agregar otro estudiante
            int continuar = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro niño?", "Continuar", JOptionPane.YES_NO_OPTION);
            seguir = (continuar == JOptionPane.YES_OPTION);
        }

        // Mostrar el resumen de todos los estudiantes al finalizar
        StringBuilder listaFinal = new StringBuilder("Resumen de estudiantes inscritos:\n");
        for (String resumen : resumenEstudiantes) {
            listaFinal.append(resumen).append("\n");
        }

        JOptionPane.showMessageDialog(null, listaFinal.toString());
    }
}
