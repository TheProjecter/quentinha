package br.quentinha.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;

@Entity
public class Prato extends BaseObject {
    
    private static final long serialVersionUID = -7206581289152446521L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id = null;
    private String nome = null;
    private Boolean acompanhamento = null;
    
    @OneToMany()
    @JoinColumn(nullable=true, updatable=false)
    private Collection<ItemCardapio> itensCardapio = new ArrayList<ItemCardapio>();
    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Prato)) {
            return false;
        }
        Prato rhs = (Prato) object;
        return new EqualsBuilder().append(this.nome, rhs.nome).append(this.acompanhamento, rhs.acompanhamento).append(this.itensCardapio,
                rhs.itensCardapio).isEquals();
    }
    
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1155390263, -677330213).append(this.nome).append(this.acompanhamento).append(this.itensCardapio)
        .toHashCode();
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
    }
    
    public Boolean getAcompanhamento() {
        return acompanhamento;
    }
    
    public void setAcompanhamento(Boolean acompanhamento) {
        this.acompanhamento = acompanhamento;
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
    
    public void addItemCardapio(ItemCardapio item){
        item.setPrato(this);
        this.itensCardapio.add(item);
    }
    
    public boolean removeItemCardapio(ItemCardapio item){
        item.setPrato(null);
        return this.itensCardapio.remove(item);
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}