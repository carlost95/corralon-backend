package ar.edu.undec.Data.Repository;

import ar.edu.undec.Data.ModelEntity.BancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateBancoRepo extends JpaRepository<BancoEntity, Integer> {

    BancoEntity findBancoEntitiesByNombreEquals(String name);
}
