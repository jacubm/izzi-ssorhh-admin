package izzi.ssorhh.users.service.impl;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import izzi.ssorhh.users.entity.Grupos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import izzi.ssorhh.users.dto.GrupoDTO;
import izzi.ssorhh.users.dto.GrupoListResponseDTO;
import izzi.ssorhh.users.dto.GrupoResponseDTO;
import izzi.ssorhh.users.repository.GpoRepository;
import izzi.ssorhh.users.security.enums.GpoNombre;
import izzi.ssorhh.users.service.IGposService;
import izzi.ssorhh.users.transform.GrupoTransform;


@Service
@Transactional
public class GpoServiceImpl implements IGposService {

	@Autowired
	GpoRepository gpoRepository;

	@Override
	public Optional<Grupos> findByGposNombre(GpoNombre gpoNombre) {
		return gpoRepository.findByGpoNombre(gpoNombre.name());
	}

	@Override
	public GrupoResponseDTO save(GrupoDTO grupos) {
		GrupoResponseDTO resp = new GrupoResponseDTO();
		GrupoTransform transform = new GrupoTransform();
		try {
			resp = this.validParametersAddRol(grupos);
			if (resp.getResultDescription() == null && gpoRepository.existsByGpoNombre(grupos.getGrupo())) {
				resp.setResultCode(1L);
				resp.setResultDescription(
						String.format("El Grupo: %s ya existe en la base de datos", grupos.getGrupo()));
			} else if (resp.getResultDescription() == null) {
				resp.setResultCode(0L);
				resp.setResultDescription("success");
				resp.setGrupo(transform
						.parseDataEntityToObject(gpoRepository.save(transform.parseDataObjetToEntity(grupos))));
			}
		} catch (Exception e) {
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	private GrupoResponseDTO validParametersAddRol(GrupoDTO grupo) {
		GrupoResponseDTO resp = new GrupoResponseDTO();
		if ((grupo.getGrupo() == null || grupo.getGrupo().isEmpty())
				&& (grupo.getDescripcion() == null || grupo.getDescripcion().isEmpty())) {
			resp.setResultDescription("El campo Grupo y Descripcion son obligatorios.");
			resp.setResultCode(1L);
		} else if (grupo.getGrupo() == null || grupo.getGrupo().isEmpty()) {
			resp.setResultDescription("El campo Grupo es obligatorio.");
			resp.setResultCode(1L);
		} else if (grupo.getDescripcion() == null || grupo.getDescripcion().isEmpty()) {
			resp.setResultDescription("El campo Descripcion es obligatorio.");
			resp.setResultCode(1L);
		}
		return resp;
	}

	@Override
	public GrupoListResponseDTO getAll() {
		GrupoListResponseDTO resp = new GrupoListResponseDTO();
		Set<GrupoDTO> list = new TreeSet<>();
		GrupoTransform transform = new GrupoTransform();
		try {
			gpoRepository.findAll().forEach(row -> {
				list.add(transform.parseDataEntityToObject(row));
			});
			resp.setListaGrupos(list);
			resp.setResultCode(0L);
			resp.setResultDescription("success");
		} catch (Exception e) {
			resp.setListaGrupos(null);
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	@Override
	public GrupoResponseDTO getGruopById(Integer id) {
		GrupoResponseDTO resp = new GrupoResponseDTO();
		GrupoTransform transform = new GrupoTransform();
		try {
			Optional<Grupos> gpO = gpoRepository.findById(id);
			if (gpO.isPresent()) {
				resp.setGrupo(transform.parseDataEntityToObject(gpO.get()));
				resp.setResultCode(0L);
				resp.setResultDescription("success");
			} else {
				resp.setGrupo(null);
				resp.setResultCode(1L);
				resp.setResultDescription("El Grupo que desea buscar no existe en la base de datos");
			}
		} catch (Exception e) {
			resp.setGrupo(null);
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	@Override
	public GrupoResponseDTO update(GrupoDTO grupos, Integer id) {
		GrupoResponseDTO resp = new GrupoResponseDTO();
		GrupoTransform transform = new GrupoTransform();
		try {
			if (!gpoRepository.existsById(id)) {
				resp.setResultCode(1L);
				resp.setResultDescription("El Grupo que desea actualizar no existe en la base de datos");
			} else {
				resp.setResultCode(0L);
				resp.setResultDescription("success");
				resp.setGrupo(transform.parseDataEntityToObject(gpoRepository.save(this.prepareEntityUpdate(grupos, id))));
			}
		} catch (Exception e) {
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}
	
	private Grupos prepareEntityUpdate(GrupoDTO grupo, Integer id) {
		Grupos grupoUpdate = gpoRepository.getOne(id);
		grupoUpdate
				.setGpoNombre(grupo.getGrupo() == null || grupo.getGrupo().isEmpty() ? grupoUpdate.getGpoNombre() : grupo.getGrupo());
		grupoUpdate.setDescription(
				grupo.getDescripcion() == null || grupo.getDescripcion().isEmpty() ? grupoUpdate.getDescription()
						: grupo.getDescripcion());
		grupoUpdate.setEstatus(grupo.getEstatus() == null || grupo.getEstatus().isEmpty() ? grupoUpdate.getEstatus()
				: grupo.getEstatus().equalsIgnoreCase("Activo") ? 1 : 0);
		grupoUpdate.setUser(
				grupo.getUsuario() == null || grupo.getUsuario().isEmpty() ? grupoUpdate.getUser() : grupo.getUsuario());
		return grupoUpdate;
	}

	@Override
	public GrupoResponseDTO delete(Integer id) {
		GrupoResponseDTO resp = new GrupoResponseDTO();
		try {
			if (!gpoRepository.existsById(id)) {
				resp.setResultCode(1L);
				resp.setResultDescription("El Grupo que desea eliminar no existe en la base de datos");
			} else {
				gpoRepository.deleteById(id);
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

}
