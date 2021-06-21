package izzi.ssorhh.users.security.controller;

import izzi.ssorhh.users.dto.Mensaje;
import izzi.ssorhh.users.security.dto.JwtDto;
import izzi.ssorhh.users.security.dto.LoginUsuario;
import izzi.ssorhh.users.security.dto.NuevoUsuario;
import izzi.ssorhh.users.security.entity.Rol;
import izzi.ssorhh.users.security.entity.Usuario;
import izzi.ssorhh.users.security.enums.RolNombre;
import izzi.ssorhh.users.security.jwt.JwtProvider;
import izzi.ssorhh.users.security.repository.RolRepository;
import izzi.ssorhh.users.security.service.RolService;
import izzi.ssorhh.users.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;

	@Autowired
	RolRepository rolRepository;

	@Autowired
	JwtProvider jwtProvider;

	public String message = "Ok";

	@GetMapping
	public String message() {
		return "{code: " + message + "}";
	}

	@GetMapping("/lista")
	public ResponseEntity<List<Usuario>> list() {
		List<Usuario> list = usuarioService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@RequestBody NuevoUsuario nuevoUsuario) {
		if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
		Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
				nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		usuario.setRoles(roles);
		usuarioService.save(usuario);

		return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody NuevoUsuario nuevoUsuario) {

		Usuario usuario = usuarioService.getOne(id).get();
		usuario.setNombreUsuario(nuevoUsuario.getNombreUsuario());
		usuario.setEmail(nuevoUsuario.getEmail());
		usuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));

		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("usuario actualizado"), HttpStatus.OK);
	}

	@PostMapping("/loguear")
	public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
}
