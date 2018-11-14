package tierraMedia;

import java.util.*;

public class Zona {

    private String nombre;
    private Region region;
    private Collection<Zona> zonasLimitrofes = new HashSet<>();
    private Collection<Requerimiento> requerimientos = new HashSet<>();


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
//............

    public void addRequerimiento(Requerimiento requerimiento){
        requerimientos.add(requerimiento);
    }

    public void addZonaLimitrofe(Zona zona) {
        zonasLimitrofes.add(zona);
    }

    public boolean limitoConEstaRegion(Collection<Zona> zonas) { // Collection de zonas que cotiene la region que comparo
        /*for (tierraMedia.Zona zona: zonasRegion2 ) {
            if(zona.getZonasLimitrofes().contains(this)){
                return true;
            }
        }
        return false; */

        //return zonasRegion2.stream().anyMatch(zona -> zona.getZonasLimitrofes().contains(this));

        //return zonasRegion2.stream().anyMatch(zona -> this.getZonasLimitrofes().contains(zona));

        return zonas.stream().anyMatch(zona -> this.limitoConEstaZona(zona));
    }

    public boolean limitoConEstaZona(Zona zona) {
        return this.zonasLimitrofes.contains(zona);
    }

    public boolean evaluarRequerimientos(Grupo grupo) {
        requerimientos.stream().;
        grupo.getViajeros().stream().filter(viajero -> requerimientos.stream().)
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
