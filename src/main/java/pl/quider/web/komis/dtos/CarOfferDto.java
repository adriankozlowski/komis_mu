package pl.quider.web.komis.dtos;

import java.math.BigDecimal;

/**
 * Created by adrian on 04.05.17.
 */
public class CarOfferDto {
    private Integer distance;
    private Integer engince;
    private String fuelType;
    private String manufacturer;
    private String model;
    private Integer year;
    private BigDecimal amount;
    private Integer id;

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

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelType() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
