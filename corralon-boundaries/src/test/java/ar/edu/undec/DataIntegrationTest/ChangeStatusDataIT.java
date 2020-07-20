package ar.edu.undec.DataIntegrationTest;

import ar.edu.undec.Data.Implementation.ChangeStatusRepoImplementation;
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

import static junit.framework.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:banco/changeStatusBefore.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,scripts = "classpath:banco/changeStatusAfter.sql")
})
public class ChangeStatusDataIT {

    @Autowired
    private ChangeStatusRepoImplementation changeStatusRepoImplementation;

    @Test
    public void should_SaveBanco_WhenStatusChange() throws BancoIncompletoException {
        Banco banco = Banco.factoryBanco(1, "Banco Rioja", "BR", true);
        banco = changeStatusRepoImplementation.save(banco);
        assertNotNull(banco);
    }
}