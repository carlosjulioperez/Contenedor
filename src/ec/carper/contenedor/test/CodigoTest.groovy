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
    void testSecoAgregarItemsElementCollection(){
        def seco = new Seco()
        
        seco.detalle = new ArrayList()
        
        // Detalles normales
        def d1 = new SecoDetalle()
        d1.codigo = "01"
        seco.detalle.add(d1)

        def d2 = new SecoDetalle()
        d2.codigo = "02"
        seco.detalle.add(d2)

        seco.detalle.each{
            println it.codigo
        }
        println (seco)

        //seco.detalle.add(new SecoDetalle())

    }

}
