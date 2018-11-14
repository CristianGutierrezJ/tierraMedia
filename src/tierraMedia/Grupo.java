package tierraMedia;

import java.util.ArrayList;
import java.util.Collection;

public class Grupo {

    private Collection<Viajero> viajeros = new ArrayList<>();


    public Collection<Viajero> getViajeros() {
        return viajeros;
    }

    // Saber si un grupo puede atravesar una zona.
    // Puede hacerlo cuando el grupo cumple todos sus requerimientos.
    public void addViajero(Viajero viajero) {
        viajeros.add(viajero);
    }

    public boolean puedoAtravesarEstaZona(Zona zona) {
        return zona.evaluarRequerimientos(this);
    }


}
