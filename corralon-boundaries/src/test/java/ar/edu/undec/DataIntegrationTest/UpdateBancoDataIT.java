package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.Implementation.UpdateBancoRepoImplementation;
import exceptions.BancoIncompletoException;
import model.Banco;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:banco/beforeUpdateBanco.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:banco/afterUpdateBanco.sql")
})
public class UpdateBancoDataIT {

    @Autowired
    private UpdateBancoRepoImplementation updateBancoRepoImplementation;

    @Test
    public void  actualizarBanco_BancoActualizado_devuelveTrue() throws BancoIncompletoException {
        Banco updated = Banco.factoryBanco(1, "Banco Patagonia", "BP", true);
        Banco resultado = updateBancoRepoImplementation.update(updated);
        assertNotNull(resultado);
    }
}
