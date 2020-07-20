package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModelService.BancoDTO;
import ar.edu.undec.Service.ModelService.Response;
import ar.edu.undec.Service.ServiceMapper.BancoDTOMapper;
import exceptions.BancoNoExisteException;
import input.IFindByIdBancoInput;
import model.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/bancos")
public class FindBancoByIdController {

    @Autowired
    private IFindByIdBancoInput iFindByIdBancoInput;

    public FindBancoByIdController(IFindByIdBancoInput iFindByIdBancoInput) {
        this.iFindByIdBancoInput = iFindByIdBancoInput;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> findBancoById(@PathVariable Integer id) throws BancoNoExisteException {
        Response response = new Response();
        Banco banco = this.iFindByIdBancoInput.findById(id);
        BancoDTO bancoDTO = new BancoDTOMapper().mapeoCoreDTO(banco);
        response.setMessage("Banco encontrado");
        response.setData(bancoDTO);
        response.setStatus(200);

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
