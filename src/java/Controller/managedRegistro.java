package Controller;

import EJB.RegistroFacadeLocal;
import Entity.Maestro;
import Entity.Materia;
import Entity.Registro;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean
@SessionScoped
@Named("managedRegistro")
public class managedRegistro implements Serializable{

    @EJB
private RegistroFacadeLocal registroFacade;
private List<Registro> listaRegistro;
private Registro registro;
private Materia materia;
private Maestro maestro;
private String msj;

    public List<Registro> getListaRegistro() {
        this.listaRegistro = this.registroFacade.findAll();
        this.listaRegistro = listaRegistro;
        System.out.println(listaRegistro);
        return listaRegistro;        
    }

    public void setListaRegistro(List<Registro> listaRegistro) {
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

@PostConstruct
public void init(){
    this.registro = new Registro();
    this.maestro = new Maestro();
    this.materia = new Materia();
  }

public void guardar(){
    try{
        this.registro.setMateria(materia);
        this.registro.setMaestro(maestro);
        this.registroFacade.create(this.registro);
        this.msj = "Registro creado correctamente";
        this.materia = new Materia();
        this.maestro = new Maestro();
        this.registro = new Registro();
    }catch (Exception e){
        e.printStackTrace();
        this.msj = "Error" + e.getMessage();        
    }
    FacesMessage mensaje = new FacesMessage(this.msj);
    FacesContext.getCurrentInstance().addMessage(msj, mensaje);
}

public void actualizar(){
    try{
        this.registro.setMateria(materia);
        this.registro.setMaestro(maestro);
        this.registroFacade.edit(registro);
        this.msj = "Registro actualizado correctamente";
        this.materia = new Materia();
        this.maestro = new Maestro();
        this.registro = new Registro();
    }catch (Exception e){
        e.printStackTrace();
        this.msj = "Error" + e.getMessage();        
    }
    FacesMessage mensaje = new FacesMessage(this.msj);
    FacesContext.getCurrentInstance().addMessage(msj, mensaje);
}

public void eliminar(Registro eli){
    try{
        this.registroFacade.remove(eli);
        this.msj = "Registro eliminado correctamente";
    }catch (Exception e){
        e.printStackTrace();
        this.msj = "Error" + e.getMessage();        
    }
    FacesMessage mensaje = new FacesMessage(this.msj);
    FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

public void cargarDatos(Registro re){
     this.materia.setId_materia(re.getMateria().getId_materia());
     this.maestro.setId_maestro(re.getMaestro().getId_maestro());
     this.registro = re;
}

public void limpiar(){
    this.maestro = new Maestro();
    this.materia = new Materia();
    this.registro = new Registro();
}

}

