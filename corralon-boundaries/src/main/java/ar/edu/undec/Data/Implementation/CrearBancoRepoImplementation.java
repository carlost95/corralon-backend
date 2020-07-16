package ar.edu.undec.Data.Implementation;

import ar.edu.undec.Data.EntityMapper.BancoEntityMapper;
import ar.edu.undec.Data.ModelEntity.BancoEntity;
import ar.edu.undec.Data.Repository.IBuscarBancoPorNombreCRUD;
import ar.edu.undec.Data.Repository.ICrearBancoCRUD;
import model.Banco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICrearBancoRepo;

@Service
public class CrearBancoRepoImplementation implements ICrearBancoRepo {

    @Autowired
    ICrearBancoCRUD iCrearBancoData;
    @Autowired
    IBuscarBancoPorNombreCRUD iBuscarBancoPorNombreCRUD;

    static final Logger LOG = LoggerFactory.getLogger(BancoEntityMapper.class);

    @Override
    public Banco save(Banco banco) {
        BancoEntity bancoEntity = new BancoEntityMapper().mapeoCoreData(banco);
        try {
            bancoEntity = iCrearBancoData.save(bancoEntity);
            return new BancoEntityMapper().mapeoDataCore(bancoEntity);
        }catch (Exception e) {
            LOG.error("CrearBancoRepoImplementation - Error to save" );
        }
        return null;
    }

    @Override
    public Banco findByNombre(String nombreBanco) {
        BancoEntity bancoEntity = iBuscarBancoPorNombreCRUD.findByNombre(nombreBanco);
        Banco banco = null;
        try {
            banco = new BancoEntityMapper().mapeoDataCore(bancoEntity);
        } catch (Exception e) {
            LOG.error("CrearBancoRepoImplementation - Error to find" );
        }
        return banco;
    }
}
