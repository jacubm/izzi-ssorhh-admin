package izzi.ssorhh.users.service.impl;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import izzi.ssorhh.users.dto.response.SubModuloListResponseDTO;
import izzi.ssorhh.users.dto.response.SubModuloResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import izzi.ssorhh.users.dto.SubModuloDTO;
import izzi.ssorhh.users.dto.request.SubModuloRequestDTO;
import izzi.ssorhh.users.entity.Grupos;
import izzi.ssorhh.users.entity.SubModulo;
import izzi.ssorhh.users.repository.GpoRepository;
import izzi.ssorhh.users.repository.SubModuloRepository;
import izzi.ssorhh.users.service.SubModuloService;
import izzi.ssorhh.users.transform.SubModTransform;

/**
 * Implementaci&oacute;n de {@link SubModuloService}.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see SubModuloService
 * @see SubModuloResponseDTO
 * @see SubModuloRequestDTO
 * @see SubModuloListResponseDTO
 *
 */
@Service
@Transactional
public class SubModuloServiceImpl implements SubModuloService {

	@Autowired
	private SubModuloRepository subModuloRepository;
	@Autowired
	private GpoRepository gpoRepository;

	@Override
	public SubModuloResponseDTO save(SubModuloRequestDTO mod) {
		SubModuloResponseDTO resp = new SubModuloResponseDTO();
		SubModTransform transform = new SubModTransform();
		try {
			resp = this.validParametersAddSubMod(mod);
			if (resp.getResultDescription() == null && !gpoRepository.existsById(mod.getIdGrupo())) {
				resp.setResultCode(1L);
				resp.setResultDescription("El Grupo, no existe en la base de datos");
			} else if (resp.getResultDescription() == null && subModuloRepository.existsByModulo(mod.getModulo())) {
				resp.setResultCode(1L);
				resp.setResultDescription(
						String.format("El Modulo: %s ya existe en la base de datos", mod.getModulo()));
			} else if (resp.getResultDescription() == null) {
				resp.setResultCode(0L);
				resp.setResultDescription("success");
				resp.setModulo(transform.parseDataEntotyToObject(subModuloRepository
						.save(transform.parseDataObjetToEntity(mod, gpoRepository.findById(mod.getIdGrupo()).get()))));
			}
		} catch (Exception e) {
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	private SubModuloResponseDTO validParametersAddSubMod(SubModuloRequestDTO sm) {
		SubModuloResponseDTO resp = new SubModuloResponseDTO();
		if ((sm.getComentarios() == null || sm.getComentarios().isEmpty())
				&& (sm.getModulo() == null || sm.getModulo().isEmpty()) && sm.getIdGrupo() == null) {
			resp.setResultDescription("El campo Modulo, Descripcion y Grupo son obligatorios.");
			resp.setResultCode(1L);
		} else if ((sm.getComentarios() == null || sm.getComentarios().isEmpty())) {
			resp.setResultDescription("El campo Comentarios es obligatorio.");
			resp.setResultCode(1L);
		} else if ((sm.getModulo() == null || sm.getModulo().isEmpty())) {
			resp.setResultDescription("El campo Modulo es obligatorio.");
			resp.setResultCode(1L);
		} else if (sm.getIdGrupo() == null) {
			resp.setResultDescription("El campo Grupo es obligatorio.");
			resp.setResultCode(1L);
		}
		return resp;
	}

	@Override
	public SubModuloListResponseDTO getAll() {
		SubModuloListResponseDTO resp = new SubModuloListResponseDTO();
		Set<SubModuloDTO> list = new TreeSet<>();
		SubModTransform transform = new SubModTransform();
		try {
			subModuloRepository.findAll().forEach(row -> {
				list.add(transform.parseDataEntotyToObject(row));
			});
			resp.setListSubModulos(list);
			resp.setResultCode(0L);
			resp.setResultDescription("success");
		} catch (Exception e) {
			resp.setListSubModulos(null);
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	@Override
	public SubModuloResponseDTO getGruopById(Integer id) {
		SubModuloResponseDTO resp = new SubModuloResponseDTO();
		SubModTransform transform = new SubModTransform();
		resp.setModulo(null);
		try {
			Optional<SubModulo> subModO = subModuloRepository.findById(id);
			if (subModO.isPresent()) {
				resp.setModulo(transform.parseDataEntotyToObject(subModO.get()));
				resp.setResultCode(0L);
				resp.setResultDescription("success");
			} else {
				resp.setResultCode(1L);
				resp.setResultDescription("El Modulo que desea buscar no existe en la base de datos");
			}
		} catch (Exception e) {
			resp.setResultCode(1L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	@Override
	public SubModuloResponseDTO update(SubModuloRequestDTO req, Integer id) {
		SubModuloResponseDTO resp = new SubModuloResponseDTO();
		SubModTransform transform = new SubModTransform();
		try {
			if (!subModuloRepository.existsById(id)) {
				resp.setResultCode(1L);
				resp.setResultDescription("El Modulo que desea actualizar no existe en la base de datos");
			} else {
				resp.setResultCode(0L);
				resp.setResultDescription("success");
				resp.setModulo(transform.parseDataEntotyToObject(subModuloRepository
						.save(this.prepareEntityUpdate(req, id, gpoRepository.findById(req.getIdGrupo()).get()))));
			}
		} catch (Exception e) {
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	private SubModulo prepareEntityUpdate(SubModuloRequestDTO req, Integer id, Grupos grupo) {
		SubModulo subModUp = subModuloRepository.getOne(id);
		subModUp.setModulo(
				req.getModulo() == null || req.getModulo().isEmpty() ? subModUp.getModulo() : req.getModulo());
		subModUp.setDescription(
				req.getComentarios() == null || req.getComentarios().isEmpty() ? subModUp.getDescription()
						: req.getComentarios());
		subModUp.setEstatus(req.getEstatus() == null ? subModUp.getEstatus() : req.getEstatus());
		subModUp.setUser(
				req.getUsuario() == null || req.getUsuario().isEmpty() ? subModUp.getUser() : req.getUsuario());
		subModUp.setGrupo(grupo);
		return subModUp;
	}

	@Override
	public SubModuloResponseDTO delete(Integer id) {
		SubModuloResponseDTO resp = new SubModuloResponseDTO();
		try {
			if (!subModuloRepository.existsById(id)) {
				resp.setResultCode(1L);
				resp.setResultDescription("El Modulo que desea eliminar no existe en la base de datos");
			} else {
				subModuloRepository.deleteById(id);
				resp.setResultCode(0L);
				resp.setResultDescription("success");
			}
		} catch (Exception e) {
			resp.setResultCode(1L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

}
