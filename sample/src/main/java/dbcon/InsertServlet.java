package dbcon;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/cards/create")
@MultipartConfig
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cards card = new Cards();
        card.setCardHolder(request.getParameter("cardHolder"));
        card.setCardNumber(Long.parseLong(request.getParameter("cardNumber")));
        card.setCardBalance(Double.parseDouble(request.getParameter("cardBalance")));
        Part filePart = request.getPart("pan");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uploadPath = "E:/MyUploads";
        System.out.println(uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        card.setPan("uploads/" + fileName);

        try {
//            new CardService().insertCard(card);
            new CardsORM().addCard(card);
            response.sendRedirect(getServletContext().getContextPath() + "/cards/show");
        } catch (Exception e) {
            throw new ServletException("Upload failed", e);
        }
    }
}
