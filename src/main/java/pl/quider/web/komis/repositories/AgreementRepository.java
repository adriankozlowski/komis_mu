package pl.quider.web.komis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.quider.web.komis.models.Agreement;
import pl.quider.web.komis.models.AgreementType;
import pl.quider.web.komis.models.Car;

import java.util.List;

/**
 * Created by adrian on 04.05.17.
 */
@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Integer> {
    @Query("from Agreement a where a.agreementType = :agreementType")
    List<Agreement> findAllByAgreementType(@Param("agreementType") AgreementType purchaseType);

    @Query("select count(a.id) from Agreement a where a.car.id = :id")
    Integer countAllByCarId(@Param("id")Integer id);

    @Query("from Agreement a where (a.agreementType.id = 2 or a.agreementType.id = 3) and a.car = :car")
    Agreement findReadyToBuyCarById(@Param("car") Car car);

    @Query("from Agreement a where (a.agreementType.id = 2 or a.agreementType.id = 3) and a.car.id = :car")
    Agreement findAgreementByCarId(@Param("car") Integer carId);
}
