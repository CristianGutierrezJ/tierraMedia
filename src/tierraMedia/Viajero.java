package tierraMedia;

import java.util.HashMap;
import java.util.Map;

public class Viajero extends Unidad{

    private String nombre;
    private String raza;
    private Integer nivel;
    private Map<String, Item> items; // Elementos que posee


    public Viajero(String nombre, String raza, Integer nivel) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.items = new HashMap<>();
    }


    public String getRaza() {
        return raza;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    @Override
    public boolean puedeAtravesarZona(Zona zona) {
        return true;
    }

    public void addItem(Item item) {
        Item itemTemp = items.get(item.getNombre());
        //Item itemCopy = new Item(itemTemp.getNombre(), itemTemp.getCantidad()); Como copiar el item de un mapa;
        if (itemTemp != null) { // Evito preguntar si contiene el item, ya que si no lo contiene (return null), evitar eso;
            itemTemp.acumularCantidad(item);
            items.put(item.getNombre(), itemTemp);
        } else {
            items.put(item.getNombre(), item);
        }
    }

    public boolean cumpleConRazaYNivel(String raza, Integer nivel) {
        return getRaza().equals(raza) && getNivel() >= (nivel);
    }


    public void aumentarNivel() {
        this.nivel++;
    }

}
