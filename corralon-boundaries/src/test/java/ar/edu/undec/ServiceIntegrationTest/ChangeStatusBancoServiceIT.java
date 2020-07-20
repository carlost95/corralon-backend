package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.ChangeStatusController;
import ar.edu.undec.Service.Controller.UpdateBancoController;
import ar.edu.undec.Service.ModelService.BancoDTO;
import exceptions.BancoExisteException;
import exceptions.BancoIncompletoException;
import exceptions.BancoNoExisteException;
import input.IChangeStatusInput;
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
public class ChangeStatusBancoServiceIT {

    @Mock
    IChangeStatusInput iChangeStatusInput;

    @Test
    public void should_ReturnStatusCode200_WhenChangeStatus() throws BancoNoExisteException, BancoExisteException, BancoIncompletoException {
        BancoDTO bancoDTO = new BancoDTO(1, "Banco Rioja", "BR", true);
        Banco updated = new Banco(1, "Banco Rioja", "BR", false);
        updated.setCreatedAt(LocalDateTime.now());
        updated.setUpdatedAt(LocalDateTime.now());

        when(iChangeStatusInput.changeStatus(any(Banco.class))).thenReturn(updated);

        ChangeStatusController changeStatusController = new ChangeStatusController(iChangeStatusInput);
        assertEquals(200, changeStatusController.changeStatus(bancoDTO).getBody().getStatus() );

    }
}