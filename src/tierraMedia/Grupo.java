package tierraMedia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grupo {

    private Collection<Unidad> unidades = new ArrayList<>();
    private final static Double PORCENTAJE_DE_FAMILIARIDAD = 80.00;


    public Collection<Unidad> getUnidades() {
        return unidades;
    }

    public static Double getPorcentajeDeFamiliaridad() {
        return PORCENTAJE_DE_FAMILIARIDAD;
    }

    public void addUnidad(Unidad unidad) {
        unidades.add(unidad);
    }

    // Saber si un grupo puede atravesar una zona.
    // Puede hacerlo cuando el grupo cumple todos sus requerimientos.

    protected boolean sonAptosParaAtravesarZona(Zona zona) {
        return unidades.stream()
                .allMatch(unidad -> unidad.puedeAtravesarZona(zona));
    }

    public boolean puedeAtravesarZona(Zona zona) {
        if (sonAptosParaAtravesarZona(zona)) {
            return zona.grupoPuedeAtravesar(this);
        } else return false;
    }


    // Saber si un grupo se siente como en casa en una región,
    //  que es cuando al menos un porcentaje dado de las zonas de la región pueden ser atravesadas por el mismo.
    // El porcentaje es igual para cualquier grupo.
    public boolean seSientenComoEnCasa(Region region) {
        return porcentajeDeZonasAtravesadasDeRegion(region) >= PORCENTAJE_DE_FAMILIARIDAD;
    }


    public Double porcentajeDeZonasAtravesadasDeRegion(Region region) {
        return porcentajeDeZonasAtravesadas(region.getZonas());
    }

    public Double porcentajeDeZonasAtravesadas(Collection<Zona> zonas) {
        Integer porcentajeInt = zonasQuePuedenAtravesar(zonas).size() * 100 / zonas.size();
        Double porcentajeDouble = new Double(porcentajeInt);  // o porcentajeInt * 1.0
        return porcentajeDouble;
    }

    private Collection<Zona> zonasQuePuedenAtravesar(Collection<Zona> zonas) {
        return zonas.stream().filter(zona -> puedeAtravesarZona(zona)).collect(Collectors.toList());
    }

    public void atravesarCamino(Camino camino) {

        // Filtro la lista de unidades a los que solo son viajeros, ¡¡OJO!! esa lista es <UNIDAD>
        List<Unidad> unidadesViajeros = unidades.stream().filter(unidad -> (unidad.sosViajero())).collect(Collectors.toList());

        // Si no hay viajeros en las unidades NO hacer nada
        if (!unidadesViajeros.isEmpty()) {
// Separo los viajeros de las unidades
            // Creo una lista <VIAJERO>
            List<Viajero> viajeros = new ArrayList<>();
            // Casteo la lista anterior (tipo <UNIDAD> a <VIAJERO>), y guardo sus elementos a la lista<VIAJERO> antes creada
            unidadesViajeros.forEach(unidad -> viajeros.add((Viajero) unidad));
//
            // Si el grupo atraviesa, aumento el nivel las unidades
            if (camino.grupoPuedeAtravesar(this)) {
                unidades.forEach(unidad -> unidad.aumentarNivel(camino));

                // Si no atraviesa, el viajero de menor nivel se elimina
            } else {
                unidades.remove(viajeros.stream().min(Comparator.comparingInt(Viajero::getNivel)).get());
            }

        }

    }


}
