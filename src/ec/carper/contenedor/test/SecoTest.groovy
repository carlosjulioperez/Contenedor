package ec.carper.contenedor.test

import org.openxava.tests.*

class SecoTest extends ModuleTestBase {

    SecoTest(String testName) {
        super(testName, "Contenedor", "Seco")
    }

    void testCrear() throws Exception {
        login("admin", "admin")
        
        execute("CRUD.new")
        
        setValue("lugar" , "JUNIT")
        setValue("fecha" , Aux.instance.fechaActual )
        execute ("CRUD.save")
        printHtml()
        assertNoErrors()
    
        setConditionValues("JUNIT")
        setConditionComparators("contains_comparator")
        printHtml()
        execute("List.filter")
        execute("List.viewDetail", "row=0")
        execute    ("Seco.cargarItems")

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
