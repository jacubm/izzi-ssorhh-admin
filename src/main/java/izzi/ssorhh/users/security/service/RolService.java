package izzi.ssorhh.users.security.service;

import java.util.Optional;

import izzi.ssorhh.users.security.enums.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import izzi.ssorhh.users.security.entity.Rol;
import izzi.ssorhh.users.security.repository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	RolRepository rolRepository;

	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return rolRepository.findByRolNombre(rolNombre);
	}

	public void save(Rol rol){
		rolRepository.save(rol);
	}
}
