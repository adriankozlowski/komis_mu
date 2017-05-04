package pl.quider.web.komis.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by adrian on 04.05.17.
 */
@Entity
@Table(name = "agreements")
public class Agreement extends AbstractEntity {
    @Column
    protected String content;

    @Column
    protected BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    protected Date date;

    @ManyToOne
    @JoinColumn(name = "person_id")
    protected Person person;

    @ManyToOne
    @JoinColumn(name = "car_id")
    protected Car car;

    @ManyToOne
    @JoinColumn(name = "agreement_type_id")
    protected AgreementType agreementType;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public AgreementType getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(AgreementType agreementType) {
        this.agreementType = agreementType;
    }
}
