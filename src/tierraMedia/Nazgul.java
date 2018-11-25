package tierraMedia;

import java.util.HashMap;
import java.util.Map;

public class Nazgul extends Unidad {

    private Map<String, Item> items = new HashMap<>();


    public boolean puedeAtravesarZona(Zona zona) {
        return true;
    }

    @Override
    public boolean cumpleConRazaYNivel(String raza, Integer nivel) {
        return false;
    }

    @Override
    public boolean contieneElemento(String nombreElemento) {
        return false;
    }

    @Override
    public boolean sosViajero() {
        return false;
    }

    @Override
    public void aumentarNivel(Camino camino) {
    }




}
