package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.UpdateBancoController;
import ar.edu.undec.Service.ModelService.BancoDTO;
import exceptions.BancoExisteException;
import exceptions.BancoIncompletoException;
import exceptions.BancoNoExisteException;
import input.IUpdateBancoInput;
import model.Banco;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateBancoServiceIT {

    @Mock
    IUpdateBancoInput iUpdateBancoInput;

    @Test
    public void modificarBanco_BancoExiste_Devuelve200() throws BancoNoExisteException, BancoExisteException, BancoIncompletoException {
        BancoDTO bancoDTO = new BancoDTO(1, "Banco Rioja", "BR", true);
        Banco updated = new Banco(1, "Banco Rioja", "BR", true);
        updated.setCreatedAt(LocalDateTime.now());
        updated.setUpdatedAt(LocalDateTime.now());

        when(iUpdateBancoInput.update(any(Banco.class))).thenReturn(updated);

        UpdateBancoController updateBancoController = new UpdateBancoController(iUpdateBancoInput);
        assertEquals(200, updateBancoController.update(bancoDTO).getBody().getStatus() );

    }
}
