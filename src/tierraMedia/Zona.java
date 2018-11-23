package tierraMedia;

import java.util.*;

public class Zona {

    private String nombre;
    private Region region;
    private Collection<Zona> zonasLimitrofes = new HashSet<>();
    private Collection<Requerimiento> requerimientos = new HashSet<>();
    private boolean terrenoPantanoso = false;

    public Zona(String nombre, Region region) {
        this.nombre = nombre;
        this.region = region;
        region.addZona(this);
        this.zonasLimitrofes = new HashSet<>();
    }

    public Zona(String nombre, Region region, Collection<Requerimiento> requerimientos) {
        this.nombre = nombre;
        this.region = region;
        this.requerimientos = requerimientos;
    }

    //........... SETTER
    public void setTerrenoPantanoso(boolean terrenoPantanoso) {
        this.terrenoPantanoso = terrenoPantanoso;
    }

    //........... GETTERS
    public String getNombre() {
        return nombre;
    }

    public Collection<Zona> getZonasLimitrofes() {
        return zonasLimitrofes;
    }

    public Region getRegion() {
        return region;
    }

    public Collection<Requerimiento> getRequerimientos() {
        return requerimientos;
    }

    public boolean isTerrenoPantanoso() {
        return terrenoPantanoso;
    }
    //............

    public void addRequerimiento(Requerimiento requerimiento) {
        requerimientos.add(requerimiento);
    }

    public void addZonaLimitrofe(Zona zona) {
        zonasLimitrofes.add(zona);
    }

    public boolean limitaConAlgunaZona(Collection<Zona> zonas) { // Collection de zonas que cotiene la region que comparo
        /*for (tierraMedia.Zona zona: zonasRegion2 ) {
            if(zona.getZonasLimitrofes().contains(this)){
                return true;
            }
        }
        return false; */
        return zonas.stream().anyMatch(zona -> this.limitaConZona(zona));
    }

    public boolean limitaConZona(Zona zona) {
        return this.zonasLimitrofes.contains(zona);
    }


    public boolean grupoPuedeAtravesar(Grupo grupo) {
        return requerimientos.stream().allMatch(requerimiento -> requerimiento.grupoCumpleConLasNormas(grupo));
    }


    public boolean esPantanoso() {
        return this.terrenoPantanoso;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zona zona = (Zona) o;
        return Objects.equals(nombre, zona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
