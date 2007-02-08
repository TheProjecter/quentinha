package br.quentinha.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;
import org.appfuse.model.User;

public class Pedido extends BaseObject {

    private static final long serialVersionUID = -1904341448293808742L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;
    
    @Temporal(value=TemporalType.DATE)
    private Calendar dia = null;
    private String observacao = null;
    private User user = null;
    
    @OneToMany
    private Collection<Quentinha> quentinhas = new ArrayList<Quentinha>();

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido rhs = (Pedido) object;
        return new EqualsBuilder().append(this.user, rhs.user).append(this.data, rhs.data).append(this.quentinhas, rhs.quentinhas).append(
                this.observacao, rhs.observacao).isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-393634191, 1535427229).append(this.user).append(this.data).append(this.quentinhas).append(
                this.observacao).toHashCode();
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Collection getQuentinhas() {
        return quentinhas;
    }

    protected void setQuentinhas(Collection<Quentinha> quentinhas) {
        this.quentinhas = quentinhas;
    }

    public void addQuentinha(Quentinha quentinha) {
        quentinha.setPedido(this);
        this.quentinhas.add(quentinha);
    }
    
    public boolean removeQuentinha(Quentinha quentinha){
        quentinha.setPedido(null);
        return this.quentinhas.remove(quentinha);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
    }

    public Double calculaPreco() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}