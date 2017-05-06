package pl.quider.web.komis.dtos;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by adrian on 04.05.17.
 */
public class NewCarFormDto {
    private Integer id;
    @NotNull(message = "Dystans nie może zostać pusty")
    private Integer distance;
    private Integer engince;
    private Integer fuelType;
    private String manufacturer;
    private String model;
    private Integer year;
    private BigDecimal amount;
    private Integer agreementTypeId;
    private String name;
    private String surname;
    private String pesel;
    private String address;

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setEngince(Integer engince) {
        this.engince = engince;
    }

    public Integer getEngince() {
        return engince;
    }

    public void setFuelType(Integer fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getFuelType() {
        return fuelType;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgreementTypeId() {
        return agreementTypeId;
    }

    public void setAgreementTypeId(Integer agreementType) {
        this.agreementTypeId = agreementType;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
