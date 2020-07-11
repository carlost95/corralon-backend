package interactorTest;

import exceptions.BancoIncompletoException;
import exceptions.BancoNoExisteException;
import interactor.FindBancoByIdUseCase;
import mockito.MockitoExtension;
import model.Banco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import repository.IFindBancoByIdRepo;

@ExtendWith(MockitoExtension.class)
public class FindBancoByIdUnitTest {

    @Mock
    IFindBancoByIdRepo findBancoByIdRepo;

    @Test
    public void findBancoById_BancoExiste_DevuelveBanco() throws BancoIncompletoException, BancoNoExisteException {
        Banco banco = Banco.factoryBanco(1, "Banco Rioja", "BR", true);
        Mockito.when(findBancoByIdRepo.findById(1)).thenReturn(banco);
        FindBancoByIdUseCase findBancoByIdUseCase = new FindBancoByIdUseCase(findBancoByIdRepo);
        Banco searched = findBancoByIdUseCase.findById(banco.getId());
        Assertions.assertNotNull(searched);
    }

    @Test
    public void findBancoById_BancoNoExiste_ErrorAlBuscarBanco() throws BancoIncompletoException {
        Banco banco = Banco.factoryBanco(1, "Banco Rioja", "BR", true);
        Mockito.when(findBancoByIdRepo.findById(1)).thenReturn(null);
        FindBancoByIdUseCase findBancoByIdUseCase = new FindBancoByIdUseCase(findBancoByIdRepo);
        Assertions.assertThrows(BancoNoExisteException.class, ()-> findBancoByIdUseCase.findById(banco.getId()));
    }

}
