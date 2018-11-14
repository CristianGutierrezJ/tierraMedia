import java.util.ArrayList;
import java.util.Collection;

public class Grupo {

    private Collection<Viajero> viajeros = new ArrayList<>();


    // Saber si un grupo puede atravesar una zona.
    // Puede hacerlo cuando el grupo cumple todos sus requerimientos.
    public void addViajero(Viajero viajero){
        viajeros.add(viajero);
    }

    public boolean puedoAtravesarEstaZona(Zona zona){

    }


}
