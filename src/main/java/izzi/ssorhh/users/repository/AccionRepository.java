package izzi.ssorhh.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import izzi.ssorhh.users.entity.Accion;

/**
 * Establece el contrato para la creaci&oacute;n del
 * <a href="https://es.wikipedia.org/wiki/Data_Access_Object" target=
 * "_blank">DAO</a> especilizado en el m&oacute;dulo de
 * <code><b>Acciones</b></code>.
 *
 * @author Jonathan David Reyes Ponce
 * @author <a href="http://www.adbansys.com/" target="_blank">Adbanys</a>
 * 
 * @see Accion
 * @see Integer
 * @see JpaRepository
 *
 */
@Repository
public interface AccionRepository extends JpaRepository<Accion, Integer> {
	public boolean existsByAccion(String accion);
}
