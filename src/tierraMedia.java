import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class tierraMedia {
    // Key: String -> nombre de la region
    // Value: Collection<Zona>  ->  Zonas que contiene la region
    private Map<String, Collection<Zona>> regiones;

    public tierraMedia() {
        this.regiones = new HashMap<>();
    }


    public void addRegion(Region region) {
        if (!regiones.containsKey(region.getNombre())) {
            regiones.put(region.getNombre(), region.getZonas());
        }
    }





}
