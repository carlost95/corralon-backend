package ar.edu.undec.Data.EntityMapper;

import ar.edu.undec.Data.ModelEntity.BancoEntity;
import model.Banco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BancoEntityMapper {

    static final Logger LOG = LoggerFactory.getLogger(BancoEntityMapper.class);

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
        Banco banco = null;
        try {
            if (bancoEntity != null){
                banco = Banco.factoryBanco(bancoEntity.getId(), bancoEntity.getNombre(), bancoEntity.getAbreviatura(), bancoEntity.getHabilitado());
                banco.setCreatedAt(bancoEntity.getCreatedAt());
                banco.setUpdatedAt(bancoEntity.getUpdatedAt());
            }
        } catch (Exception e) {
            LOG.error("mapeoDataCore: " + e.getMessage());
        }
        return banco;
    }
}
