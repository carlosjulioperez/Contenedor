package ec.carper.contenedor.test

import org.openxava.tests.*

class InspeccionTest extends ModuleTestBase {

    InspeccionTest(String testName) {
        super(testName, "Contenedor", "Inspeccion")
    }

    void testCrear() throws Exception {
        login("admin", "admin")
        
        execute("CRUD.new")
        setValue("lugar" , "JUNIT")
        setValue("contenedorTipo" , "1") //Seco / Refrigerado
        // setValue("fecha" , Aux.instance.fechaActual )
        // setValue("fecha" , "10/09/2020" )
        execute ("Contenedor.save")
        assertNoErrors()

        // setConditionComparators ( new String[] { "=", "contains_comparator" } )
        // setConditionValues      ( new String[] { "", "JUNIT" } )
        setConditionComparators ( [ "", "", "", "=", "contains_comparator" ] )
        setConditionValues      ( [ "", "", "", "", "JUNIT" ] )
        execute ("List.filter")
        execute ("List.viewDetail", "row=0")
        execute ("Inspeccion.cargarItems")
        //printHtml()
        assertNoErrors()
        
        setValue("contenedor.id" , "1")
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
        
        execute ('Sections.change', 'activeSection=2')

        assertCollectionRowCount("detalle1", 0)
     
        setValueInCollection("detalle1" , 0 , "lado"         , "0") //izquierdo
        setValueInCollection("detalle1" , 0 , "palletNo"     , "1")
        setValueInCollection("detalle1" , 0 , "producto"     , "PRODUCTO 1")
        setValueInCollection("detalle1" , 0 , "palletCodigo" , "PALLET 1")
        setValueInCollection("detalle1" , 0 , "loteCalibre"  , "LOTE 1")
        setValueInCollection("detalle1" , 0 , "variedad"     , "VARIEDAD 1")
        setValueInCollection("detalle1" , 0 , "temperatura"  , "10")
        setValueInCollection("detalle1" , 0 , "cajasNo"      , "10")
     
        setValueInCollection("detalle1" , 1 , "lado"         , "0") //izquierdo
        setValueInCollection("detalle1" , 1 , "palletNo"     , "3")
        setValueInCollection("detalle1" , 1 , "producto"     , "PRODUCTO 3")
        setValueInCollection("detalle1" , 1 , "palletCodigo" , "PALLET 3")
        setValueInCollection("detalle1" , 1 , "loteCalibre"  , "LOTE 3")
        setValueInCollection("detalle1" , 1 , "variedad"     , "VARIEDAD 3")
        setValueInCollection("detalle1" , 1 , "temperatura"  , "30")
        setValueInCollection("detalle1" , 1 , "cajasNo"      , "30")
     
        setValueInCollection("detalle1" , 2 , "lado"         , "1") //derecho
        setValueInCollection("detalle1" , 2 , "palletNo"     , "2")
        setValueInCollection("detalle1" , 2 , "producto"     , "PRODUCTO 2")
        setValueInCollection("detalle1" , 2 , "palletCodigo" , "PALLET 2")
        setValueInCollection("detalle1" , 2 , "loteCalibre"  , "LOTE 2")
        setValueInCollection("detalle1" , 2 , "variedad"     , "VARIEDAD 2")
        setValueInCollection("detalle1" , 2 , "temperatura"  , "20")
        setValueInCollection("detalle1" , 2 , "cajasNo"      , "20")
     
        setValueInCollection("detalle1" , 3 , "lado"         , "1") //derecho
        setValueInCollection("detalle1" , 3 , "palletNo"     , "4")
        setValueInCollection("detalle1" , 3 , "producto"     , "PRODUCTO 4")
        setValueInCollection("detalle1" , 3 , "palletCodigo" , "PALLET 4")
        setValueInCollection("detalle1" , 3 , "loteCalibre"  , "LOTE 4")
        setValueInCollection("detalle1" , 3 , "variedad"     , "VARIEDAD 4")
        setValueInCollection("detalle1" , 3 , "temperatura"  , "40")
        setValueInCollection("detalle1" , 3 , "cajasNo"      , "40")
        
        assertCollectionRowCount("detalle1", 4)
        
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
