/** 
@author Leo Valencia Santa 
@version 1.0 
@since 2024
@param argumentos de la linea de comandos 
 */

 import java.util.ArrayList;
 import java.text.DecimalFormat;
 import javax.swing.JOptionPane;
 
 public class Main {
 
     public static void main(String[] args) {
 
         // Formatear el valor de los costos
         DecimalFormat formater = new DecimalFormat("###,###.##");
 
         // Variables
         ArrayList<programa> programas = new ArrayList<>();
         ArrayList<String> resumenEstudiantes = new ArrayList<>();
 
         // Creación de objetos de programas
         programa dibujo = new programa("Dibujo", 2500000, 6, 7);
         programa pintura = new programa("Pintura", 2700000, 8, 9);
         programa escultura = new programa("Escultura", 3000000, 10, 12);
 
         // Agregar los programas a la lista
         programas.add(dibujo);
         programas.add(pintura);
         programas.add(escultura);
 
         boolean seguir = true;  // Para controlar el ingreso de más estudiantes
 
         while (seguir) {
             // Ingresar datos del niño
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
             int clasesIntensivas = JOptionPane.showConfirmDialog(null, "¿Desea clases intensivas por valor de 200000?", "Opciones", JOptionPane.YES_NO_OPTION);
             int talleresFinDeSemana = JOptionPane.showConfirmDialog(null, "¿Desea talleres de fin de semana por valor de 150000?", "Opciones", JOptionPane.YES_NO_OPTION);
 
             // Crear el objeto Niño y asignar las opciones adicionales
             nino nuevoNino = new nino(nombre, edad);
             nuevoNino.setTieneMaterialesPremium(materialesPremium == JOptionPane.YES_OPTION);
             nuevoNino.setTieneClaseIntensivas(clasesIntensivas == JOptionPane.YES_OPTION);
             nuevoNino.setTieneTalleresFinDeSemana(talleresFinDeSemana == JOptionPane.YES_OPTION);
 
             // Agregar el niño al programa
             programaAplicable.obtenerEstudiantes().add(nuevoNino);
 
             // Calcular el valor final para el niño
             double valorFinal = programaAplicable.calcularValorFinal(nuevoNino);
             String valorFormateado = formater.format(valorFinal);  // Formatear el valor
 
             // Guardar la información en el ArrayList de resumen
             String resumen = "Nombre: " + nuevoNino.getNombre() + ", Edad: " + nuevoNino.getEdad() +
                              ", Programa: " + programaAplicable.getNombre() + ", Valor Total: $" + valorFormateado;
             resumenEstudiantes.add(resumen);  // Agregar resumen a la lista
 
             // Mostrar el valor final formateado a pagar
             JOptionPane.showMessageDialog(null, "El valor final a pagar para " + nuevoNino.getNombre() + " es: $" + valorFormateado);
 
             // Preguntar si desea agregar otro estudiante
             int continuar = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro niño?", "Continuar", JOptionPane.YES_NO_OPTION);
             seguir = (continuar == JOptionPane.YES_OPTION);
         }
 
         // Mostrar el resumen de todos los estudiantes al finalizar
         StringBuilder listaFinal = new StringBuilder("TABLA DEL TOTAL DE ESTUDIANTES INGRESADOS:\n");
 
         double totalEscuela = 0;
 
         //for para generar el listado de estudiantes de forma organizada
         for (programa programa : programas) {
             listaFinal.append("_________________________________________________________________\n");
             listaFinal.append("Nombre Programa: ").append(programa.getNombre()).append("\n");
             listaFinal.append("_________________________________________________________________\n");
 
             ArrayList<nino> estudiantesPrograma = programa.obtenerEstudiantes();
             double totalPrograma = 0;
 
             if (estudiantesPrograma.size() > 0) {
                 for (nino estudiante : estudiantesPrograma) {
                     double valorBase = programa.getValorBase();
                     double valorMateriales = estudiante.isTieneMaterialesPremium() ? 300000 : 0;
                     double valorClases = estudiante.isTieneClaseIntensivas() ? 200000 : 0;
                     double valorTalleres = estudiante.isTieneTalleresFinDeSemana() ? 150000 : 0;
                     double totalPagar = valorBase + valorMateriales + valorClases + valorTalleres;
 
                     listaFinal.append("+").append(estudiante.getNombre()).append("(").append(estudiante.getEdad()).append(" años)\n");
                     listaFinal.append(" -Base: ").append(formater.format(valorBase)).append("\n");
                     listaFinal.append(" -MaterialesPremium: ").append(formater.format(valorMateriales)).append("\n");
                     listaFinal.append(" -ClasesIntensivas: ").append(formater.format(valorClases)).append("\n");
                     listaFinal.append(" -TalleresFindeSemana: ").append(formater.format(valorTalleres)).append("\n");
                     listaFinal.append("_________________________________________________________________\n");
                     listaFinal.append("TOTAL A PAGAR: ").append(formater.format(totalPagar)).append("\n");
 
                     totalPrograma += totalPagar;
                 }
 
                 listaFinal.append("TOTAL PROGRAMA: ").append(formater.format(totalPrograma)).append("\n");
                 totalEscuela += totalPrograma;
             } else {
                 listaFinal.append("No hay estudiantes inscritos en este programa.\n");
             }
             listaFinal.append("_________________________________________________________________\n\n");
         }
 
         listaFinal.append("TOTAL ESCUELA: ").append(formater.format(totalEscuela)).append("\n");
         JOptionPane.showMessageDialog(null, listaFinal.toString());
     }
 }
