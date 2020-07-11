package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModelService.BancoDTO;
import ar.edu.undec.Service.ModelService.Response;
import ar.edu.undec.Service.ServiceMapper.BancoDTOMapper;
import ch.qos.logback.core.encoder.EchoEncoder;
import exceptions.BancoNoExisteException;
import input.IUpdateBancoInput;
import model.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/bancos")
@RestController
public class UpdateBancoController {

    @Autowired
    private IUpdateBancoInput iUpdateBancoInput;

    public UpdateBancoController(IUpdateBancoInput iUpdateBancoInput) {
        this.iUpdateBancoInput = iUpdateBancoInput;
    }

    @PutMapping
    public Response update(@RequestBody BancoDTO bancoDTO){
        Response response = new Response();
        try {
            Banco banco = new BancoDTOMapper().mapeoDTOCore(bancoDTO);
            banco = this.iUpdateBancoInput.update(banco);
            if (banco != null){
                response.setStatus(200);
                response.setData(new BancoDTOMapper().mapeoCoreDTO(banco));
                response.setMessage("Banco actualizado correctamente.");
            }
        } catch (Exception e) {
            response.setStatus(412);
            response.setMessage("Error al guardar - Banco no existe");
        }
        return response;

    }
}
