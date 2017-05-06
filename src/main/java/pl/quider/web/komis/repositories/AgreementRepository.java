package pl.quider.web.komis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.quider.web.komis.models.Agreement;
import pl.quider.web.komis.models.AgreementType;

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
}
