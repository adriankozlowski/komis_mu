package pl.quider.web.komis.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by adrian on 04.05.17.
 */
@Entity
@Table(name = "invoices")
public class Invoice extends AbstractEntity{
    @OneToOne
    @JoinColumn(name = "agreement_id")
    protected Agreement agreement;

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }
}
