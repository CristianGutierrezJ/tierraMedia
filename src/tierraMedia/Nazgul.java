package tierraMedia;

import java.util.HashMap;
import java.util.Map;

public class Nazgul extends Unidad {

    private Map<String, Item> items = new HashMap<>();


    public boolean puedeAtravesarZona(Zona zona) {
        return true;
    }


    @Override
    public void aumentarNivel() {
    }

    @Override
    public Integer getNivel() {
        return null;
    }

    @Override
    public boolean cumpleConRazaYNivel(String raza, Integer nivel) {
        return false;
    }

    @Override
    public Map<String, Item> getItems() {
        return items;
    }


}
