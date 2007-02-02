package br.quentinha.service.hibernate;

import org.appfuse.service.impl.GenericManagerImpl;

import br.quentinha.dao.CardapioDao;
import br.quentinha.model.Cardapio;
import br.quentinha.service.CardapioManager;

public class CardapioManagerHibernate extends GenericManagerImpl<Cardapio, Long> implements CardapioManager {

    public CardapioManagerHibernate(CardapioDao dao) {
        super(dao);
    }

}
