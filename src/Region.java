import java.util.Collection;
import java.util.HashSet;

public class Region {

    private String nombre;
    private Collection<Zona> zonas;                 //Las Regiones contienen ZONAS;
    private Collection<Region> regionesLimitrofes;

    public Region(String nombre){
        this.nombre = nombre;
        this.zonas = new HashSet<>();
        this.regionesLimitrofes = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<Zona> getZonas() {
        return zonas;
    }

    public Collection<Region> getRegionesLimitrofes() {
        return regionesLimitrofes;
    }

    public void addRegionLimitrofe(Region region){
        regionesLimitrofes.add(region);
    }

    public void addZona(Zona zona){
        zonas.add(zona);
    }


    // 1). Saber si dos regiones son limítrofes.
    // Lo son si tienen zonas (al menos una de cada región) que son limítrofes.
    public Boolean limitasConEstaRegion(Region region){
        return this.zonas.stream().anyMatch(zona -> zona.limitasConEstaZona(region.zonas));
    }




}
