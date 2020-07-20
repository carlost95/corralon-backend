package ar.edu.undec.Service.Controller;

import ar.edu.undec.Data.EntityMapper.BancoEntityMapper;
import ar.edu.undec.Service.ModelService.BancoDTO;
import ar.edu.undec.Service.ModelService.Response;
import ar.edu.undec.Service.ServiceMapper.BancoDTOMapper;
import ch.qos.logback.core.encoder.EchoEncoder;
import exceptions.BancoExisteException;
import exceptions.BancoIncompletoException;
import exceptions.BancoNoExisteException;
import input.IUpdateBancoInput;
import model.Banco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/bancos")
@RestController
public class UpdateBancoController {

    static final Logger LOG = LoggerFactory.getLogger(UpdateBancoController.class);

    @Autowired
    private IUpdateBancoInput iUpdateBancoInput;

    public UpdateBancoController(IUpdateBancoInput iUpdateBancoInput) {
        this.iUpdateBancoInput = iUpdateBancoInput;
    }

    @PutMapping
    public ResponseEntity<Response> update(@RequestBody BancoDTO bancoDTO) throws BancoIncompletoException, BancoExisteException, BancoNoExisteException {
        LOG.info("UpdateBancoController - update");
        Response response = new Response();
        Banco banco = new BancoDTOMapper().mapeoDTOCore(bancoDTO);
        response.setStatus(200);
        response.setData(new BancoDTOMapper().mapeoCoreDTO(this.iUpdateBancoInput.update(banco)));
        response.setMessage("Banco actualizado correctamente.");
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
