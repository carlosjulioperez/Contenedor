package ec.carper.contenedor.test

import org.openxava.tests.*

class SellosCierreContenedorTest extends ModuleTestBase {

    SellosCierreContenedorTest(String testName) {
        super(testName, "Contenedor", "SellosCierreContenedor")
    }

    void testCrear() throws Exception {
        login("admin", "admin")
        
        execute("CRUD.new")
        setValue("cliente.id", "1")
        setValue("contenedor.id" , "1")
        setValue("factura" , "1234567890123")
        setValue("horaIni" , "09:15")
        setValue("horaFin" , "11:07")

        setValueInCollection("detalle1" , 0 , "tiposSellos" , "TIPOSELLO001")
        setValueInCollection("detalle1" , 0 , "numeracion"  , "ABC123")
        setValueInCollection("detalle1" , 1 , "tiposSellos" , "TIPOSELLO002")
        setValueInCollection("detalle1" , 1 , "numeracion"  , "ABC456")

        execute ('Sections.change','activeSection=1')
        setValueInCollection("detalle2" , 0 , "numeroSello" , "NUM001")
        setValueInCollection("detalle2" , 0 , "horaSel"     , "08:30")
        setValueInCollection("detalle2" , 0 , "horaRup"     , "10:30")
        
        setValueInCollection("detalle2" , 1 , "numeroSello" , "NUM002")
        setValueInCollection("detalle2" , 1 , "horaSel"     , "12:30")
        setValueInCollection("detalle2" , 1 , "horaRup"     , "14:30")
        
        execute ('Sections.change','activeSection=2')
        setValueInCollection("detalle3" , 0 , "nombre"  , "MARCELO ALAVA")
        setValueInCollection("detalle3" , 0 , "cedula"  , "0909094445")
        setValueInCollection("detalle3" , 0 , "empresa" , "EMPRESA 01")
        setValueInCollection("detalle3" , 0 , "cargo"   , "CARGO 01")
        
        setValueInCollection("detalle3" , 1 , "nombre"  , "GONZALO GUAMAN")
        setValueInCollection("detalle3" , 1 , "cedula"  , "0808083334")
        setValueInCollection("detalle3" , 1 , "empresa" , "EMPRESA 02")
        setValueInCollection("detalle3" , 1 , "cargo"   , "CARGO 02")
        
        execute ("Contenedor.save")

        // **************************************************
        // FINALIZAR
        //execute    ("CRUD.delete")
        assertNoErrors()
    }

}
