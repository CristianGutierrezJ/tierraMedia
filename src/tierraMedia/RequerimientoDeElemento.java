package tierraMedia;

import java.util.stream.Collectors;

public class RequerimientoDeElemento extends Requerimiento {

    private String nombreElemento;

    public RequerimientoDeElemento(String nombreElemento, Integer cantidad) {
        super(cantidad);
        this.nombreElemento = nombreElemento;
    }


    @Override
    public boolean grupoCumpleConLasNormas(Grupo grupo) {
        return grupo.getUnidades().stream()
                .filter(unidad -> unidad.contieneElemento(nombreElemento))
                .collect(Collectors.toList())
                .size() >= this.getCantidad();
    }


}
