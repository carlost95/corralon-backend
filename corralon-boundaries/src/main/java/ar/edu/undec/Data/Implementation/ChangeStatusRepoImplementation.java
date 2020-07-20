package ar.edu.undec.Data.Implementation;

import ar.edu.undec.Data.EntityMapper.BancoEntityMapper;
import ar.edu.undec.Data.ModelEntity.BancoEntity;
import ar.edu.undec.Data.Repository.ChangeStatusCRUD;
import model.Banco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IChangeStatusRepository;

@Service
public class ChangeStatusRepoImplementation implements IChangeStatusRepository {

    static final Logger LOG = LoggerFactory.getLogger(ChangeStatusRepoImplementation.class);

    @Autowired
    ChangeStatusCRUD changeStatusCRUD;

    @Override
    public Banco save(Banco banco) {
        BancoEntity saved = new BancoEntityMapper().mapeoCoreData(banco);
        saved = this.changeStatusCRUD.save(saved);
        try {
            return new BancoEntityMapper().mapeoDataCore(saved);
        } catch (Exception e) {
            LOG.error("ChangeStatusRepoImplementation: Error to update database" + e.getMessage());
        }
        return null;
    }

    @Override
    public Banco findBancoById(Integer id) {
        try {
            BancoEntity bancoFind = this.changeStatusCRUD.findById(id).get();
            return new BancoEntityMapper().mapeoDataCore(bancoFind);
        } catch (Exception e) {
            LOG.error("ChangeStatusRepoImplementation: Error to find database" + e.getMessage());
        }
        return null;
    }
}
