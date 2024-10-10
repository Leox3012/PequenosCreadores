/** 
@author Leo Valencia Santa 
@version 1.0 
@since 2024
@param argumentos de la linea de comandos 
 */

 import java.util.ArrayList;

 public class programa {
    
    //CONSTANTES
    final double VALOR_MATERIALES_PREMIUM = 300000;
    final double VALOR_CLASES_INTENSIVAS = 200000;
    final double VALOR_TALLERES_FIN_DE_SEMANA = 150000;

    //VARIABLES
    String nombre;
    double valorBase;
    int edadMinima;
    int edadMaxima;
    ArrayList<nino> estudiantes;

    //GETTERS Y SETTERS
    public double getVALOR_MATERIALES_PREMIUM() {
        return VALOR_MATERIALES_PREMIUM;
    }
    
    public double getVALOR_CLASES_INTENSIVAS() {
        return VALOR_CLASES_INTENSIVAS;
    }
    
    public double getVALOR_TALLERES_FIN_DE_SEMANA() {
        return VALOR_TALLERES_FIN_DE_SEMANA;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getValorBase() {
        return valorBase;
    }
    
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
    
    public int getEdadMinima() {
        return edadMinima;
    }
    
    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
    
    public int getEdadMaxima() {
        return edadMaxima;
    }
    
    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }
    
    public ArrayList<nino> getEstudiantes() {
        return estudiantes;
    }
    
    public void setEstudiantes(ArrayList<nino> estudiantes) {
        this.estudiantes = estudiantes;
    }

    //CONSTRUCTORES BASICO
public programa (String nombre, double valorBase, int edadMinima, int edadMaxima){
        this.nombre = nombre;
        this.valorBase = valorBase;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.estudiantes = new ArrayList<>();

      }

    

    //LISTA DE ESTUDIANTES
    public ArrayList<nino> obtenerEstudiantes(){
        return this.estudiantes;
    }


    //CALCULAR VALOR FINAL
        public double calcularValorFinal(nino nino) {
            double valorFinal = this.valorBase;
            if (nino.tieneMaterialesPremium) {
                valorFinal += VALOR_MATERIALES_PREMIUM;
            }
            if (nino.tieneClaseIntensivas) {
                valorFinal += VALOR_CLASES_INTENSIVAS;
            }
            if (nino.tieneTalleresFinDeSemana) {
                valorFinal += VALOR_TALLERES_FIN_DE_SEMANA;
            }
            return valorFinal;
        }
}