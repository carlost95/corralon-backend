package ar.edu.undec.Data.Implementation;

import ar.edu.undec.Data.EntityMapper.BancoEntityMapper;
import ar.edu.undec.Data.ModelEntity.BancoEntity;
import ar.edu.undec.Data.Repository.FindBancoByIdCRUD;
import ar.edu.undec.Service.ModelService.BancoDTO;
import model.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IFindBancoByIdRepo;

@Service
public class FindBancoByIdRepoImplementation implements IFindBancoByIdRepo {

    @Autowired
    FindBancoByIdCRUD findBancoByIdCRUD;

    @Override
    public Banco findById(Integer id) {
        BancoEntity bancoEntity = this.findBancoByIdCRUD.findById(id).get();
        return new BancoEntityMapper().mapeoDataCore(bancoEntity);
    }
}
