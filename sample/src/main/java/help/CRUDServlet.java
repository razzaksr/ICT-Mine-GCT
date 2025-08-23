package help;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/crud")
public class CRUDServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    private List<Card> getList(HttpServletRequest req) {
        List<Card> customers = (List<Card>) getServletContext().getAttribute("customers");
        System.out.println("customers size: " + customers.size());
        return customers;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Card> customers = getList(req);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        // req.setAttribute("customers", customers); // request scope
        HttpSession session = req.getSession();
        session.setAttribute("customers", customers); // session scope
//        Cookie[] cookies = req.getCookies();
        Cookie cookie = new Cookie("ict", req.getParameter("http://www.ictacademy.com"));
        resp.addCookie(cookie);
        dispatcher.forward(req, resp);
//        resp.setContentType("text/plain");
//        resp.getWriter().println("List about to display");
//        for (int i = 0; i < customers.size(); i++) {
//            resp.getWriter().println(i + ": " + customers.get(i));
//        }
    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String item = req.getParameter("item");
//        if (item != null && !item.isEmpty()) {
//            getList(req).add(item);
//            resp.getWriter().println("Added: " + item);
//        } else {
//            resp.getWriter().println("Item cannot be empty.");
//        }
//    }
//
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        int index = Integer.parseInt(req.getParameter("index"));
//        String newItem = req.getParameter("item");
//        List<String> customers = getList(req);
//        if (index >= 0 && index < customers.size()) {
//            customers.set(index, newItem);
//            resp.getWriter().println("Updated index " + index + " to: " + newItem);
//        } else {
//            resp.getWriter().println("Invalid index.");
//        }
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        int index = Integer.parseInt(req.getParameter("index"));
//        List<String> customers = getList(req);
//        if (index >= 0 && index < customers.size()) {
//            String removed = customers.remove(index);
//            resp.getWriter().println("Deleted: " + removed);
//        } else {
//            resp.getWriter().println("Invalid index.");
//        }
//    }
}
