package izzi.ssorhh.users.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import izzi.ssorhh.users.dto.GrupoDTO;
import izzi.ssorhh.users.dto.Mensaje;
import izzi.ssorhh.users.dto.RolListResponseDTO;
import izzi.ssorhh.users.service.IGposService;


@RestController
@RequestMapping("/grupos")
@CrossOrigin
public class GrupoController {

	@Autowired
	private IGposService iGposService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/listar")
	public ResponseEntity<RolListResponseDTO> list() {
		return new ResponseEntity(iGposService.getAll(), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
		return new ResponseEntity(iGposService.getGruopById(id), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/crear_grupo")
	public ResponseEntity<?> crear(@Valid @RequestBody GrupoDTO rol, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity(iGposService.save(rol), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/actualizar_grupo/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody GrupoDTO grupos) {
		return new ResponseEntity(iGposService.update(grupos, id), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/borrar_grupo/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		return new ResponseEntity(iGposService.delete(id), HttpStatus.OK);
	}
}
