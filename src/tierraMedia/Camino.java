package tierraMedia;

import java.util.*;
import java.util.stream.Collectors;


public class Camino {

    // Los caminos de la tierra media están formados por una sucesión de zonas que deben transitarse en un determinado orden.
    private List<Zona> zonasQueAtraviesa = new ArrayList<Zona>();

    //todo Quizas deba crear un construcctor exigiendo crear al camino con una zona dentro
    // todo, ya que si no hago eso, y al camino le pido sus acciones(metodos) va a romper porque no va a poder recorrer o comparar nada

    public List<Zona> getZonasQueAtraviesa() {
        return zonasQueAtraviesa;
    }

    // 2). Saber cuántas regiones atraviesa un camino de acuerdo a las zonas que incluye.
    // 4). Agregar una zona a un camino, al final del mismo. Esto puede hacerse sólo si la zona que se agrega limita con la última del camino.
    public void addZona(Zona zona) {     // el ultimo elemento de la lista (Ultima zona)//
        if (zonasQueAtraviesa.isEmpty() || ultimaZona().limitaConZona(zona)) {
            zonasQueAtraviesa.add(zona);
            // todo Ver exepciones;
        }
    }

    private Zona ultimaZona() {
        return zonasQueAtraviesa.get(zonasQueAtraviesa.size() - 1);
    }

    public Collection<Region> regionesAtravesadas() {
        return zonasQueAtraviesa.stream().map(zona -> zona.getRegion()).collect(Collectors.toSet());
    }

    public Integer cantidadRegionesAtravesadas() {
        return regionesAtravesadas().size();
    }

    // Saber si, en la Tierra Media, se cumple que todos los caminos conducen a Mordor.
    // Un camino conduce a Mordor si el nombre de la región de la última zona del mismo es, justamente, ‘Mordor’.
    public boolean conduceAMordor() {
        return ultimaZona().getRegion().getNombre().equals("Mordor");
    }
}
