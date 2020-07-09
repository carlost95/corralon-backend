package model;

import exceptions.BancoIncompletoException;

public class Banco {

    private Integer id;
    private String nombre;
    private String abreviatura;
    private Boolean habilitado;

    public Banco(Integer id, String nombre, String abreviatura, Boolean habilitado) {
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

}
