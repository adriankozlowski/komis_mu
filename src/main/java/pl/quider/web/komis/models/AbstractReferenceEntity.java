package pl.quider.web.komis.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by adrian on 04.05.17.
 */
@MappedSuperclass
public abstract class AbstractReferenceEntity extends AbstractEntity {

    @Column(columnDefinition = "tinyint default 0")
    protected boolean removed;

    @Column
    protected String name;

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
