package tierraMedia;

import java.util.stream.Collectors;

public class RequerimientoDeElemento extends Requerimiento {

    private String nombreElemento;

    public RequerimientoDeElemento(String nombreElemento, Integer cantidad) {
        super(cantidad);
        this.nombreElemento = nombreElemento;
    }



    @Override
    public boolean grupoCumpleConLasNormas(Grupo grupo, Zona zona) {
        return grupo.getUnidades().stream()
                .filter(unidad -> unidad.puedeAtravesarZona(zona))
                .filter(unidad -> unidad.getItems().containsKey(nombreElemento))
                .collect(Collectors.toList())
                .size() >= this.getCantidad();
    }



}
