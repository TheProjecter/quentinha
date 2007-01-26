package br.quentinha.service.hibernate;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;

import br.quentinha.dao.PessoaDao;
import br.quentinha.service.PessoaManager;


public class PessoaManagerHibernate extends GenericManagerImpl implements PessoaManager {
    PessoaDao pessoaDao = null;
    
    public PessoaManagerHibernate(PessoaDao pessoaDao) {
        super(pessoaDao);
    }

    public List findByNome(String nome) {
        return pessoaDao.findByNome(nome);
    }
}
