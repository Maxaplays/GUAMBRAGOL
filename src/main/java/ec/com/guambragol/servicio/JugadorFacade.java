/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.guambragol.servicio;

import ec.com.guambragol.modelo.Club;
import ec.com.guambragol.modelo.Jugador;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author carlosballadares
 */
@Named("JugadorService")
@Stateless
public class JugadorFacade extends AbstractFacade<Jugador> implements JugadorFacadeLocal {

    @PersistenceContext(unitName = "guambrmaGolPU")
    private EntityManager em;
    private Jugador entity;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JugadorFacade() {
        super(Jugador.class);
    }
    

    @Override
    public int count() {
        return super.count(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jugador> findRange(int[] range) {
        return super.findRange(range); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jugador> findAll() {
        return em.createNamedQuery("Jugador.findAll").getResultList();
    }

    @Override
    public Jugador find(Object id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Jugador entity) {
        em.remove(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Jugador entity) {
        em.merge(entity);
    }

    @Override
    public void create(Jugador entity) {
        em.persist(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }


   

 @Override
    public List<Jugador> dorsalxEquipo(int id){
                                                                 
         return em.createQuery("SELECT J FROM Jugador j WHERE J.idClub.idClub = "+id, Jugador.class).getResultList();
       
    }
        
    
    public void editListener(RowEditEvent event) {
        Jugador jugador = (Jugador) event.getObject();
        this.edit(jugador);
    }

    @Override
    public List<Jugador> findByDorsal(int dorsal) throws Exception{
        try{
        return em.createQuery("SELECT J FROM Jugador j WHERE J.dorsal = "+dorsal, Jugador.class).getResultList();
        }catch(Exception e){
            
            System.out.println(e.getMessage());
            
        }
        return null;
        }
}
