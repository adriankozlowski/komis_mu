package pl.quider.web.komis.dtos;

import pl.quider.web.komis.models.Fuel;
import pl.quider.web.komis.models.Person;
import pl.quider.web.komis.models.Transmission;

import javax.persistence.*;

/**
 * Created by adrian on 07.05.17.
 */

public class CarDetailsDto {
    protected String vin;
    protected Integer year;
    protected String manufacturer;
    protected String model;
    protected String libilityNumber;
    protected String registrationNumber;
    protected Fuel fuel;
    protected Integer distance;
    protected Integer engine;
    protected Integer power;
    protected Transmission transmission;
    protected String description;
    protected Integer testDrives;
    protected Person owner;
    protected String image;

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

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
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

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
