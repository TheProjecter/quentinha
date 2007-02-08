package br.quentinha.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.appfuse.model.BaseObject;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
public class ItemCardapio extends BaseObject {

    private static final long serialVersionUID = -7283707181330193703L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;
    private Prato prato = null;
    private Cardapio cardapio = null;
    
    @ManyToMany()
    @JoinColumn(nullable=true, updatable=false)
    private Collection<Quentinha> quentinhas = new ArrayList<Quentinha>();

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof ItemCardapio)) {
            return false;
        }
        ItemCardapio rhs = (ItemCardapio) object;
        return new EqualsBuilder().append(this.prato, rhs.prato).append(this.quentinhas, rhs.quentinhas)
                .append(this.cardapio, rhs.cardapio).isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(359437367, 1743521683).append(this.prato).append(this.quentinhas).append(this.cardapio).toHashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public Collection<Quentinha> getQuentinhas() {
        return quentinhas;
    }

    protected void setQuentinhas(Collection<Quentinha> quentinhas) {
        this.quentinhas = quentinhas;
    }

    public void addQuentinha(Quentinha quentinha) {
        quentinha.addItemCardapio(this);
    }

    public boolean removeQuentinha(Quentinha quentinha) {
        return quentinha.removeItemCardapio(this);
    }
}