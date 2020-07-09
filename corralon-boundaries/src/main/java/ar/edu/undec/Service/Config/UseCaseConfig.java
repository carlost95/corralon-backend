package ar.edu.undec.Service.Config;

import interactor.CrearBancoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.ICrearBancoRepo;

@Configuration
public class UseCaseConfig {

    @Autowired
    private ICrearBancoRepo iCrearBancoRepo;

    @Bean
    public CrearBancoUseCase crearBancoUseCase(){
        return new CrearBancoUseCase(iCrearBancoRepo);
    }
}
