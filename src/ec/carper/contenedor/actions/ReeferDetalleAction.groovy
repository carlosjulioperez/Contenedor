package ec.carper.contenedor.actions

import ec.carper.contenedor.enums.*

import org.openxava.actions.*

class ReeferDetalleAction extends OnChangePropertyBaseAction{

    void execute() throws Exception{

        def codigo = (String)getView().getValue("codigo")
        def cumple = (OpcionSiNo)getView().getValue("cumple")
        if (codigo?.length()==1)
            getView().setValue("cumple", null)
    }
        
}
