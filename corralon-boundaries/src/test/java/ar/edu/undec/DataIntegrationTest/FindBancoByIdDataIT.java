package ar.edu.undec.DataIntegrationTest;


import ar.edu.undec.Data.Implementation.FindBancoByIdRepoImplementation;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:banco/beforeFindBancoById.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:banco/afterFindBancoById.sql")
})
public class FindBancoByIdDataIT {

    @Autowired
    private FindBancoByIdRepoImplementation findBancoByIdRepoImplementation;

    @Test
    public void  findBancoById_BancoEncontrado_devuelveBanco() throws BancoIncompletoException {
        Banco resultado = findBancoByIdRepoImplementation.findById(1);
        assertNotNull(resultado);
    }

}
