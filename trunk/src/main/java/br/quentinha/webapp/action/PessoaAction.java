package br.quentinha.webapp.action;

import java.util.List;

import org.appfuse.webapp.action.BaseAction;

import br.quentinha.service.PessoaManager;

public class PessoaAction extends BaseAction {

    private static final long serialVersionUID = 4810970444714916226L;

    private PessoaManager pessoaManager;
    private List pessoas;

    public void setPessoaManager(PessoaManager pessoaManager) {
        this.pessoaManager = pessoaManager;
    }

    public List getPessoas() {
        return pessoas;
    }

    public String list() {
        pessoas = pessoaManager.getAll();
        return SUCCESS;
    }
}
