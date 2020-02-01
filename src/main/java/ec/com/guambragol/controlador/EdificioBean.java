package ec.com.guambragol.controlador;

import ec.com.guambragol.modelo.Edificio;
import ec.com.guambragol.servicio.EdificioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;


import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;

@Named("edificioBean")
@RequestScoped
public class EdificioBean {

    @Inject
    private EdificioFacadeLocal edificioFacade;

    private Edificio edificioSeleccionada;

    List<Edificio> edificios;

    public EdificioBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
       edificios = edificioFacade.listarEdificios();
        edificioSeleccionada = new Edificio();
    }

    public void editListener(RowEditEvent event) {
        Edificio edificio = (Edificio) event.getObject();
        edificioFacade.modificarEdificio(edificio);
    }

    public EdificioFacadeLocal getEdificioFacade() {
        return edificioFacade;
    }

    public void setEdificioFacade(EdificioFacadeLocal edificioFacade) {
        this.edificioFacade = edificioFacade;
    }

    public Edificio getEdificioSeleccionada() {
        return edificioSeleccionada;
    }

    public void setEdificioSeleccionada(Edificio edificioSeleccionada) {
        this.edificioSeleccionada = edificioSeleccionada;
    }

    public List<Edificio> getEdificios() {
        return edificios;
    }

    public void setEdificios(List<Edificio> edificios) {
        this.edificios = edificios;
    }

   

    public void reiniciarEdificioSeleccionada() {
        this.edificioSeleccionada = new Edificio();
    }

    public void agregarEdificio() {
        edificioFacade.registrarEdificio(this.edificioSeleccionada);
        this.edificioSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminarPersona() {
        edificioFacade.eliminarEdificio(this.edificioSeleccionada);
        this.edificioSeleccionada = null;
        //actualizamos la lista
        this.inicializar();
    }

}
