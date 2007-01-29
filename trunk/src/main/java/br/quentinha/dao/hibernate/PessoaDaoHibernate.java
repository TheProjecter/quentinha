package br.quentinha.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;

import br.quentinha.dao.PessoaDao;
import br.quentinha.model.Pessoa;

public class PessoaDaoHibernate extends GenericDaoHibernate<Pessoa, Long> implements PessoaDao {

    public PessoaDaoHibernate() {
        super(Pessoa.class);
    }

    public List<Pessoa> findByNome(String nome) {
        return getHibernateTemplate().find("from br.quentinha.model.Pessoa where nome=?", nome);
    }
}