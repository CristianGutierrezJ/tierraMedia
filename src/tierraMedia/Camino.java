import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class Camino {

    // Los caminos de la tierra media están formados por una sucesión de zonas que deben transitarse en un determinado orden.
    private List<Zona> zonasAtravesadas = new ArrayList<>();
    private Collection<Region> regionesAtravesadas = new HashSet<>();


    // 2). Saber cuántas regiones atraviesa un camino de acuerdo a las zonas que incluye.
    // 4). Agregar una zona a un camino, al final del mismo. Esto puede hacerse sólo si la zona que se agrega limita con la última del camino.
    public void addZona(Zona zona){     // el ultimo elemento de la lista (Ultima zona)//
        if(zonasAtravesadas.isEmpty() || zonasAtravesadas.get(zonasAtravesadas.size()-1).limitoConEstaZona(zona)){
            zonasAtravesadas.add(zona);
        }
    }

    private void atravesarZonas(){
        regionesAtravesadas = zonasAtravesadas.stream().map(zona -> zona.getRegion()).collect(Collectors.toList());
    }

    public Integer cantidadDeRegionesAtravesadas(){
        atravesarZonas();
        return regionesAtravesadas.size();
    }



}
