package ar.edu.undec.Data.Implementation;

import ar.edu.undec.Data.EntityMapper.BancoEntityMapper;
import ar.edu.undec.Data.ModelEntity.BancoEntity;
import ar.edu.undec.Data.Repository.FindBancoByIdCRUD;
import ar.edu.undec.Service.ModelService.BancoDTO;
import exceptions.BancoIncompletoException;
import model.Banco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IFindBancoByIdRepo;

@Service
public class FindBancoByIdRepoImplementation implements IFindBancoByIdRepo {

    static final Logger LOG = LoggerFactory.getLogger(BancoEntityMapper.class);

    @Autowired
    FindBancoByIdCRUD findBancoByIdCRUD;

    @Override
    public Banco findById(Integer id) {

        try{
            BancoEntity bancoEntity = this.findBancoByIdCRUD.findById(id).get();
            return new BancoEntityMapper().mapeoDataCore(bancoEntity);
        } catch (Exception e) {
            LOG.error("FindBancoByIdRepoImplementation - Error database" +  e.getMessage());
            return null;
        }
    }
}
