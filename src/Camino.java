import java.util.Collection;
import java.util.HashSet;

import static java.util.stream.Collectors.groupingBy;


public class Camino {

    private Collection<Zona> zonasAtravesadas = new HashSet<>();



    // 2). Saber cuántas regiones atraviesa un camino de acuerdo a las zonas que incluye.
    public void addZona(Zona zona){
        zonasAtravesadas.add(zona);
    }

    public Integer cantidadDeRegionesAtravesadas(){

        zonasAtravesadas.stream().collect(groupingBy(Zona::getRegion()))
    }


}
