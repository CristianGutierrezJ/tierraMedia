package tierraMedia;

public class RequerimientoDeElemento extends Requerimiento {

    private String nombre;

    @Override
    public boolean cumpleConLasNormas(Grupo grupo) {
        return grupo.getViajeros().stream().anyMatch(viajero -> viajero.getItems().containsKey(nombre));
    }


}
