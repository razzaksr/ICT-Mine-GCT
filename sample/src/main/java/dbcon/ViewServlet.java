package dbcon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/cards/show")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        try{
            List<Cards> customers = new CardService().viewAllCards();
//            System.out.println(customers);
            session.setAttribute("customers", customers);
        }catch (Exception e){e.printStackTrace();}
        RequestDispatcher rd = req.getRequestDispatcher("/view.jsp");
        rd.forward(req,resp);
    }
}
