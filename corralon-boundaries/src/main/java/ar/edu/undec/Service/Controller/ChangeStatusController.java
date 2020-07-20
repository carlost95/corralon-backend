package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModelService.BancoDTO;
import ar.edu.undec.Service.ModelService.Response;
import ar.edu.undec.Service.ServiceMapper.BancoDTOMapper;
import exceptions.BancoIncompletoException;
import exceptions.BancoNoExisteException;
import input.IChangeStatusInput;
import model.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/bancos")
@RestController
public class ChangeStatusController {

    @Autowired
    private IChangeStatusInput iChangeStatusInput;

    public ChangeStatusController(IChangeStatusInput iChangeStatusInput) {
        this.iChangeStatusInput = iChangeStatusInput;
    }

    @PutMapping("/status")
    public ResponseEntity<Response> changeStatus(@RequestBody BancoDTO bancoDTO) throws BancoIncompletoException, BancoNoExisteException {
        Response response = new Response();
        Banco banco = new BancoDTOMapper().mapeoDTOCore(bancoDTO);
        response.setStatus(200);
        response.setData(new BancoDTOMapper().mapeoCoreDTO(this.iChangeStatusInput.changeStatus(banco)));
        response.setMessage("Habilitacion Actualizadacorrectamente.");
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
