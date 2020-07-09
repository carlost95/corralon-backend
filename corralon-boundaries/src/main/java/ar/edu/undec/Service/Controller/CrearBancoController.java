package ar.edu.undec.Service.Controller;

import ar.edu.undec.Service.ModelService.BancoDTO;
import ar.edu.undec.Service.ServiceMapper.BancoDTOMapper;
import exceptions.BancoExisteException;
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
    public ResponseEntity<?> crearBanco(@RequestBody BancoDTO bancoDTO) {
        try {
            Banco banco = new BancoDTOMapper().mapeoDTOCore(bancoDTO);
            boolean resultado= this.iCrearBancoInput.crearBanco(banco);
            if(resultado)
                return ResponseEntity.status(HttpStatus.OK).body(true);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (BancoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        }
    }
}
