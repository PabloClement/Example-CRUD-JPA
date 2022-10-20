package Controller;

import EJB.MateriaFacadeLocal;
import Entity.Materia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@ManagedBean
@SessionScoped
@Named("managedMateria")
public class managedMateria implements Serializable{

    @EJB
private MateriaFacadeLocal materiaFacade;
private List<Materia> listaMateria;
private Materia materia;

    public List<Materia> getListaMateria() {
        this.listaMateria = this.materiaFacade.findAll();
        return listaMateria;
    }

    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

@PostConstruct
public void init(){
    this.materia = new Materia();
  }       
    
}

