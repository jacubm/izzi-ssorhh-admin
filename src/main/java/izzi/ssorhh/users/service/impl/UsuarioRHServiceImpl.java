package izzi.ssorhh.users.service.impl;

import izzi.ssorhh.users.entity.UsuarioRH;
import izzi.ssorhh.users.repository.UsuarioRHRepository;
import izzi.ssorhh.users.service.IUsuariosRHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioRHServiceImpl implements IUsuariosRHService {

    @Autowired
    private UsuarioRHRepository usuarioRepository;

    @Override
    public List<UsuarioRH> list() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioRH> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public boolean existsById(int id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public Optional<UsuarioRH> getOne(int id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public void save(UsuarioRH userrh) {
        usuarioRepository.save(userrh);
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById(id);
    }
}
