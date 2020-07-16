package ar.edu.undec.Data.Implementation;

import ar.edu.undec.Data.EntityMapper.BancoEntityMapper;
import ar.edu.undec.Data.ModelEntity.BancoEntity;
import ar.edu.undec.Data.Repository.UpdateBancoRepo;
import exceptions.BancoIncompletoException;
import model.Banco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IUpdateBancoRepo;

@Service
public class UpdateBancoRepoImplementation implements IUpdateBancoRepo {

    static final Logger LOG = LoggerFactory.getLogger(BancoEntityMapper.class);
    @Autowired
    private UpdateBancoRepo updateBancoRepo;


    @Override
    public Banco findById(Integer id) {
        try {
            BancoEntity bancoFind = updateBancoRepo.findById(id).get();
            return new BancoEntityMapper().mapeoDataCore(bancoFind);
        } catch (Exception e) {
            LOG.error("UpdateBancoReporImplementation: Error to find database" + e.getMessage());
        }
        return null;
    }

    @Override
    public Banco update(Banco updated) {
        BancoEntity saved = new BancoEntityMapper().mapeoCoreData(updated);
        saved = updateBancoRepo.save(saved);
        try {
            return new BancoEntityMapper().mapeoDataCore(saved);
        } catch (Exception e) {
            LOG.error("UpdateBancoReporImplementation: Error to update database" + e.getMessage());
        }
        return null;
    }
}
