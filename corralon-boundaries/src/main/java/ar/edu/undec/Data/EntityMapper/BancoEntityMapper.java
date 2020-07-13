package ar.edu.undec.Data.EntityMapper;

import ar.edu.undec.Data.ModelEntity.BancoEntity;
import exceptions.BancoIncompletoException;
import model.Banco;

public class BancoEntityMapper {

    public BancoEntity mapeoCoreData(Banco banco) {
        BancoEntity bancoEntity = new BancoEntity();
        bancoEntity.setId(banco.getId());
        bancoEntity.setNombre(banco.getNombre());
        bancoEntity.setAbreviatura(banco.getAbreviatura());
        bancoEntity.setHabilitado(banco.getHabilitado());
        bancoEntity.setCreatedAt(banco.getCreatedAt());
        bancoEntity.setUpdatedAt(banco.getUpdatedAt());
        return bancoEntity;
    }

    public Banco mapeoDataCore(BancoEntity bancoEntity) {
        try{
            if ( bancoEntity != null){
                Banco banco = Banco.factoryBanco(bancoEntity.getId(), bancoEntity.getNombre(), bancoEntity.getAbreviatura(), bancoEntity.getHabilitado());
                banco.setCreatedAt(bancoEntity.getCreatedAt());
                banco.setUpdatedAt(bancoEntity.getUpdatedAt());
                return banco;
            }
            return null;
        } catch (BancoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
