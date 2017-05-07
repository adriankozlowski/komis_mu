package pl.quider.web.komis.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by adrian on 06.05.17.
 */
public class PersonDto {
    @NotNull(message = "Nazwisko jest wymagane")
    @Length(min=3, message = "Nazwisko musi mieć co najmniej 3 znaki")
    protected String surname;
    @NotNull(message = "Imię jest wymagane")
    @Length(min=3, message = "Imie musi mieć co najmniej 3 znaki")
    protected String name;
    @NotNull(message = "PESEL jest wymagany")
    protected String pesel;
    protected Integer id;
    protected String address;
    protected String nip;
    protected Integer number;

    public PersonDto(String surname, String name, String pesel, Integer id) {
        this.surname = surname;
        this.name = name;
        this.pesel = pesel;
        this.id = id;
    }

    public PersonDto() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
