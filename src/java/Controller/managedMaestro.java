package Controller;

import EJB.MaestroFacadeLocal;
import Entity.Maestro;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@ManagedBean
@SessionScoped
@Named("managedMaestro")
public class managedMaestro implements Serializable{
    
    @EJB
private MaestroFacadeLocal maestroFacade;
private List<Maestro> listaMaestro;
private Maestro maestro;

    public List<Maestro> getListaMaestro() {
        this.listaMaestro = this.maestroFacade.findAll();
        return listaMaestro;
    }

    public void setListaMaestro(List<Maestro> listaMaestro) {
        this.listaMaestro = listaMaestro;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }
    
@PostConstruct
public void init(){
    this.maestro = new Maestro();
  }
}