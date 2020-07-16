package ar.edu.undec.ServiceIntegrationTest;


import ar.edu.undec.Service.Exceptions.RestExceptionHandler;
import exceptions.BancoExisteException;
import exceptions.BancoIncompletoException;
import input.ICrearBancoInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HandleExceptionServiceIT {

    @Mock
    ICrearBancoInput iCrearBancoInput;

    @Test
    public void crearResponse_TodoOk_Status200 () throws BancoIncompletoException, BancoExisteException {

        RestExceptionHandler restExceptionHandle= new RestExceptionHandler();
        assertEquals(restExceptionHandle.handleBancoExisteException(new BancoExisteException("El banco existe papu")).getBody().getStatus(),412);
    }

}
