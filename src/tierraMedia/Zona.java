import java.util.*;

public class Zona {

    private String nombre;
    private Region region;
    private Collection<Zona> zonasLimitrofes;

    private Requerimiento requerimiento;
    private Collection<Requerimiento> requerimientos = new HashSet<>();

    public Zona(String nombre, Region region, Requerimiento requerimiento) {
        this.nombre = nombre;
        this.region = region;
        this.requerimiento = requerimiento;
        this.zonasLimitrofes = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<Zona> getZonasLimitrofes() {
        return zonasLimitrofes;
    }

    public Region getRegion() {
        return region;
    }

    public void addZonaLimitrofe(Zona zona){
        zonasLimitrofes.add(zona);
    }




    public boolean limitoConEstaRegion(Collection<Zona> zonas){ // Collection de zonas que cotiene la region que comparo
        /*for (Zona zona: zonasRegion2 ) {
            if(zona.getZonasLimitrofes().contains(this)){
                return true;
            }
        }
        return false; */

        //return zonasRegion2.stream().anyMatch(zona -> zona.getZonasLimitrofes().contains(this));

        //return zonasRegion2.stream().anyMatch(zona -> this.getZonasLimitrofes().contains(zona));

        return zonas.stream().anyMatch(zona -> this.limitoConEstaZona(zona));
    }

    public boolean limitoConEstaZona(Zona zona){
        return this.zonasLimitrofes.contains(zona);
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
