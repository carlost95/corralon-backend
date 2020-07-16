package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.CrearBancoController;
import ar.edu.undec.Service.ModelService.BancoDTO;
import exceptions.BancoExisteException;
import exceptions.BancoIncompletoException;
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
    public void crearBanco_BancoNoExiste_Devuelve200() throws BancoExisteException, BancoIncompletoException {
        BancoDTO bancoDTO = new BancoDTO(null, "Banco Rioja", "BR", true);
        Banco banco = Banco.factoryBanco(null, "Banco Rioja", "BR", true);

        when(iCrearBancoInput.crearBanco(any(Banco.class))).thenReturn(banco);
        CrearBancoController crearBancoController = new CrearBancoController(iCrearBancoInput);

        assertEquals(crearBancoController.crearBanco(bancoDTO).getStatusCodeValue(), 200);

    }
}
