package dbcon;

import java.util.List;

public class CardService {
    private CardsDao cardsDao = new CardsDao();
    public void insertCard(Cards card) throws Exception {
        cardsDao.addCard(card);
    }
    public List<Cards> viewAllCards() throws Exception {
        return cardsDao.getAllCards();
    }
}
