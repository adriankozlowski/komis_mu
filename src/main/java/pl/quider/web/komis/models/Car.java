package pl.quider.web.komis.models;

import javax.persistence.*;

/**
 * Created by adrian on 04.05.17.
 */
@Entity
@Table(name = "cars")
public class Car extends AbstractEntity {
    @Column
    protected String vin;
    @Column
    protected Integer year;
    @Column
    protected String manufacturer;
    @Column
    protected String model;
    @Column
    protected String libilityNumber;
    @Column
    protected String registrationNumber;
    @OneToOne
    @JoinColumn(name = "fuel_id")
    protected Fuel fuel;
    @Column
    protected Integer distance;
    @Column
    protected Integer engine;
    @Column
    protected Integer power;
    @OneToOne
    @JoinColumn(name = "transmission_id")
    protected Transmission transmission;
    @Column
    protected String description;
    @Column
    protected Integer testDrives;
    @ManyToOne
    @JoinColumn(name = "person_id")
    protected Person owner;

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
}
