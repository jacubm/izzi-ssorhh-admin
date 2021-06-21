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
import izzi.ssorhh.users.dto.request.AccionRequestDTO;
import izzi.ssorhh.users.service.AccionService;

/**
 * Establece el contrato para la creaci&oacute;n del
 * <code><b>CONTROLLER</b></code> cuya responsabilidad ser&aacute; obtener el
 * m&oacute;dulo de <code><b>Acciones</b></code>.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 *
 */
@RestController
@RequestMapping("/acciones")
@CrossOrigin
public class AccionController {

	@Autowired
	private AccionService accionService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/crear_accion")
	public ResponseEntity<?> crear(@Valid @RequestBody AccionRequestDTO acc, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		return new ResponseEntity(accionService.save(acc), HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/listar")
	public ResponseEntity<?> list() {
		return new ResponseEntity(accionService.getAll(), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
		return new ResponseEntity(accionService.getGruopById(id), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/actualizar_accion/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody AccionRequestDTO acc) {
		return new ResponseEntity(accionService.update(acc, id), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/borrar_accion/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		return new ResponseEntity(accionService.delete(id), HttpStatus.OK);
	}
}
