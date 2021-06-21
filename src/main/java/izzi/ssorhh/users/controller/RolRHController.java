package izzi.ssorhh.users.controller;

import izzi.ssorhh.users.dto.Mensaje;
import izzi.ssorhh.users.dto.RolDTO;
import izzi.ssorhh.users.dto.RolListResponseDTO;
import izzi.ssorhh.users.dto.RolResponseDTO;
import izzi.ssorhh.users.entity.RolRH;
import izzi.ssorhh.users.service.IRolRHService;
import izzi.ssorhh.users.transform.RolTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@CrossOrigin
public class RolRHController {

    @Autowired
    IRolRHService rolRHService;

    @GetMapping("/listar_rol")
    public ResponseEntity<RolListResponseDTO> list() {
        return new ResponseEntity(rolRHService.list(), HttpStatus.OK);
    }

    @GetMapping("/buscar_rol/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        RolResponseDTO resp = new RolResponseDTO();
        Optional<RolRH> rol = rolRHService.getOne(id);
        if (!rol.isPresent())
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.NOT_FOUND);
        resp.setRol(new RolTransform().parseDataEntityToObject(rol.get()));
        resp.setResultCode(0L);
        resp.setResultDescription("success");
        resp.setResultDate(resp.getResultDate());
        return new ResponseEntity(resp, HttpStatus.OK);
    }

    @PostMapping("/crear_rol")
    public ResponseEntity<?> crear(@Valid @RequestBody RolDTO rol, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity(rolRHService.save(rol), HttpStatus.OK);
    }

    @PutMapping("/actualizar_rol/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody RolDTO rol) {
        return new ResponseEntity(rolRHService.update(rol, id), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return new ResponseEntity(rolRHService.delete(id), HttpStatus.OK);
    }
}
