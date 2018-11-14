package tierraMedia;

public abstract class Requerimiento {

    private Integer cantidad;
    private String elemento;
    private String raza;

    public abstract boolean cumpleConLasNormas(Grupo grupo);

}
