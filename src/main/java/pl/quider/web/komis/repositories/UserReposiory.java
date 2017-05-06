package pl.quider.web.komis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.quider.web.komis.models.User;

/**
 * Created by adrian on 04.05.17.
 */
@Repository
public interface UserReposiory extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
