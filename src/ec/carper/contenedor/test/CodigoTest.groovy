package ec.carper.contenedor.test

import ec.carper.contenedor.model.*

import java.time.LocalDate
import java.time.format.*

class CodigoTest extends GroovyTestCase {

    // https://groovy-lang.org/testing.html
    /*
    void testAssertions() {
        assertTrue(1 == 1)
        assertEquals("test", "test")

        def x = "42"
        assertNotNull "x must not be null", x
        assertNull null

        assertSame x, x
    }
    */

    // https://en.wikibooks.org/wiki/Java_Persistence/ElementCollection
    void testInspeccionAgregarItemsElementCollection(){
        def inspeccion = new Inspeccion()
        
        inspeccion.detalle = new ArrayList()
        
        // Detalles normales
        def d1 = new InspeccionDetalle()
        d1.codigo = "01"
        inspeccion.detalle.add(d1)

        def d2 = new InspeccionDetalle()
        d2.codigo = "02"
        inspeccion.detalle.add(d2)

        inspeccion.detalle.each{
            println it.codigo
        }
        println (inspeccion)

        //inspeccion.detalle.add(new InspeccionDetalle())

    }

}
