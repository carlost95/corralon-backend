package ar.edu.undec.ServiceIntegrationTest;


import ar.edu.undec.Service.Controller.UpdateBancoController;
import ar.edu.undec.Service.ModelService.BancoDTO;
import exceptions.BancoNoExisteException;
import input.IUpdateBancoInput;
import model.Banco;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseServiceIT {

    @Mock
    IUpdateBancoInput iUpdateBancoInput;

    @Test
    public void crearResponse_TodoOk_Status200 () {

    }

}
