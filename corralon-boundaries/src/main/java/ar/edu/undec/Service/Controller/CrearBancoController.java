package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModelService.BancoDTO;
import ar.edu.undec.Service.ModelService.Response;
import ar.edu.undec.Service.ServiceMapper.BancoDTOMapper;
import exceptions.BancoExisteException;
import exceptions.BancoIncompletoException;
import input.ICrearBancoInput;
import model.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/bancos")
@RestController
public class CrearBancoController {

    @Autowired
    private ICrearBancoInput iCrearBancoInput;

    public CrearBancoController(ICrearBancoInput iCrearBancoInput) {
        this.iCrearBancoInput = iCrearBancoInput;
    }

    @PostMapping
    public ResponseEntity<Response> crearBanco(@RequestBody BancoDTO bancoDTO) throws BancoExisteException, BancoIncompletoException {
        Response response = new Response();
        Banco banco = new BancoDTOMapper().mapeoDTOCore(bancoDTO);
        Banco resultado = this.iCrearBancoInput.crearBanco(banco);
        response.setStatus(200);
        response.setMessage("Banco creado correctamente");
        response.setData(resultado);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
