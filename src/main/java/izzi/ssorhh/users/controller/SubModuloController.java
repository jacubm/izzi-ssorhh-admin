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

import izzi.ssorhh.users.dto.Mensaje;
import izzi.ssorhh.users.dto.request.SubModuloRequestDTO;
import izzi.ssorhh.users.service.SubModuloService;

/**
 * Establece el contrato para la creaci&oacute;n del
 * <code><b>CONTROLLER</b></code> cuya responsabilidad ser&aacute; obtener el
 * m&oacute;dulo de <code><b>Sub M&oacute;dulo</b></code>.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 *
 */
@RestController
@RequestMapping("/submodulos")
@CrossOrigin
public class SubModuloController {

	@Autowired
	private SubModuloService subModuloService;


	@PostMapping("/crear_subModulo")
	public ResponseEntity<?> crear(@Valid @RequestBody SubModuloRequestDTO req, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity(subModuloService.save(req), HttpStatus.OK);
	}


	@GetMapping("/listar")
	public ResponseEntity<?> list() {
		return new ResponseEntity(subModuloService.getAll(), HttpStatus.OK);
	}


	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
		return new ResponseEntity(subModuloService.getGruopById(id), HttpStatus.OK);
	}


	@PutMapping("/actualizar_subModulo/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody SubModuloRequestDTO req) {
		return new ResponseEntity(subModuloService.update(req, id), HttpStatus.OK);
	}


	@DeleteMapping("/borrar_subModulo/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		return new ResponseEntity(subModuloService.delete(id), HttpStatus.OK);
	}
}
