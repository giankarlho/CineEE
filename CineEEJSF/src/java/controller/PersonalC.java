package controller;

import dao.PersonalImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Personal;

@Named(value = "personalC")
@SessionScoped
public class PersonalC implements Serializable {

    private Personal personal;
    private PersonalImpl dao;
    private List<Personal> listadoPer;

    public PersonalC() {
        dao = new PersonalImpl();
        personal = new Personal();
        listadoPer = new ArrayList();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(personal);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro","Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(personal);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización","Completado..."));
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Personal per) throws Exception {
        try {
            dao.eliminar(per);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminación","Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        try {
            listadoPer = dao.listarPer();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() throws Exception {
        try {
            personal = new Personal();
        } catch (Exception e) {
            throw e;
        }
    }
    
     public List<String> completeTextUbigeo(String query) throws Exception {
        PersonalImpl dist = new PersonalImpl();
        return dist.autocompleteUbigeo(query);
    }

    // Código generado
    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public List<Personal> getListadoPer() {
        return listadoPer;
    }

    public void setListadoPer(List<Personal> listadoPer) {
        this.listadoPer = listadoPer;
    }

}
