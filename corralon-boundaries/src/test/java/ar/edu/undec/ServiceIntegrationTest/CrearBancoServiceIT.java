package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.CrearBancoController;
import ar.edu.undec.Service.ModelService.BancoDTO;
import exceptions.BancoExisteException;
import input.ICrearBancoInput;
import model.Banco;
import org.apache.http.HttpStatus;
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
public class CrearBancoServiceIT {

    @Mock
    ICrearBancoInput iCrearBancoInput;

    @Test
    public void crearBanco_BancoNoExiste_Devuelve200() throws BancoExisteException {
        BancoDTO banco = new BancoDTO(null, "Banco Rioja", "BR", true);
        when(iCrearBancoInput.crearBanco(any(Banco.class))).thenReturn(true);
        CrearBancoController crearBancoController = new CrearBancoController(iCrearBancoInput);
        assertEquals(crearBancoController.crearBanco(banco).getStatusCodeValue(), HttpStatus.SC_OK);

    }

    @Test
    public void crearBanco_BancoExiste_Devuelve412() throws Exception {
        BancoDTO bancoDTO =new BancoDTO(null,"Banco Rioja","BR",true);
        when(iCrearBancoInput.crearBanco(any(Banco.class))).thenThrow(new BancoExisteException("El Banco Existe"));
        CrearBancoController crearBancoController=new CrearBancoController(iCrearBancoInput);
        assertEquals(crearBancoController.crearBanco(bancoDTO).getStatusCodeValue(),HttpStatus.SC_PRECONDITION_FAILED);
    }
}
