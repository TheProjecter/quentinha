package br.quentinha.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import br.quentinha.model.Pessoa;

public interface PessoaManager<T, PK extends java.io.Serializable> extends GenericManager {
    public List<Pessoa> findByNome(String nome);
}
