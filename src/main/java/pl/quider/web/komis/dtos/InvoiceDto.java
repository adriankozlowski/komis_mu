package pl.quider.web.komis.dtos;

import java.math.BigDecimal;

/**
 * Created by adrian on 06.05.17.
 */
public class InvoiceDto {
    private String manufacturer;
    private String model;
    private BigDecimal amount;
    private Integer id;

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
