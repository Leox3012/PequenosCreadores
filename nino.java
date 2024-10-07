/** 
@author Leo V 
@version 1.0 
@since 2024
@param argumentos de la linea de comandos 
 */

public class nino {
    
    //VARIABLES
    String nombre;
    int edad;
    boolean tieneMaterialesPremium;
    boolean tieneClaseIntensivas;
    boolean tieneTalleresFinDeSemana;

    //CONSTRUCTORES BASICO
    public nino(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.tieneMaterialesPremium = false;  // Por defecto
        this.tieneClaseIntensivas = false;       // Por defecto
        this.tieneTalleresFinDeSemana = false;   // Por defecto
    }


    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isTieneMaterialesPremium() {
        return tieneMaterialesPremium;
    }

    public void setTieneMaterialesPremium(boolean tieneMaterialesPremium) {
        this.tieneMaterialesPremium = tieneMaterialesPremium;
    }

    public boolean isTieneClaseIntensivas() {
        return tieneClaseIntensivas;
    }

    public void setTieneClaseIntensivas(boolean tieneClaseIntensivas) {
        this.tieneClaseIntensivas = tieneClaseIntensivas;
    }

    public boolean isTieneTalleresFinDeSemana() {
        return tieneTalleresFinDeSemana;
    }

    public void setTieneTalleresFinDeSemana(boolean tieneTalleresFinDeSemana) {
        this.tieneTalleresFinDeSemana = tieneTalleresFinDeSemana;
    }
}
