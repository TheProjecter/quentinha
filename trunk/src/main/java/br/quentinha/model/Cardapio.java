package br.quentinha.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private Calendar data = null;
    private Collection <ItemCardapio> itens = new ArrayList<ItemCardapio>();

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Cardapio)) {
            return false;
        }
        Cardapio rhs = (Cardapio) object;
        return new EqualsBuilder().append(this.data, rhs.data).append(this.itens, rhs.itens).isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1611138121, 2078596875).append(this.data).append(this.itens).toHashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<ItemCardapio> getItens() {
        return itens;
    }

    protected void setItens(Collection<ItemCardapio> itens) {
        this.itens = itens;
    }
    
    public void addItem(ItemCardapio item) {
        item.setCardapio(this);
        this.itens.add(item);
    }
    
    public boolean removeItem(ItemCardapio item){
        item.setCardapio(null);
        return this.itens.remove(item);
    }
}