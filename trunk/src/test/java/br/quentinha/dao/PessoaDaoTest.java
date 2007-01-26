package br.quentinha.dao;

import java.util.Calendar;
import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.springframework.dao.DataAccessException;

import br.quentinha.model.Pessoa;

public class PessoaDaoTest extends BaseDaoTestCase {
    private PessoaDao<Pessoa, Long> pessoaDao = null;

    public void setPessoaDao(PessoaDao<Pessoa, Long> pessoaDao) {
        this.pessoaDao = pessoaDao;
    }

    public void testFindPessoaByNome() throws Exception {
        List<Pessoa> pessoa = pessoaDao.findByNome("Serjao");
        assertTrue(pessoa.size() > 0);
    }
    
    public void testAddAndRemovePerson() throws Exception { 
        Pessoa pessoa = new Pessoa(); 
        pessoa.setNome("Nome"); 
        pessoa.setSobreNome("sobreNome");
        pessoa.setCelular("celular");
        pessoa.setEmail("email");
        pessoa.setNascimento(Calendar.getInstance());
     
        pessoaDao.save(pessoa); 
     
        assertEquals("Nome", pessoa.getNome()); 
        assertNotNull(pessoa.getId()); 
     
        log.debug("removing pessoa..."); 
     
        pessoaDao.remove(pessoa.getId()); 
     
        try { 
            pessoaDao.get(pessoa.getId()); 
            fail("Pessoa found in database"); 
        } catch (DataAccessException dae) { 
            log.debug("Expected exception: " + dae.getMessage()); 
            assertNotNull(dae); 
        } 
    }     
}
