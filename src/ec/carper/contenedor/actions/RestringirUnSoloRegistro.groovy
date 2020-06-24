package ec.carper.contenedor.actions

import javax.persistence.Query;
import org.openxava.actions.*
import org.openxava.jpa.*
import static org.openxava.jpa.XPersistence.*;

class RestringirUnSoloRegistro extends ViewBaseAction implements IChainAction{

    private String nextAction = null // Para guardar la siguiente acción a ejecutar

    void execute() throws Exception{
        def modulo = getModelName()
        Query query = getManager().createQuery("select count(*) from ${modulo}")
        def numero = (Integer)query.getSingleResult()

        if ( numero >0 ){
            addMessage ("grabar_solo_un_registro")
            resetDescriptionsCache()
            getView().clear()
        }else 
            nextAction = "CRUD.new"
    }
    
    // Obligatorio por causa de 'IChainAction'
    String getNextAction() throws Exception {
        return nextAction // Si es nulo no se encadena con ninguna acción
    }
}


