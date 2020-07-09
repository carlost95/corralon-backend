package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.Implementation.CrearBancoRepoImplementation;
import exceptions.BancoIncompletoException;
import model.Banco;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:crearBancoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,scripts = "classpath:crearBancoAntes.sql")
})
public class CrearBancoDataIT {

    @Autowired
    private CrearBancoRepoImplementation crearBancoRepoImplementation;

    @Test
    public void guardarBanco_BancoGuardado_devuelveTrue() throws BancoIncompletoException {
        Banco banco = Banco.factoryBanco(null, "Banco Rioja", "BR", true);
        boolean resultado = crearBancoRepoImplementation.save(banco);
        assertTrue(resultado);
    }
}
