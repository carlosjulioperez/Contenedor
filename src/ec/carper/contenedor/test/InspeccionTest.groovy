package ec.carper.contenedor.test

import org.openxava.tests.*

class InspeccionTest extends ModuleTestBase {

    InspeccionTest(String testName) {
        super(testName, "Contenedor", "Inspeccion")
    }

    void testCrear() throws Exception {
        login("admin", "admin")
        
        execute("CRUD.new")
        setValue("contenedor" , "JUNIT")
        setValue("contenedorTipo" , "1") //Seco / Refrigerado
        // setValue("fecha" , Aux.instance.fechaActual )
        // setValue("fecha" , "10/09/2020" )
        execute ("Contenedor.save")
        assertNoErrors()

        // setConditionComparators ( new String[] { "=", "contains_comparator" } )
        // setConditionValues      ( new String[] { "", "JUNIT" } )
        setConditionValues      ( [ "", "", "JUNIT" ] )
        setConditionComparators ( [ "", "=", "contains_comparator" ] )
        execute ("List.filter")
        execute ("List.viewDetail", "row=0")
        execute ("Inspeccion.cargarItems")
        //printHtml()
        assertNoErrors()
        
        setValue("lugar" , "LUGAR")
        setValue("cliente.id", "1")
        setValue("referencia", "REFERENCIA")
        setValue("naviera.id", "01")
        setValue("observaciones", "OBSERVACIONES")

        execute ('Sections.change', 'activeSection=1')
        setValue("inspectorHoraArribo", "08:00")
        setValue("inspectorHoraInicio", "09:00")
        setValue("inspectorHoraTermino", "10:00")
        
        execute ('Sections.change', 'activeSection=1,viewObject=xava_view_section1')
        setValue("chofer", "JUAN ARIAS")
        setValue("placaCamion", "ABC123")
        
        execute ('Sections.change', 'activeSection=2,viewObject=xava_view_section1')
        setValue("selloArribo", "ARRIBO 123")
        setValue("selloSPS", "SPS 123")
        setValue("selloCliente", "CLIENTE 123")
        setValue("selloNaviera", "NAVIERA 123")
        
        execute ('Sections.change', 'activeSection=3,viewObject=xava_view_section1')
        setValue("inspectorSPSNombre", "ANDRES ABAD")
        setValue("inspectorSPSCC", "1234567890123")
        setValue("repCliNombre", "JORGE MORAN")
        setValue("repCliCC", "1234567890123")
        setValue("repArea", "LUIS LOPEZ")
        setValue("repAreaCC", "1234567890123")
        
        execute ("Contenedor.save")

        //assertCollectionRowCount("detalle1", 62)
        // execute("Collection.edit" , "row=0,viewObject=xava_view_section0_detalle1")
        // assertDialog()
        // setValue ( "temp" , "30")
        // setValue ( "eq"   , "4")
        // execute("Collection.save")
        // assertNoErrors()

        // assertValueInCollection("detalle1" , 0 , 2, "3.050") 
        // assertValueInCollection("detalle1" , 1 , 2, "5.650") 

        // **************************************************
        // FINALIZAR
        //execute    ("CRUD.delete")
        assertNoErrors()
    }

}
