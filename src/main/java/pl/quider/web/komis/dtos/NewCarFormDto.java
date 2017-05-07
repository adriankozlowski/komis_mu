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
    @NotNull(message = "Pojemność silnika nie może być pusty")
    private BigDecimal engine;
    private Integer fuelType;
    @NotNull(message = "Producent musi być wypełniony")
    private String manufacturer;
    @NotNull(message = "Musisz wpisać model")
    private String model;
    private Integer transmission;
    @NotNull(message = "Rok produkcji musi być wpisany")
    private Integer year;
    @NotNull(message = "Wpisz proponowaną cenę")
    private BigDecimal amount;
    private Integer agreementTypeId;
    @NotNull(message = "Imię nie może być puste")
    private String name;
    @NotNull(message = "Nazwisko nie może być puste")
    private String surname;
    @NotNull(message = "PESEL jest wymagany")
    private String pesel;
    @NotNull(message = "Adres jest wymagany")
    private String address;

    public Integer getTransmission() {
        return transmission;
    }

    public void setTransmission(Integer transmission) {
        this.transmission = transmission;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setEngine(BigDecimal engine) {
        this.engine = engine;
    }

    public BigDecimal getEngine() {
        return engine;
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
