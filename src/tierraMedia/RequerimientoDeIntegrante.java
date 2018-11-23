package tierraMedia;

import java.util.stream.Collectors;

public class RequerimientoDeIntegrante extends Requerimiento {

    private String raza;
    private Integer nivel;


    public RequerimientoDeIntegrante(String raza, Integer nivel, Integer cantidad) {
        super(cantidad);
        this.raza = raza;
        this.nivel = nivel;
    }



    @Override
    public boolean grupoCumpleConLasNormas(Grupo grupo, Zona zona) {
        return grupo.getUnidades().stream()
                .filter(unidad -> unidad.puedeAtravesarZona(zona))
                .filter(unidad -> unidad.cumpleConRazaYNivel(raza, nivel))
                .collect(Collectors.toList())
                .size() >= this.getCantidad();
    }


}
