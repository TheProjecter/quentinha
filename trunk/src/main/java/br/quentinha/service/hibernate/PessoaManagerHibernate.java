package br.quentinha.service.hibernate;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;

import br.quentinha.dao.PessoaDao;
import br.quentinha.model.Pessoa;
import br.quentinha.service.PessoaManager;

public class PessoaManagerHibernate extends GenericManagerImpl<Pessoa, Long> implements PessoaManager {
    PessoaDao pessoaDao = null;

    public PessoaManagerHibernate(PessoaDao pessoaDao) {
        super(pessoaDao);
    }

    public List<Pessoa> findByNome(String nome) {
        return pessoaDao.findByNome(nome);
    }
}
