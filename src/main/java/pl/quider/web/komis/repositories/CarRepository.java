package pl.quider.web.komis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.quider.web.komis.models.Car;

/**
 * Created by adrian on 04.05.17.
 */
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("select count(c.id) from Car c where c.vin = :vin")
    public Integer countCars(@Param("vin")String vin);
}
