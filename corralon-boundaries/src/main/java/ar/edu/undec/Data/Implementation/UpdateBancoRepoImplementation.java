package ar.edu.undec.Data.Implementation;

import ar.edu.undec.Data.EntityMapper.BancoEntityMapper;
import ar.edu.undec.Data.ModelEntity.BancoEntity;
import ar.edu.undec.Data.Repository.UpdateBancoRepo;
import exceptions.BancoExisteException;
import exceptions.BancoNoExisteException;
import model.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IUpdateBancoRepo;

import java.util.NoSuchElementException;

@Service
public class UpdateBancoRepoImplementation implements IUpdateBancoRepo {

    @Autowired
    private UpdateBancoRepo updateBancoRepo;


    @Override
    public Banco findById(Integer id) {
        BancoEntity bancoFind = updateBancoRepo.findById(id).get();
        return new BancoEntityMapper().mapeoDataCore(bancoFind);
    }

    @Override
    public Banco update(Banco updated) {
        BancoEntity saved = new BancoEntityMapper().mapeoCoreData(updated);
        saved = updateBancoRepo.save(saved);
        return new BancoEntityMapper().mapeoDataCore(saved);
    }
}
