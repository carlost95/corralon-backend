package ar.edu.undec.Data.Repository;

import ar.edu.undec.Data.ModelEntity.BancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrearBancoCRUD extends JpaRepository<BancoEntity, Integer> {
}
