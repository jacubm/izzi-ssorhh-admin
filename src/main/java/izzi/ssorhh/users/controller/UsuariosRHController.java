package izzi.ssorhh.users.controller;


import izzi.ssorhh.users.dto.Mensaje;
import izzi.ssorhh.users.dto.NuevoUsuarioRH;
import izzi.ssorhh.users.entity.UsuarioRH;
import izzi.ssorhh.users.repository.RolRHRepository;
import izzi.ssorhh.users.service.IUsuariosRHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuariosRHController {

    @Autowired
    IUsuariosRHService usuariosService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolRHRepository rolRHRepository;
    public String message = "Ok";

    @GetMapping
    public String message() {
        return "{code: " + message + "}";
    }

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioRH>> list() {
        List<UsuarioRH> list = usuariosService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<UsuarioRH> getById(@PathVariable("id") int id){
        if(!usuariosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        UsuarioRH usuarioRH = usuariosService.getOne(id).get();
        return new ResponseEntity(usuarioRH, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NuevoUsuarioRH nuevoUsuarioRH) {
        UsuarioRH usuarioRH = new UsuarioRH(nuevoUsuarioRH.getIdSSFF(), nuevoUsuarioRH.getNombre(),
                nuevoUsuarioRH.getaPaterno(), nuevoUsuarioRH.getaMaterno(), nuevoUsuarioRH.getNombreUsuario(),
                nuevoUsuarioRH.getEmail(), passwordEncoder.encode(nuevoUsuarioRH.getPassword()), nuevoUsuarioRH.getFecAlta(),
                nuevoUsuarioRH.getFecBaja(), nuevoUsuarioRH.getStatus(), nuevoUsuarioRH.getFecReg(),
                nuevoUsuarioRH.getIdRegSF(), nuevoUsuarioRH.getComentarios(), nuevoUsuarioRH.getMtdoInicio(),
                nuevoUsuarioRH.getTpoUser());

        usuariosService.save(usuarioRH);

        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody NuevoUsuarioRH nuevoUsuarioRH) {

        UsuarioRH usuarioRH = usuariosService.getOne(id).get();

        usuarioRH.setEmail(nuevoUsuarioRH.getEmail());
        usuarioRH.setNombreUsuario(nuevoUsuarioRH.getNombreUsuario());
        usuarioRH.setPassword(nuevoUsuarioRH.getPassword());
        usuarioRH.setStatus(nuevoUsuarioRH.getStatus());
        usuarioRH.setTpoUser(nuevoUsuarioRH.getTpoUser());
        usuarioRH.setMtdoInicio(nuevoUsuarioRH.getMtdoInicio());

        usuariosService.save(usuarioRH);
        return new ResponseEntity(new Mensaje("usuario actualizado"), HttpStatus.OK);
    }


}
