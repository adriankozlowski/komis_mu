package pl.quider.web.komis.models;

import javax.persistence.*;

/**
 * Created by adrian on 04.05.17.
 */
@Entity
@Table(name = "persons")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Person extends AbstractEntity{

    @Column
    protected String name;

    @Column
    protected String surname;

    @Column
    protected String address;

    @Column
    protected String nip;

    @Column
    protected String pesel;

    @Column
    protected Integer number;

    @OneToOne
    @JoinColumn(name = "user_id")
    protected User user;

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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
