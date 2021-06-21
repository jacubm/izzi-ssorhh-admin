package izzi.ssorhh.users.service;

import  izzi.ssorhh.users.dto.response.AccionListResponseDTO;
import  izzi.ssorhh.users.dto.response.AccionResponseDTO;
import izzi.ssorhh.users.dto.request.AccionRequestDTO;
import izzi.ssorhh.users.entity.Accion;

/**
 * Establece el contrato para la creaci&oacute;n del <code><b>SERVICE</b></code>
 * cuya responsabilidad ser&aacute; en realizar las operaciones del
 * m&oacute;dulo de <code><b>Acciones</b></code>.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 *
 * @see AccionRequestDTO
 * @see AccionListResponseDTO
 * @see AccionResponseDTO
 * @see Accion
 */
public interface AccionService {

	/**
	 * M&eacute;todo para persistir una {@link Accion} en la base de datos
	 * 
	 * @param reg {@link AccionRequestDTO} objeto, como par&aacute;metro de entrada.
	 * 
	 * @return {@link AccionResponseDTO} objeto recuperado.
	 */
	public AccionResponseDTO save(AccionRequestDTO reg);

	/**
	 * M&eacute;todo para listar todos los {@link Accion} que existen
	 * 
	 * @return {@link AccionListResponseDTO} objeto recuperado.
	 */
	public AccionListResponseDTO getAll();

	/**
	 * M&eacute;todo para obtener el {@link Accion} mediante su identificador
	 * &uacute;nico.
	 * 
	 * @param id Identificador &uacute;nico de {@link Accion}, como par&aacute;metro
	 *           de entrada.
	 * 
	 * @return {@link AccionResponseDTO} objeto recuperado.
	 */
	public AccionResponseDTO getGruopById(Integer id);

	public AccionResponseDTO update(AccionRequestDTO reg, Integer id);

	/**
	 * M&eacute;todo para eliminar un {@link Accion} de la base de datos
	 * 
	 * @param id Identificador &uacute;nico de {@link Accion}, como par&aacute;metro
	 *           de entrada.
	 * 
	 * @return {@link AccionResponseDTO} objeto recuperado.
	 */
	public AccionResponseDTO delete(Integer id);
}
