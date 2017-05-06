package pl.quider.web.komis.dtos;

import java.util.Date;

/**
 * Created by adrian on 06.05.17.
 */
public class UserDto {
    private Integer id;
    private Date modified;
    private Date added;
    private String username;
    private String email;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getModified() {
        return modified;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getAdded() {
        return added;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
