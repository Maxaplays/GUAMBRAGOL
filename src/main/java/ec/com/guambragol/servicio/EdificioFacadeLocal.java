package ec.com.guambragol.servicio;

import ec.com.guambragol.modelo.Edificio;
import ec.com.guambragol.modelo.Persona;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EdificioFacadeLocal {

    public List<Edificio> listarEdificios();

   

    public void registrarEdificio(Edificio edificio);

    public void modificarEdificio(Edificio edificio);

    public void eliminarEdificio(Edificio edificio);
}