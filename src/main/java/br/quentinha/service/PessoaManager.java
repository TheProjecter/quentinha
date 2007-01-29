package br.quentinha.service;

import java.util.List;

import org.appfuse.service.GenericManager;

import br.quentinha.model.Pessoa;

public interface PessoaManager extends GenericManager<Pessoa, Long> {
    public List<Pessoa> findByNome(String nome);
}
