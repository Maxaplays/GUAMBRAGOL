/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.guambragol.servicio;

import ec.com.guambragol.modelo.Edificio;
import ec.com.guambragol.modelo.Edificio_;
import ec.com.guambragol.modelo.Persona;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author carlosballadares
 */
@Stateless
public class EdificioFacade extends AbstractFacade<Edificio> implements EdificioFacadeLocal {

    @PersistenceContext(unitName = "guambrmaGolPU")
    private EntityManager em;
     @Resource
    private SessionContext contexto;

    @Inject
    private Edificio edificio;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdificioFacade() {
        super(Edificio.class);
    }

    @Override
    public List<Edificio> listarEdificios() {
        return em.createNamedQuery("Edificio.findAll").getResultList();
    }

    @Override
    public void registrarEdificio(Edificio edificio) {
        em.persist(edificio);
    }

    @Override
    public void modificarEdificio(Edificio edificio) {
        em.merge(edificio);
    }

    @Override
    public void eliminarEdificio(Edificio edificio) {
        em.remove(em.merge(edificio));
    }
    
}
