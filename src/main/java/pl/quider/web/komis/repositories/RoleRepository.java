package pl.quider.web.komis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.quider.web.komis.models.Role;

/**
 * Created by adrian on 04.05.17.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
