/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Registro;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@javax.ejb.Stateless
public class RegistroFacade extends AbstractFacade<Registro> implements RegistroFacadeLocal {

    @PersistenceContext(unitName = "maestros51PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroFacade() {
        super(Registro.class);
    }
    
}
