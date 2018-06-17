/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlacesTEC.capalogica.Estructuras;

/**
 *
 * @author Kenneth
 */
public class Favoritos {
    private String imagen;
    private String id;
    private String tel;
    private String ratin;
    private String horario;
    private String web;
    private String nombre;

    public Favoritos(String imagen, String id, String ratin, String nombre) {
        this.imagen = imagen;
        this.id = id;
        this.ratin = ratin;
        this.nombre = nombre;
    }

    public Favoritos(String imagen, String id, String tel, String ratin, String nombre) {
        this.imagen = imagen;
        this.id = id;
        this.tel = tel;
        this.ratin = ratin;
        this.nombre = nombre;
    }

    public Favoritos(String imagen, String id, String tel, String ratin, String horario, String nombre) {
        this.imagen = imagen;
        this.id = id;
        this.tel = tel;
        this.ratin = ratin;
        this.horario = horario;
        this.nombre = nombre;
    }

    public Favoritos(String imagen, String id, String tel, String ratin, String horario, String web, String nombre) {
        this.imagen = imagen;
        this.id = id;
        this.tel = tel;
        this.ratin = ratin;
        this.horario = horario;
        this.web = web;
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRatin() {
        return ratin;
    }

    public void setRatin(String ratin) {
        this.ratin = ratin;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
