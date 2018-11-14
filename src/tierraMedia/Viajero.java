package tierraMedia;

import java.util.HashMap;
import java.util.Map;

public class Viajero {

    private String nombre;
    private String raza;
    private Integer nivel;
    private Map<String, Item> items; // Elementos que posee

    private Integer cantidadtemp = 0;
    private Item itemTemp;


    public String getRaza() {
        return raza;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public Viajero(String nombre, String raza, Integer nivel) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.items = new HashMap<>();
    }

    public void addItem(Item item) {
        if (items.containsKey(item.getNombre())) {
            itemTemp = items.get(item.getNombre());
            cantidadtemp = itemTemp.getCantidad() + item.getCantidad();
            itemTemp.setCantidad(cantidadtemp);
            items.put(item.getNombre(), itemTemp);
        } else {
            items.put(item.getNombre(), item);
        }
    }


}
