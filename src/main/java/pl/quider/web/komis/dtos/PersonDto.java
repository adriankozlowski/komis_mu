package pl.quider.web.komis.dtos;

/**
 * Created by adrian on 06.05.17.
 */
public class PersonDto {
    String surname;
    String name; String pesel;
    Integer id;

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
}
