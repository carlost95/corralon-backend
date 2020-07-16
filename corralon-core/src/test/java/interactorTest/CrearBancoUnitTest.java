package interactorTest;

import exceptions.BancoExisteException;
import exceptions.BancoIncompletoException;
import interactor.CrearBancoUseCase;
import repository.ICrearBancoRepo;
import mockito.MockitoExtension;
import model.Banco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class CrearBancoUnitTest {

    @Mock
    ICrearBancoRepo crearBancoRepo;

    @Test
    public void crearBanco_BancoNoExiste_GuardaCorrectamente() throws BancoIncompletoException, BancoExisteException {
        Banco banco = Banco.factoryBanco(null, "Banco Rioja", "BR", true);
        Mockito.when(crearBancoRepo.save(banco)).thenReturn(banco);
        CrearBancoUseCase crearBancoUseCase = new CrearBancoUseCase(crearBancoRepo);
        Assertions.assertNotNull(crearBancoUseCase.crearBanco(banco));
    }


    @Test
    public void crearBancoHabilitacionNula_HabilitacionNull_GuardaCorrectamente() throws BancoIncompletoException, BancoExisteException {
        Banco banco = Banco.factoryBanco(null, "Banco Rioja", "BR", null);
        Mockito.when(crearBancoRepo.save(banco)).thenReturn(banco);
        CrearBancoUseCase crearBancoUseCase = new CrearBancoUseCase(crearBancoRepo);
        Assertions.assertNotNull(crearBancoUseCase.crearBanco(banco));
    }

    @Test
    public void crearBanco_BancoExiste_BancoExisteException() throws BancoIncompletoException {
        Banco bancoNuevo = Banco.factoryBanco(1, "Banco Rioja", "BR", true);
        Banco repetido = Banco.factoryBanco(2, "Banco Rioja", "BR", true);

        Mockito.when(crearBancoRepo.findByNombre("Banco Rioja")).thenReturn(repetido);
        CrearBancoUseCase crearBancoUseCase = new CrearBancoUseCase(crearBancoRepo);

        Assertions.assertThrows(BancoExisteException.class, () ->{
            crearBancoUseCase.crearBanco(bancoNuevo);
        });

    }

}
