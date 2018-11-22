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
    public String getRaza() {
        return null;
    }

    @Override
    public Map<String, Item> getItems() {
        return items;
    }


}
