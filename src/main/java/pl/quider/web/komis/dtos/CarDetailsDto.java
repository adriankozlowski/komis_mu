package pl.quider.web.komis.dtos;

import pl.quider.web.komis.models.Fuel;
import pl.quider.web.komis.models.Person;
import pl.quider.web.komis.models.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by adrian on 07.05.17.
 */

public class CarDetailsDto {
    protected Integer carId;
    protected String vin;
    protected Integer year;
    protected String manufacturer;
    protected String model;
    protected String libilityNumber;
    protected String registrationNumber;
    protected Integer fuelId;
    protected String fuelName;
    protected Integer distance;
    protected Integer engine;
    protected Integer power;
    protected Integer transmissionId;
    protected String transmissionName;
    protected String description;
    protected Integer testDrives;
    protected String  personName;
    protected String  personSurname;
    protected String  personAddress;
    protected String  personNip;
    protected String  personPesel;
    protected Integer personNumber;
    protected String image;
    private BigDecimal amount;
    private Integer agreementTypeId;
    private String agreementTypeName;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public String getLibilityNumber() {
        return libilityNumber;
    }

    public void setLibilityNumber(String libilityNumber) {
        this.libilityNumber = libilityNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getEngine() {
        return engine;
    }

    public void setEngine(Integer engine) {
        this.engine = engine;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTestDrives() {
        return testDrives;
    }

    public void setTestDrives(Integer testDrives) {
        this.testDrives = testDrives;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getFuelId() {
        return fuelId;
    }

    public void setFuelId(Integer fuelId) {
        this.fuelId = fuelId;
    }

    public String getFuelName() {
        return fuelName;
    }

    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
    }

    public Integer getTransmissionId() {
        return transmissionId;
    }

    public void setTransmissionId(Integer transmissionId) {
        this.transmissionId = transmissionId;
    }

    public String getTransmissionName() {
        return transmissionName;
    }

    public void setTransmissionName(String transmissionName) {
        this.transmissionName = transmissionName;
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

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getPersonNip() {
        return personNip;
    }

    public void setPersonNip(String personNip) {
        this.personNip = personNip;
    }

    public String getPersonPesel() {
        return personPesel;
    }

    public void setPersonPesel(String personPesel) {
        this.personPesel = personPesel;
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAgreementTypeId(Integer agreementTypeId) {
        this.agreementTypeId = agreementTypeId;
    }

    public Integer getAgreementTypeId() {
        return agreementTypeId;
    }

    public void setAgreementTypeName(String agreementTypeName) {
        this.agreementTypeName = agreementTypeName;
    }

    public String getAgreementTypeName() {
        return agreementTypeName;
    }
}
