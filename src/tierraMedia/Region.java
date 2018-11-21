package tierraMedia;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class Region {

    private String nombre;
    private Collection<Zona> zonas;                 //Las Regiones contienen ZONAS;
    private Collection<Region> regionesLimitrofes;
    //Cada zona perteneciente a la region, entiende el porcentaje de familiaridad;

    public Region(String nombre) {
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

    public void addRegionLimitrofe(Region region) {
        if (limitasConEstaRegion(region)) {
            regionesLimitrofes.add(region);
        }
    }

    public void addZona(Zona zona) {
        zonas.add(zona);
    }


    // 1). Saber si dos regiones son limítrofes.
    // Lo son si tienen zonas (al menos una de cada región) que son limítrofes.
    public Boolean limitasConEstaRegion(Region region) {
        return this.zonas.stream().anyMatch(zona -> zona.limitaConAlgunaZona(region.zonas));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(nombre, region.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
