package ar.edu.undec.Data.Repository;

import ar.edu.undec.Data.ModelEntity.BancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateBancoRepo extends JpaRepository<BancoEntity, Integer> {
}
