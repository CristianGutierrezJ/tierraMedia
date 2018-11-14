package tierraMedia;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegionTest {

    // Saber si dos regiones son limítrofes. Lo son si tienen zonas (al menos una de cada región) que son limítrofes.
    @Test
    public void testDosRegionesSonLimitrofes() {
        Region caba = new Region("CABA");
        Region buenosAires = new Region("Buenos Aires");
        Region cordoba = new Region("Cordoba");


        Zona retiro = new Zona("Retiro", caba);
        Zona recoleta = new Zona("Recoleta", caba);
        Zona saavedra = new Zona("Saavedra", caba);
        Zona villaMartelli = new Zona("Villa Martelli", buenosAires);
        Zona laPlata = new Zona("La Plata", buenosAires);

        retiro.addZonaLimitrofe(recoleta);
        recoleta.addZonaLimitrofe(retiro);
        saavedra.addZonaLimitrofe(villaMartelli);
        villaMartelli.addZonaLimitrofe(saavedra);

        //System.out.println(caba.limitasConEstaRegion(buenosAires));
        Assert.assertTrue(caba.limitasConEstaRegion(buenosAires));
        Assert.assertFalse(caba.limitasConEstaRegion(cordoba));

    }


}
