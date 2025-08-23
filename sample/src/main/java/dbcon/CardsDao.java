package dbcon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CardsDao {
    public void addCard(Cards card) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into cards values(?,?,?,?)");
        ps.setString(1, card.getCardHolder());
        ps.setLong(2, card.getCardNumber());
        ps.setDouble(3, card.getCardBalance());
        ps.setString(4, card.getPan());
        int count = ps.executeUpdate();
        if (count > 0)
            System.out.println("Card added successfully!");
        else
            System.out.println("Failed to insert card!");
        connection.close();
    }
    public List<Cards> getAllCards() throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from cards");
        ResultSet rs = ps.executeQuery();
        List<Cards> list = new ArrayList<>();
        while (rs.next()) {
            Cards card = new Cards();
            card.setCardHolder(rs.getString("card_holder"));
            card.setCardNumber(rs.getLong("card_number"));
            card.setCardBalance(rs.getDouble("card_balance"));
            card.setPan(rs.getString("pan"));
            list.add(card);
        }
        connection.close();
        return list;
    }
}
