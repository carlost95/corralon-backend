package ar.edu.undec.Service.Config;

import input.IFindByIdBancoInput;
import input.IUpdateBancoInput;
import interactor.ChangeStatusBancoUseCase;
import interactor.CrearBancoUseCase;
import interactor.FindBancoByIdUseCase;
import interactor.UpdateBancoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.IChangeStatusRepository;
import repository.ICrearBancoRepo;
import repository.IFindBancoByIdRepo;
import repository.IUpdateBancoRepo;

@Configuration
public class UseCaseConfig {

    @Autowired
    private ICrearBancoRepo iCrearBancoRepo;

    @Autowired
    private IUpdateBancoRepo iUpdateBancoRepo;

    @Autowired
    private IFindBancoByIdRepo iFindBancoByIdRepo;

    @Autowired
    private IChangeStatusRepository iChangeStatusRepository;

    @Bean
    public CrearBancoUseCase crearBancoUseCase(){
        return new CrearBancoUseCase(iCrearBancoRepo);
    }

    @Bean
    public UpdateBancoUseCase updateBancoUseCase() {
        return new UpdateBancoUseCase(iUpdateBancoRepo);
    }

    @Bean
    public FindBancoByIdUseCase findBancoByIdUseCase() {
        return new FindBancoByIdUseCase(this.iFindBancoByIdRepo);
    }

    @Bean
    public ChangeStatusBancoUseCase changeStatusBancoUseCase(){
        return new ChangeStatusBancoUseCase(this.iChangeStatusRepository);
    }
}
