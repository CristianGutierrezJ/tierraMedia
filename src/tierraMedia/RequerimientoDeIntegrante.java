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
    public boolean cumpleConLasNormas(Grupo grupo) {
        return grupo.getUnidades().stream()
                .filter(unidad -> unidad instanceof Viajero )
                .filter(unidad -> unidad.cumpleConRazaYNivel(raza, nivel))
                .collect(Collectors.toList())
                .size() >= this.getCantidad();
    }

    public boolean cumpleConLasNormas(Unidad unidad) {
        return unidad.cumpleConRazaYNivel(raza, nivel);
    }
}
