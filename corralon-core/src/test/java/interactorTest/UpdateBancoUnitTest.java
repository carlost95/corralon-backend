package interactorTest;

import exceptions.BancoExisteException;
import exceptions.BancoIncompletoException;
import exceptions.BancoNoExisteException;
import interactor.UpdateBancoUseCase;
import repository.IUpdateBancoRepo;
import mockito.MockitoExtension;
import model.Banco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateBancoUnitTest {

    @Mock
    IUpdateBancoRepo iUpdateBancoRepo;


    @Test
    public void modificarBanco_BancoExiste_GuardaCorrectamente() throws BancoIncompletoException, BancoNoExisteException {
        Banco banco = Banco.factoryBanco(1, "Banco Rioja", "BR", true);
        Banco updated = Banco.factoryBanco(1, "Banco Patagonia", "BP", true);
        when(iUpdateBancoRepo.findById(1)).thenReturn(banco);
        when(iUpdateBancoRepo.update(any(Banco.class))).thenReturn(updated);

        UpdateBancoUseCase updateBancoUseCase = new UpdateBancoUseCase(iUpdateBancoRepo);

        Banco result = updateBancoUseCase.update(updated);
        Assertions.assertNotNull(result);
    }

    @Test
    public void modificarBanco_ProblemaBancoExiste_BancoExisteException() throws BancoIncompletoException {

        Banco bancoDatosNuevos = Banco.factoryBanco(1, "Banco Patagonia", "BP", true);

        when(iUpdateBancoRepo.findById(1)).thenReturn(null);

        UpdateBancoUseCase updateBancoUseCase = new UpdateBancoUseCase(iUpdateBancoRepo);
        Assertions.assertThrows(BancoNoExisteException.class, ()-> updateBancoUseCase.update(bancoDatosNuevos));
    }

}