package ec.carper.contenedor.actions

import org.openxava.actions.*

class ContenedorSaveAction extends ViewBaseAction implements IChainAction, IChangeModeAction {

    void execute() throws Exception {
    }

    String getNextAction() throws Exception {
        return "CRUD.save"
    }
    
    String getNextMode() {           
        return IChangeModeAction.LIST
    }

}

