//Grupo Vocalia parte 1. Joan Granda, Juan Simbaña, Mateo Andrade, Alexis Labañino

package ec.com.guambragol.controlador;

import ec.com.guambragol.modelo.Jugador;
import ec.com.guambragol.servicio.JugadorFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import javax.inject.Named;



@Named("vocaliaBean")
@ViewScoped
public class vocaliaBean implements Serializable{
   
    @Inject
     
    private JugadorFacadeLocal jugadorFacade;
    private Jugador jugadorSeleccionado;
    List<Jugador> jugadores;
    List<Jugador> busqueda;
    private int inicio=0;

    public int getInicio() {
        return inicio;
    }
    
    
       
    
public JugadorFacadeLocal getJugadorFacadeLocal() {
        return jugadorFacade;
    }

    public void setJugadorFacade(JugadorFacadeLocal jugadorFacade) {
        this.jugadorFacade = jugadorFacade;
    }

    public Jugador getJugadorSeleccionado() {
        return jugadorSeleccionado;
    }

    public void setJugadorSeleccionado(Jugador jugadorSeleccionado) {
        this.jugadorSeleccionado = jugadorSeleccionado;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

   
 

    @PostConstruct
    public void init() {
        //Iniciamos las variables
        jugadores = jugadorFacade.dorsalxEquipo(1);
        jugadorSeleccionado=new Jugador();
      
    }
    
    public List<Jugador> dorsal(int dorsal) throws Exception{
        try{
        return jugadorFacade.findByDorsal(dorsal);
        
        }catch(Exception e){
            System.out.println(e.getMessage());
             return jugadorFacade.findByDorsal(0);
        }
       
        }

   
 
 
    //Cambios
   

   
 //Dorsales
   
  
}
