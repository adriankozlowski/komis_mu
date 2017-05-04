package pl.quider.web.komis.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by adrian on 04.05.17.
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(nullable = false, unique = true, updatable = false)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", table = "users", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", table = "roles", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "person_id")
    protected Person person;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
