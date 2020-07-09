package model;

import exceptions.BancoIncompletoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BancoUnitTest {

    @Test
    public void factoryBanco_TodosLosAtributosOk_instanciaCorrecta() throws BancoIncompletoException {
        Banco banco = Banco.factoryBanco(null, "Banco Patagonia", "BP", true);
        Assertions.assertNotNull(banco);
    }

    @Test
    public void factoryBanco_FaltaHabilitacion_instanciaCorrecta() throws BancoIncompletoException {
        Banco banco = Banco.factoryBanco(null, "Banco Patagonia", "BP", null);
        Assertions.assertNotNull(banco);
    }

    @Test
    public void factoryBanco_AtributoNull_instanciaIncorrecta(){
        Assertions.assertThrows(BancoIncompletoException.class, ()-> {
            Banco banco = Banco.factoryBanco(null, null, "BP", true);
        });
    }

    @Test
    public void factoryBanco_AtributoVacio_instanciaIncorrecta(){
        Assertions.assertThrows(BancoIncompletoException.class, ()-> {
            Banco banco = Banco.factoryBanco(null, "", "BP", true);
        });
    }
}
