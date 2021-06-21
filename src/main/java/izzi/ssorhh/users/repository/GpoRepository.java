package izzi.ssorhh.users.repository;

import java.util.Optional;

import izzi.ssorhh.users.entity.Grupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GpoRepository extends JpaRepository<Grupos, Integer> {
	Optional<Grupos> findByGpoNombre(String gpoNombre);
	boolean existsByGpoNombre(String name);
}
