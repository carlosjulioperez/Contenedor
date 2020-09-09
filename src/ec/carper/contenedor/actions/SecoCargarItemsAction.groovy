package ec.carper.contenedor.actions

import ec.carper.contenedor.model.*

import org.openxava.actions.*
import org.openxava.jpa.*
import org.openxava.model.*

class SecoCargarItemsAction extends ViewBaseAction implements IHideActionAction{

    private boolean hideAction = false

    void execute() throws Exception{
        def id = getView().getValue("id")

        if (id == null){
            addError("items_no_cargados")
            return
        }
        MapFacade.setValues("Seco",
            getView().getKeyValues(), getView().getValues()
        )

        Seco seco = XPersistence.getManager().find( Seco.class, getView().getValue("id") )
        if (seco.itemsCargados){
            addError("items_ya_cargados")
            return
        }
        seco.cargarItems()
        getView().refresh()
        addMessage("items_cargados")
        hideAction = true
    }

    String getActionToHide(){
        return hideAction ? "Seco.cargarItems": null
    }
}
