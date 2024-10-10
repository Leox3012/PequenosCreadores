/** 
@author Leo Valencia Santa 
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

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isTieneMaterialesPremium() {
        return tieneMaterialesPremium;
    }

    public boolean isTieneClaseIntensivas() {
        return tieneClaseIntensivas;
    }

    public boolean isTieneTalleresFinDeSemana() {
        return tieneTalleresFinDeSemana;
    }

   //SETTERS
   public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setEdad(int edad) {
    this.edad = edad;
}

public void setTieneMaterialesPremium(boolean tieneMaterialesPremium) {
    this.tieneMaterialesPremium = tieneMaterialesPremium;
}

public void setTieneClaseIntensivas(boolean tieneClaseIntensivas) {
    this.tieneClaseIntensivas = tieneClaseIntensivas;
}

public void setTieneTalleresFinDeSemana(boolean tieneTalleresFinDeSemana) {
    this.tieneTalleresFinDeSemana = tieneTalleresFinDeSemana;


  }
}