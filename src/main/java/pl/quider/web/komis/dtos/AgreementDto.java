package pl.quider.web.komis.dtos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by adrian on 06.05.17.
 */
public class AgreementDto {
    private BigDecimal amount;
    private String manufacturer;
    private String model; String name;
    private String surname;
    private Date date;
    private Integer id;

    public AgreementDto() {

    }

    public AgreementDto(Integer id, BigDecimal amount, String manufacturer, String model, String name, String surname, Date date) {
        this.amount = amount;
        this.manufacturer = manufacturer;
        this.model = model;
        this.name = name;
        this.surname = surname;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
