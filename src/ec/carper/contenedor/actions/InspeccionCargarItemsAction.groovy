package ec.carper.contenedor.actions

import ec.carper.contenedor.model.*

import org.openxava.actions.*
import org.openxava.jpa.*
import org.openxava.model.*

class InspeccionCargarItemsAction extends ViewBaseAction implements IHideActionAction{

    private boolean hideAction = false

    void execute() throws Exception{
        def id = getView().getValue("id")

        if (id == null){
            addError("items_no_cargados")
            return
        }
        MapFacade.setValues("Inspeccion",
            getView().getKeyValues(), getView().getValues()
        )

        Inspeccion inspeccion = XPersistence.getManager().find( Inspeccion.class, getView().getValue("id") )
        if (inspeccion.itemsCargados){
            addError("items_ya_cargados")
            return
        }
        inspeccion.cargarItems()
        getView().refresh()
        addMessage("items_cargados")
        hideAction = true
    }

    String getActionToHide(){
        return hideAction ? "Inspeccion.cargarItems": null
    }
}
