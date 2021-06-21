package izzi.ssorhh.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import izzi.ssorhh.users.entity.SubModulo;

/**
 * Establece el contrato para la creaci&oacute;n del
 * <a href="https://es.wikipedia.org/wiki/Data_Access_Object" target=
 * "_blank">DAO</a> especilizado en el m&oacute;dulo de
 * <code><b>Sub M&oacute;dulos</b></code>.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see SubModulo
 * @see Integer
 * @see JpaRepository
 *
 */
@Repository
public interface SubModuloRepository extends JpaRepository<SubModulo, Integer> {

	/**
	 * M&eacue;todo para validar si el rol ya existe dentro de la base de datos
	 * 
	 * @param reg Nombre de {@link SubModulo}, como par&aacute;metro de entrada.
	 * 
	 * @return True o False de la validaci&oacute;n
	 */
	public boolean existsByModulo(String mod);
}
