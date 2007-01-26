package br.quentinha.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.appfuse.model.BaseObject;

@Entity
@SequenceGenerator(name=Pessoa.PESSOA_SEQ, sequenceName=Pessoa.PESSOA_SEQ, initialValue=1000)
public class Pessoa extends BaseObject {
    
    private static final long serialVersionUID = -5516199305790397008L;
    public static final String PESSOA_SEQ = "PESSOA_SEQ";

    @Id @GeneratedValue(generator=PESSOA_SEQ, strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String sobreNome;
    private String celular;
    private Calendar nascimento;
    private String email;
    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa rhs = (Pessoa) object;
        return new EqualsBuilder().append(this.nome, rhs.nome).append(this.celular, rhs.celular).append(this.sobreNome, rhs.sobreNome)
                .append(this.email, rhs.email).append(this.nascimento, rhs.nascimento).isEquals();
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-281774169, 1743810383).append(this.nome).append(this.celular).append(
                this.sobreNome).append(this.email).append(this.nascimento).append(this.id).toHashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
    }

}
