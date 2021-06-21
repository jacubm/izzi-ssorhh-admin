package izzi.ssorhh.users.service;


import izzi.ssorhh.users.dto.request.SubModuloRequestDTO;
import izzi.ssorhh.users.dto.response.SubModuloListResponseDTO;
import izzi.ssorhh.users.dto.response.SubModuloResponseDTO;
import izzi.ssorhh.users.dto.response.AccionListResponseDTO;
import izzi.ssorhh.users.entity.SubModulo;
import izzi.ssorhh.users.entity.Accion;

/**
 * Establece el contrato para la creaci&oacute;n del <code><b>SERVICE</b></code>
 * cuya responsabilidad ser&aacute; en realizar las operaciones del
 * m&oacute;dulo de <code><b>Sub Modulo</b></code>.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 *
 * @see SubModuloRequestDTO
 * @see AccionListResponseDTO
 * @see SubModuloResponseDTO
 * @see SubModulo
 */
public interface SubModuloService {

	/**
	 * M&eacute;todo para persistir una {@link SubModulo} en la base de datos
	 * 
	 * @param reg {@link SubModuloRequestDTO} objeto, como par&aacute;metro de
	 *            entrada.
	 * 
	 * @return {@link SubModuloResponseDTO} objeto recuperado.
	 */
	public SubModuloResponseDTO save(SubModuloRequestDTO reg);

	/**
	 * M&eacute;todo para listar todos los {@link Accion} que existen
	 * 
	 * @return {@link SubModuloListResponseDTO} objeto recuperado.
	 */
	public SubModuloListResponseDTO getAll();

	/**
	 * M&eacute;todo para obtener el {@link SubModulo} mediante su identificador
	 * &uacute;nico.
	 * 
	 * @param id Identificador &uacute;nico de {@link SubModulo}, como
	 *           par&aacute;metro de entrada.
	 * 
	 * @return {@link SubModuloResponseDTO} objeto recuperado.
	 */
	public SubModuloResponseDTO getGruopById(Integer id);

	/**
	 * M&eacute;todo para persistir un {@link SubModulo} en la base de datos
	 * 
	 * @param reg {@link SubModuloRequestDTO} objeto, como par&aacute;metro de
	 *            entrada.
	 * 
	 * @param id  Identificador &uacute;nico de {@link SubModulo}, como
	 *            par&aacute;metro de entrada.
	 *
	 * @return {@link SubModuloResponseDTO} objeto recuperado.
	 */
	public SubModuloResponseDTO update(SubModuloRequestDTO reg, Integer id);

	/**
	 * M&eacute;todo para eliminar un {@link SubModulo} de la base de datos
	 * 
	 * @param id Identificador &uacute;nico de {@link SubModulo}, como
	 *           par&aacute;metro de entrada.
	 * 
	 * @return {@link SubModuloResponseDTO} objeto recuperado.
	 */
	public SubModuloResponseDTO delete(Integer id);
}
