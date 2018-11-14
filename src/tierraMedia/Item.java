package tierraMedia;

public class Item {

    private String nombre;
    private Integer cantidad;


    public Item(String nombre, Integer cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }



}
