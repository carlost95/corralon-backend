package ar.edu.undec.Service.ServiceMapper;

import ar.edu.undec.Service.ModelService.BancoDTO;
import exceptions.BancoIncompletoException;
import model.Banco;

public class BancoDTOMapper {
    public Banco mapeoDTOCore(BancoDTO bancoDTO) {
         try {
             return Banco.factoryBanco(bancoDTO.getId(), bancoDTO.getNombre(), bancoDTO.getAbreviatura(),bancoDTO.isHabilitado());
         } catch (BancoIncompletoException e) {
             e.printStackTrace();
             return null;
         }
    }

    public BancoDTO mapeoCoreDTO(Banco banco) {
        BancoDTO bancoDTO = new BancoDTO(banco.getId(), banco.getNombre(), banco.getAbreviatura(), banco.getHabilitado());

        return bancoDTO;
    }
}
