package interactorTest;

import exceptions.BancoIncompletoException;
import exceptions.BancoNoExisteException;
import interactor.ChangeStatusBancoUseCase;
import mockito.MockitoExtension;
import model.Banco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import repository.IChangeStatusRepository;

@ExtendWith(MockitoExtension.class)
public class ChangeStatusUnitTest {

    @Mock
    IChangeStatusRepository iChangeStatusRepository;

    @Test
    public void should_ChangeStatusToTrue_WhenStatusIsFalse() throws BancoIncompletoException, BancoNoExisteException {
        Banco banco = Banco.factoryBanco(1, "Banco Rioja", "BR", false);
        Banco bancoStatusChanged = Banco.factoryBanco(1, "Banco Rioja", "BR", true);

        Mockito.when(iChangeStatusRepository.findBancoById(banco.getId())).thenReturn(banco);
        Mockito.when(iChangeStatusRepository.save(banco)).thenReturn(bancoStatusChanged);

        ChangeStatusBancoUseCase changeStatusBancoUseCase = new ChangeStatusBancoUseCase(iChangeStatusRepository);
        Boolean result = changeStatusBancoUseCase.changeStatus(banco).getHabilitado();
        Assertions.assertTrue(result);
    }


    @Test
    public void should_ChangeStatusToFalse_WhenStatusIsTrue() throws BancoIncompletoException, BancoNoExisteException {
        Banco banco = Banco.factoryBanco(1, "Banco Rioja", "BR", true);
        Banco bancoStatusChanged = Banco.factoryBanco(1, "Banco Rioja", "BR", false);

        Mockito.when(iChangeStatusRepository.findBancoById(banco.getId())).thenReturn(banco);
        Mockito.when(iChangeStatusRepository.save(banco)).thenReturn(bancoStatusChanged);

        ChangeStatusBancoUseCase changeStatusBancoUseCase = new ChangeStatusBancoUseCase(iChangeStatusRepository);
        Boolean result = changeStatusBancoUseCase.changeStatus(banco).getHabilitado();

        Assertions.assertFalse(result);
    }

    @Test
    public void should_ThrowBancoNoExiste_WhenBancoNotExist() throws BancoIncompletoException {
        Banco banco = Banco.factoryBanco(1, "Banco Rioja", "BR", true);
        Mockito.when(iChangeStatusRepository.save(banco)).thenReturn(null);
        ChangeStatusBancoUseCase changeStatusBancoUseCase = new ChangeStatusBancoUseCase(iChangeStatusRepository);

        Assertions.assertThrows(BancoNoExisteException.class, () -> {
            changeStatusBancoUseCase.changeStatus(banco).getHabilitado();
        });
    }

}
