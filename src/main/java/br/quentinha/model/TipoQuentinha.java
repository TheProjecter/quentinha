package br.quentinha.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;

@Entity
public class TipoQuentinha extends BaseObject {

    private static final long serialVersionUID = -1881244526162264352L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id = null;
    private TamanhoQuentinha tamanho = null;
    private Double preco = null;
    private Boolean ativo = null;
    private String descricao = null;
    
    @OneToMany
    @JoinColumn(nullable=true, updatable=false)
    private Collection<Quentinha> quentinhas = new ArrayList<Quentinha>();

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof TipoQuentinha)) {
            return false;
        }
        TipoQuentinha rhs = (TipoQuentinha) object;
        return new EqualsBuilder().append(this.tamanho, rhs.tamanho).append(this.ativo, rhs.ativo).append(this.descricao, rhs.descricao)
                .append(this.quentinhas, rhs.quentinhas).append(this.preco, rhs.preco).isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-1656718541, 1321431629).append(this.tamanho).append(this.ativo).append(
                this.descricao).append(this.quentinhas).append(this.preco).toHashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Collection<Quentinha> getQuentinhas() {
        return quentinhas;
    }

    protected void setQuentinhas(Collection<Quentinha> quentinhas) {
        this.quentinhas = quentinhas;
    }

    public TamanhoQuentinha getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoQuentinha tamanho) {
        this.tamanho = tamanho;
    }
    
    public void addQuentinha(Quentinha quentinha){
        quentinha.setTipoQuentinha(this);
        this.quentinhas.add(quentinha);
    }
}