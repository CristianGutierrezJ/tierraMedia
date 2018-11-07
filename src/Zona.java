import java.util.*;

public class Zona {

    private String nombre;
    private Collection<Zona> zonasLimitrofes;
    private List<String> requerimientos;


    public Zona(String nombre) {
        this.nombre = nombre;
        this.requerimientos = new ArrayList<>();
        this.zonasLimitrofes = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<Zona> getZonasLimitrofes() {
        return zonasLimitrofes;
    }

    public void addZonaLimitrofe(Zona zona){
        zonasLimitrofes.add(zona);
    }

    public Integer cantidadDeRequerimientos(){
        return requerimientos.size();
    }




    public boolean limitasConEstaZona(Collection<Zona> zonas){
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

    private boolean limitoConEstaZona(Zona zona){
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
