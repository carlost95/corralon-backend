package ar.edu.undec.Service.ServiceMapper;

import ar.edu.undec.Service.ModelService.BancoDTO;
import exceptions.BancoIncompletoException;
import model.Banco;

import java.time.format.DateTimeFormatter;

public class BancoDTOMapper {

    public Banco mapeoDTOCore(BancoDTO bancoDTO) throws BancoIncompletoException {
             return Banco.factoryBanco(bancoDTO.getId(), bancoDTO.getNombre(), bancoDTO.getAbreviatura(),bancoDTO.isHabilitado());
    }

    public BancoDTO mapeoCoreDTO(Banco banco) {
        BancoDTO bancoDTO = new BancoDTO(banco.getId(), banco.getNombre(), banco.getAbreviatura(), banco.getHabilitado());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String created_at = banco.getCreatedAt().format(formatter);
        String updatedAt = banco.getUpdatedAt().format(formatter);
        System.out.println("created_at: " + created_at);
        System.out.println("updatedAt: " + updatedAt);

        bancoDTO.setCreated_at(created_at);
        bancoDTO.setUpdated_at(updatedAt);

        return bancoDTO;
    }
}
