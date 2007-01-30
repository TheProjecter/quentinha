package br.quentinha.webapp.action;

import org.appfuse.webapp.action.BaseActionTestCase;

import br.quentinha.model.Pessoa;
import br.quentinha.service.PessoaManager;
import br.quentinha.webapp.action.PessoaAction;

import com.opensymphony.xwork2.ActionSupport;
 
public class PessoaActionTest extends BaseActionTestCase { 
    private PessoaAction action; 
 
    public void setPersonAction(PessoaAction action) { 
        this.action = action; 
    } 
    @Override 
    protected void onSetUpBeforeTransaction() throws Exception { 
        super.onSetUpBeforeTransaction(); 
        PessoaManager pessoaManager = (PessoaManager) applicationContext.getBean("pessoaManager"); 
 
        // add a test person to the database 
        Pessoa pessoa = new Pessoa(); 
        pessoa.setNome("Jack"); 
        pessoa.setSobreNome("Raible"); 
        pessoaManager.save(pessoa); 
    } 
 
    public void testSearch() throws Exception { 
        assertEquals(action.list(), ActionSupport.SUCCESS); 
        assertTrue(action.getPessoas().size() >= 1); 
    } 
} 