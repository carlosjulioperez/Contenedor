package ec.carper.contenedor.actions

import ec.carper.contenedor.enums.*

import org.openxava.actions.*

class InspeccionDetalleAction extends OnChangePropertyBaseAction{

    void execute() throws Exception{

        def codigo = (String)getView().getValue("codigo")
        def cumple = (OpcionSiNoNa)getView().getValue("cumple")
        if (codigo?.length()==1)
            getView().setValue("cumple", null)
    }
        
}
