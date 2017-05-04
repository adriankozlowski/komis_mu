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

}
