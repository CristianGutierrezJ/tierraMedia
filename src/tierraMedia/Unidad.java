package tierraMedia;

import java.util.Map;

public abstract class Unidad {

    public abstract void aumentarNivel();

    public abstract Integer getNivel();

    public abstract String getRaza();

    public abstract Map<String, Item> getItems();

    public abstract boolean puedeAtravesarZona(Zona zona);

    public abstract boolean cumpleConRazaYNivel(String raza, Integer nivel);

}
