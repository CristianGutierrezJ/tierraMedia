import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Viajero {

    private String nombre;
    private Integer nivel;
    private String raza;
    private Map<String,Item> items;

    private Integer cantidadtemp = 0;
    private Item itemTemp;


    public Viajero(String nombre, Integer nivel, String raza) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.raza = raza;
        this.items = new HashMap<>();
    }

    public void addItem(Item item){
        if(items.containsKey(item.getNombre())){
            itemTemp = items.get(item.getNombre());
            cantidadtemp = itemTemp.getCantidad() +  item.getCantidad();
            itemTemp.setCantidad(cantidadtemp);
            items.put(item.getNombre(), itemTemp);
        }else {
            items.put(item.getNombre(), item);
        }
    }



}
