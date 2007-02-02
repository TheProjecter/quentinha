package br.quentinha.model;

import java.util.ArrayList;
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
public class Quentinha extends BaseObject {

    private static final long serialVersionUID = 3750299823682375463L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;
    private Collection<ItemCardapio> itensCardapio = new ArrayList<ItemCardapio>();
    private TipoQuentinha tipoQuentinha = null;
    private Pedido pedido = null;

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Quentinha)) {
            return false;
        }
        Quentinha rhs = (Quentinha) object;
        return new EqualsBuilder().append(this.pedido, rhs.pedido).append(this.tipoQuentinha, rhs.tipoQuentinha).append(this.itensCardapio,
                rhs.itensCardapio).isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(1391992343, 2076851193).append(this.pedido).append(this.tipoQuentinha).append(this.itensCardapio)
                .toHashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<ItemCardapio> getItensCardapio() {
        return itensCardapio;
    }

    protected void setItensCardapio(Collection<ItemCardapio> itensCardapio) {
        this.itensCardapio = itensCardapio;
    }

    public void addItemCardapio(ItemCardapio item) {
        item.getQuentinhas().add(this);
        this.itensCardapio.add(item);
    }

    public boolean removeItemCardapio(ItemCardapio item) {
        return item.getQuentinhas().remove(this) && this.itensCardapio.remove(item);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public TipoQuentinha getTipoQuentinha() {
        return tipoQuentinha;
    }

    public void setTipoQuentinha(TipoQuentinha tipoQuentinha) {
        this.tipoQuentinha = tipoQuentinha;
    }
}