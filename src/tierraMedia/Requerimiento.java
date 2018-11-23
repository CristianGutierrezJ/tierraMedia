package tierraMedia;

public abstract class Requerimiento {

    private Integer cantidad;

    public Requerimiento(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public abstract boolean grupoCumpleConLasNormas(Grupo grupo);


}
