package pl.quider.web.komis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.quider.web.komis.models.Fuel;

/**
 * Created by adrian on 06.05.17.
 */
@Repository
public interface FuelRepository extends JpaRepository<Fuel, Integer>{
}
