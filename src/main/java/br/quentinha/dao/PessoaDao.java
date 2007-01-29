package br.quentinha.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;

import br.quentinha.model.Pessoa;

public interface PessoaDao extends GenericDao<Pessoa, Long> {
    public List<Pessoa> findByNome(String lastName);
}
