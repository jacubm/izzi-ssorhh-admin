package izzi.ssorhh.users.service.impl;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import izzi.ssorhh.users.dto.response.AccionListResponseDTO;
import izzi.ssorhh.users.dto.response.AccionResponseDTO;
import izzi.ssorhh.users.transform.AccionTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import izzi.ssorhh.users.dto.AccionDTO;
import izzi.ssorhh.users.dto.request.AccionRequestDTO;
import izzi.ssorhh.users.entity.Accion;
import izzi.ssorhh.users.repository.AccionRepository;
import izzi.ssorhh.users.service.AccionService;


/**
 * Implementaci&oacute;n de {@link AccionService}.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see AccionService
 * @see AccionResponseDTO
 * @see AccionRequestDTO
 *
 */
@Service
@Transactional
public class AccionServiceImpl implements AccionService {

	@Autowired
	private AccionRepository accionRepository;

	@Override
	public AccionResponseDTO save(AccionRequestDTO reg) {
		AccionResponseDTO resp = new AccionResponseDTO();
		AccionTransform transform = new AccionTransform();
		try {
			resp = this.validParametersAddAcc(reg);
			if (resp.getResultDescription() == null && accionRepository.existsByAccion(reg.getAccion())) {
				resp.setResultCode(1L);
				resp.setResultDescription(
						String.format("La Accion: %s ya existe en la base de datos", reg.getAccion()));
			} else if (resp.getResultDescription() == null) {
				resp.setResultCode(0L);
				resp.setResultDescription("success");
				resp.setAccion(transform
						.parseDataEntotyToObject(accionRepository.save(transform.parseDataObjetToEntity(reg))));
			}
		} catch (Exception e) {
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	private AccionResponseDTO validParametersAddAcc(AccionRequestDTO reg) {
		AccionResponseDTO resp = new AccionResponseDTO();
		if ((reg.getAccion() == null || reg.getAccion().isEmpty())
				&& (reg.getComentarios() == null || reg.getComentarios().isEmpty())) {
			resp.setResultDescription("El campo Accion y Descripcion son obligatorios.");
			resp.setResultCode(1L);
		} else if ((reg.getAccion() == null || reg.getAccion().isEmpty())) {
			resp.setResultDescription("El campo Accion es obligatorio.");
			resp.setResultCode(1L);
		} else if ((reg.getComentarios() == null || reg.getComentarios().isEmpty())) {
			resp.setResultDescription("El campo Descripcion es obligatorio.");
			resp.setResultCode(1L);
		}
		return resp;
	}

	@Override
	public AccionListResponseDTO getAll() {
		AccionListResponseDTO resp = new AccionListResponseDTO();
		Set<AccionDTO> list = new TreeSet<>();
		AccionTransform transform = new AccionTransform();
		try {
			accionRepository.findAll().forEach(row -> {
				list.add(transform.parseDataEntotyToObject(row));
			});
			resp.setListAccion(list);
			resp.setResultCode(0L);
			resp.setResultDescription("success");
		} catch (Exception e) {
			resp.setListAccion(null);
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	@Override
	public AccionResponseDTO getGruopById(Integer id) {
		AccionResponseDTO resp = new AccionResponseDTO();
		AccionTransform transform = new AccionTransform();
		try {
			Optional<Accion> accO = accionRepository.findById(id);
			if (accO.isPresent()) {
				resp.setAccion(transform.parseDataEntotyToObject(accO.get()));
				resp.setResultCode(0L);
				resp.setResultDescription("success");
			} else {
				resp.setAccion(null);
				resp.setResultCode(1L);
				resp.setResultDescription("La Accion que desea buscar no existe en la base de datos");
			}
		} catch (Exception e) {
			resp.setAccion(null);
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	@Override
	public AccionResponseDTO update(AccionRequestDTO reg, Integer id) {
		AccionResponseDTO resp = new AccionResponseDTO();
		AccionTransform transform = new AccionTransform();
		try {
			if (!accionRepository.existsById(id)) {
				resp.setResultCode(1L);
				resp.setResultDescription("La Accion que desea actualizar no existe en la base de datos");
			} else {
				resp.setResultCode(0L);
				resp.setResultDescription("success");
				resp.setAccion(
						transform.parseDataEntotyToObject(accionRepository.save(this.prepareEntityUpdate(reg, id))));
			}
		} catch (Exception e) {
			resp.setResultCode(0L);
			resp.setResultDescription("error: ".concat(e.getMessage()));
			e.printStackTrace();
		}
		resp.setResultDate(resp.getResultDate());
		return resp;
	}

	private Accion prepareEntityUpdate(AccionRequestDTO acc, Integer id) {
		Accion accUp = accionRepository.getOne(id);
		accUp.setAccion(acc.getAccion() == null || acc.getAccion().isEmpty() ? accUp.getAccion() : acc.getAccion());
		accUp.setDescription(acc.getComentarios() == null || acc.getComentarios().isEmpty() ? accUp.getDescription()
				: acc.getComentarios());
		accUp.setEstatus(acc.getEstatus() == null ? accUp.getEstatus() : acc.getEstatus());
		accUp.setUser(acc.getUsuario() == null || acc.getUsuario().isEmpty() ? accUp.getUser() : acc.getUsuario());
		return accUp;
	}

	@Override
	public AccionResponseDTO delete(Integer id) {
		AccionResponseDTO resp = new AccionResponseDTO();
		try {
			if (!accionRepository.existsById(id)) {
				resp.setResultCode(1L);
				resp.setResultDescription("La Accion que desea eliminar no existe en la base de datos");
			} else {
				accionRepository.deleteById(id);
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
