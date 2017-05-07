package pl.quider.web.komis.dtos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by adrian on 06.05.17.
 */
public class AgreementDto {
    private BigDecimal amount;
    private String carManufacturer;
    private String carModel;
    private String personName;
    private String personSurname;
    private Date date;
    private Integer id;
    protected String agreementTypeName;

    public AgreementDto() {

    }

    public AgreementDto(Integer id, BigDecimal amount, String carManufacturer, String carModel, String personName, String personSurname, Date date) {
        this.amount = amount;
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.personName = personName;
        this.personSurname = personSurname;
        this.date = date;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAgreementTypeName() {
        return agreementTypeName;
    }

    public void setAgreementTypeName(String agreementTypeName) {
        this.agreementTypeName = agreementTypeName;
    }
}
