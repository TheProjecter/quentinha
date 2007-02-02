package br.quentinha.dao.hibernate;

import org.appfuse.dao.hibernate.GenericDaoHibernate;

import br.quentinha.dao.CardapioDao;
import br.quentinha.model.Cardapio;

public class CardapioDaoHibernate  extends GenericDaoHibernate<Cardapio, Long> implements CardapioDao {

    public CardapioDaoHibernate() {
        super(Cardapio.class);
    }
    
}
