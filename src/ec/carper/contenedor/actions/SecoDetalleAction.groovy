package ec.carper.contenedor.actions

import org.openxava.actions.*

class SecoDetalleAction extends OnChangePropertyBaseAction{

    void execute() throws Exception{
        def codigo = (String)getView().getValue("codigo")
        if (codigo.length()==1){
            addMessage ("accion_restringida")
            resetDescriptionsCache()
            getView().clear()
        }
    }
}

