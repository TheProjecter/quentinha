package br.quentinha.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;

@Entity
public class Cardapio extends BaseObject {
    
    private static final long serialVersionUID = -5773758139127418400L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;
    
    @Temporal(value = TemporalType.DATE)
    private Calendar dia = null;

    @OneToMany()
    @JoinColumn(nullable=true, updatable=false)
    private Collection<ItemCardapio> itemCardapio = new ArrayList<ItemCardapio>();
    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Cardapio)) {
            return false;
        }
        Cardapio rhs = (Cardapio) object;
        return new EqualsBuilder().append(this.dia, rhs.dia).append(this.itemCardapio, rhs.itemCardapio).isEquals();
    }
    
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1611138121, 2078596875).append(this.dia).append(this.itemCardapio).toHashCode();
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
    }
    
    public Calendar getDia() {
        return dia;
    }
    
    public void setDia(Calendar dia) {
        this.dia = dia;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Collection<ItemCardapio> getItemCardapio() {
        return itemCardapio;
    }
    
    protected void setItemCardapio(Collection<ItemCardapio> itemCardapio) {
        this.itemCardapio = itemCardapio;
    }
    
    public void addItem(ItemCardapio item) {
        item.setCardapio(this);
        this.itemCardapio.add(item);
    }
    
    public boolean removeItem(ItemCardapio item){
        item.setCardapio(null);
        return this.itemCardapio.remove(item);
    }
}