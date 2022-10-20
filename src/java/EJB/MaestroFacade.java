/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Maestro;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pablo
 */
@javax.ejb.Stateless
public class MaestroFacade extends AbstractFacade<Maestro> implements MaestroFacadeLocal {

    @PersistenceContext(unitName = "maestros51PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaestroFacade() {
        super(Maestro.class);
    }
    
}
