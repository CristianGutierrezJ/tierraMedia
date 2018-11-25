package tierraMedia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean sonAptosParaAtravesarZona(Zona zona) {
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
        // Hacer que un grupo transite un camino.
        // Cuando el grupo efectivamente atraviesa todas las zonas,
        // aumenta el nivel de cada integrante en una unidad por cada zona atravesada.
        // Si el grupo no logra atravesarlas en su totalidad,
        // entonces no se aumenta el nivel de los integrantes, y además muere el integrante de menor nivel (se elimina del grupo).

        // Creo una lista <VIAJERO>
        List<Viajero> viajeros = new ArrayList<>();
        // Filtro la lista de unidades a los que solo son viajeros, ¡¡OJO!! esa lista es <UNIDAD>
        List<Unidad> unidadesViajeros = unidades.stream().filter(unidad -> (unidad.sosViajero())).collect(Collectors.toList());
        // Casteo la lista anterior (tipo <UNIDAD> a <VIAJERO>), y guardo sus elementos a la lista<VIAJERO> antes creada
        unidadesViajeros.forEach(unidad -> viajeros.add((Viajero)unidad));

        // Creo un viajero para guardar informacion y luego eliminarlo
        Viajero viajeroMenorNivel = new Viajero("a","a" , 99);

        if(!unidadesViajeros.isEmpty()) { // Si no hay viajeros en las unidades NO hacer nada
            if (porcentajeDeZonasAtravesadas(camino.getZonasQueAtraviesa()) == 100.0) {
                unidades.forEach(unidad -> unidad.aumentarNivel());
            } else {
                Comparator<Viajero> comparator = (viajero1, viajero2) -> compararNivel(viajero1.getNivel(), viajero2.getNivel());
                //Comparator<Unidad> comparator = (unidad1, unidad2) -> Integer.compare(unidad1.getNivel(), unidad2.getNivel());
                // Comparator.comparingInt(Viajero::getNivel)

                viajeroMenorNivel = viajeros.stream().min(comparator).get();
            }
            unidades.remove(viajeroMenorNivel);
        }

    }





    private Integer compararNivel(Integer nivelUnidad1, Integer nivelUnidad2) {
        if (nivelUnidad1 == null) {
            return nivelUnidad2;
        } else if (nivelUnidad2 == null) {
            return nivelUnidad1;
        }
        // todo: Filtrar si ambos son nulos
        else {
            return Integer.compare(nivelUnidad1, nivelUnidad2);
        }
    }


}
