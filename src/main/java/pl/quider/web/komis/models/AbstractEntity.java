package pl.quider.web.komis.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adrian on 04.05.17.
 */
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL", nullable = false, insertable = false)
    protected Date added;

    @Column(name = "modified", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL", nullable = false, insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
