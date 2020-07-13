package model;

import exceptions.BancoIncompletoException;

public class Banco extends AuditDate {

    private Integer id;
    private String nombre;
    private String abreviatura;
    private Boolean habilitado;

    public Banco(Integer id, String nombre, String abreviatura, Boolean habilitado) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.habilitado = habilitado;
    }

    public static Banco factoryBanco(Integer id, String nombre, String abreviatura, Boolean habilitado) throws BancoIncompletoException {

        if (abreviatura == null  || nombre == null){
            throw new BancoIncompletoException();
        }

        if (nombre.length() == 0 || abreviatura.length() == 0 ){
            throw new BancoIncompletoException();
        }
        return new Banco(id, nombre ,abreviatura, habilitado);
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

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
}
