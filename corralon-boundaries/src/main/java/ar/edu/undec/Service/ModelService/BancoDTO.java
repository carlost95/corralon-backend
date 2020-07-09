package ar.edu.undec.Service.ModelService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BancoDTO {

    private Integer id;
    private String nombre;
    private String abreviatura;
    private Boolean habilitado;

    public BancoDTO() {
    }

    public BancoDTO(Integer id, String nombre, String abreviatura, boolean habilitado) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.habilitado = habilitado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
}
