package ec.carper.contenedor.actions

import ec.carper.contenedor.model.*

import org.openxava.actions.*
import org.openxava.jpa.*
import org.openxava.model.*

class ReeferCargarItemsAction extends ViewBaseAction implements IHideActionAction{

    private boolean hideAction = false

    void execute() throws Exception{
        def id = getView().getValue("id")

        if (id == null){
            addError("items_no_cargados")
            return
        }
        MapFacade.setValues("Reefer",
            getView().getKeyValues(), getView().getValues()
        )

        Reefer reefer = XPersistence.getManager().find( Reefer.class, getView().getValue("id") )
        if (reefer.itemsCargados){
            addError("items_ya_cargados")
            return
        }
        reefer.cargarItems()
        getView().refresh()
        addMessage("items_cargados")
        hideAction = true
    }

    String getActionToHide(){
        return hideAction ? "Reefer.cargarItems": null
    }
}
