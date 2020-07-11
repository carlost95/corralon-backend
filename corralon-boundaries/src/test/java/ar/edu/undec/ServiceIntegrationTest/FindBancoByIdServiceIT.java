package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.FindBancoByIdController;
import ar.edu.undec.Service.ModelService.BancoDTO;
import exceptions.BancoNoExisteException;
import input.IFindByIdBancoInput;
import model.Banco;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FindBancoByIdServiceIT {

    @Mock
    IFindByIdBancoInput iFindByIdBancoInput;

    @Test
    public void findBanco_BancoExiste_Devuelve200() throws BancoNoExisteException {
        BancoDTO banco = new BancoDTO(1, "Banco Rioja", "BR", true);
        Banco finded = new Banco(1, "Banco Rioja", "BR", true);

        when(iFindByIdBancoInput.findById(any(Integer.class))).thenReturn(finded);
        FindBancoByIdController findBancoByIdController = new FindBancoByIdController(iFindByIdBancoInput);
        assertEquals(findBancoByIdController.findBancoById(banco.getId()).getStatus(), 200 );

    }

    @Test
    public void findBanco_BancoNoExiste_Devuelve412() throws BancoNoExisteException {
        Banco finded = new Banco(1, "Banco Rioja", "BR", true);
        when(iFindByIdBancoInput.findById(any(Integer.class))).thenThrow(new BancoNoExisteException("El Banco no existe"));
        FindBancoByIdController findBancoByIdController = new FindBancoByIdController(iFindByIdBancoInput);
        assertEquals(findBancoByIdController.findBancoById(finded.getId()).getStatus(), 412 );
    }

}
