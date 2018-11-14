package tierraMedia;

import java.util.stream.Collectors;

public class RequerimientoDeIntegrante extends Requerimiento {

    private String raza;
    private Integer nivel;
    private Integer cantidad;


    public RequerimientoDeIntegrante(String raza, Integer nivel, Integer cantidad) {
        this.raza = raza;
        this.nivel = nivel;
        this.cantidad = cantidad;
    }

    @Override
    public boolean cumpleConLasNormas(Grupo grupo) {
        return grupo.getViajeros().stream().filter(viajero -> viajero.getRaza().equals(raza) && viajero.getNivel()>=(nivel))
                .collect(Collectors.toList()).size() >= cantidad;
    }

}
