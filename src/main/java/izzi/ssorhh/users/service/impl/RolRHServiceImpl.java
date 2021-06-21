package izzi.ssorhh.users.service.impl;

import izzi.ssorhh.users.admin.enums.RoleName;
import izzi.ssorhh.users.dto.RolDTO;
import izzi.ssorhh.users.dto.RolListResponseDTO;
import izzi.ssorhh.users.dto.RolResponseDTO;
import izzi.ssorhh.users.entity.RolRH;
import izzi.ssorhh.users.repository.RolRHRepository;
import izzi.ssorhh.users.service.IRolRHService;
import izzi.ssorhh.users.transform.RolTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
public class RolRHServiceImpl implements IRolRHService {

    @Autowired
    RolRHRepository rolRHRepository;

    @Override
    public Optional<RolRH> getByRolNombre(String rolNombre) {
        return rolRHRepository.findByRolNombre(rolNombre);
    }

    @Override
    public RolResponseDTO delete(Integer id) {
        RolResponseDTO resp = new RolResponseDTO();
        try {
            if (!rolRHRepository.existsById(id)) {
                resp.setResultCode(1L);
                resp.setResultDescription("El Rol que desea eliminar no existe en la base de datos");
            } else {
                rolRHRepository.deleteById(id);
                resp.setResultCode(0L);
                resp.setResultDescription("success");
            }
        } catch (Exception e) {
            resp.setResultCode(0L);
            resp.setResultDescription("error: ".concat(e.getMessage()));
            e.printStackTrace();
        }
        resp.setResultDate(resp.getResultDate());
        return resp;
    }

    @Override
    public RolResponseDTO save(RolDTO rol) {
        RolResponseDTO resp = new RolResponseDTO();
        RolTransform transform = new RolTransform();
        try {
            resp = this.validParametersAddRol(rol);
            if (resp.getResultDescription() == null && rolRHRepository.existsByRolNombre(rol.getRol())) {
                resp.setResultCode(1L);
                resp.setResultDescription(String.format("El Rol: %s ya existe en la base de datos", rol.getRol()));
            } else if (resp.getResultDescription() == null) {
                resp.setResultCode(0L);
                resp.setResultDescription("success");
                resp.setRol(
                        transform.parseDataEntityToObject(rolRHRepository.save(transform.parseDataEntityToObject(rol))));
            }
        } catch (Exception e) {
            resp.setResultCode(0L);
            resp.setResultDescription("error: ".concat(e.getMessage()));
            e.printStackTrace();
        }
        resp.setResultDate(resp.getResultDate());
        return resp;
    }

    @Override
    public RolResponseDTO update(RolDTO rol, Integer id) {
        RolResponseDTO resp = new RolResponseDTO();
        RolTransform transform = new RolTransform();
        try {
            if (!rolRHRepository.existsById(id)) {
                resp.setResultCode(1L);
                resp.setResultDescription("El Rol que desea actualizar no existe en la base de datos");
            } else {
                resp.setResultCode(0L);
                resp.setResultDescription("success");
                resp.setRol(transform.parseDataEntityToObject(rolRHRepository.save(this.prepareEntityUpdate(rol, id))));
            }
        } catch (Exception e) {
            resp.setResultCode(0L);
            resp.setResultDescription("error: ".concat(e.getMessage()));
            e.printStackTrace();
        }
        resp.setResultDate(resp.getResultDate());
        return resp;
    }

    private RolRH prepareEntityUpdate(RolDTO rol, Integer id) {
        RolRH rolUpdate = rolRHRepository.getOne(id);
        rolUpdate
                .setRolNombre(rol.getRol() == null || rol.getRol().isEmpty() ? rolUpdate.getRolNombre() : rol.getRol());
        rolUpdate.setDescription(
                rol.getDescripcion() == null || rol.getDescripcion().isEmpty() ? rolUpdate.getDescription()
                        : rol.getDescripcion());
        rolUpdate.setEstatus(rol.getDescripcion() == null || rol.getDescripcion().isEmpty() ? rolUpdate.isEstatus()
                : rol.getEstatus().equalsIgnoreCase("Activo") ? true : false);
        rolUpdate.setUser(
                rol.getUsuario() == null || rol.getUsuario().isEmpty() ? rolUpdate.getUser() : rol.getUsuario());
        return rolUpdate;
    }


    @Override
    public Optional<RolRH> getOne(Integer id) {
        return rolRHRepository.findById(id);
    }

    @Override
    public RolListResponseDTO list() {
        RolListResponseDTO resp = new RolListResponseDTO();
        RolTransform transform = new RolTransform();
        Set<RolDTO> list = new TreeSet<>();
        try {
            rolRHRepository.findAll().forEach(row -> {
                list.add(transform.parseDataEntityToObject(row));
            });
            resp.setListaRoles(list);
            resp.setResultCode(0L);
            resp.setResultDescription("success");
        } catch (Exception e) {
            resp.setListaRoles(null);
            resp.setResultCode(0L);
            resp.setResultDescription("error: ".concat(e.getMessage()));
            e.printStackTrace();
        }
        resp.setResultDate(resp.getResultDate());
        return resp;
    }

    private RolResponseDTO validParametersAddRol(RolDTO rol) {
        RolResponseDTO resp = new RolResponseDTO();
        if ((rol.getRol() == null || rol.getRol().isEmpty())
                && (rol.getDescripcion() == null || rol.getDescripcion().isEmpty())) {
            resp.setResultDescription("El campo Rol y Descripcion son obligatorios.");
            resp.setResultCode(1L);
        } else if (rol.getRol() == null || rol.getRol().isEmpty()) {
            resp.setResultDescription("El campo Rol es obligatorio.");
            resp.setResultCode(1L);
        } else if (rol.getDescripcion() == null || rol.getDescripcion().isEmpty()) {
            resp.setResultDescription("El campo Descripcion es obligatorio.");
            resp.setResultCode(1L);
        }
        return resp;
    }
}
