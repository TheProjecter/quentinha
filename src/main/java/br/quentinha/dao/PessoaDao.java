package br.quentinha.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;

import br.quentinha.model.Pessoa;

public interface PessoaDao<Pessoa, Long> extends GenericDao {
    public List findByNome(String lastName);
}
