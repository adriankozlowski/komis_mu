package pl.quider.web.komis.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adrian on 04.05.17.
 */
@Entity
public class Employee extends Person {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hire_date")
    protected Date hireDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    protected User user;

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
