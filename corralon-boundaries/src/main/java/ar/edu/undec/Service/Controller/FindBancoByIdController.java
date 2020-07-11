package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModelService.BancoDTO;
import ar.edu.undec.Service.ModelService.Response;
import ar.edu.undec.Service.ServiceMapper.BancoDTOMapper;
import exceptions.BancoNoExisteException;
import input.IFindByIdBancoInput;
import model.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/bancos")
public class FindBancoByIdController {

    @Autowired
    private IFindByIdBancoInput iFindByIdBancoInput;

    public FindBancoByIdController(IFindByIdBancoInput iFindByIdBancoInput) {
        this.iFindByIdBancoInput = iFindByIdBancoInput;
    }

    public Response findBancoById(Integer id){
        Response response = new Response();
        try {
            Banco banco = this.iFindByIdBancoInput.findById(id);
            BancoDTO bancoDTO = new BancoDTOMapper().mapeoCoreDTO(banco);
            response.setMessage("Banco encontrado");
            response.setData(bancoDTO);
            response.setStatus(200);

        } catch (Exception e) {
            response.setMessage("Banco no existe");
            response.setStatus(412);
        }
        return response;
    }
}
