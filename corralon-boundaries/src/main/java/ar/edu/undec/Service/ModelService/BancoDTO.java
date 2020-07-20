package ar.edu.undec.Service.ModelService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BancoDTO {

    private Integer id;
    private String nombre;
    private String abreviatura;
    private Boolean habilitado;
    private String created_at;
    private String updated_at;

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

    public Boolean getHabilitado() {
        return habilitado;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
