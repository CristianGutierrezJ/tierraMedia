package tierraMedia;


public abstract class Unidad {

    public abstract void aumentarNivel(Camino camino);


    public abstract boolean puedeAtravesarZona(Zona zona);

    public abstract boolean cumpleConRazaYNivel(String raza, Integer nivel);

    public abstract boolean contieneElemento(String nombreElemento);

    public abstract boolean sosViajero();
}
