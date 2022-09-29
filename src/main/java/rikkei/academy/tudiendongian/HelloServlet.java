package rikkei.academy.tudiendongian;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TranslationServlet", value = "/translate")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("hello","xin chào");
        dictionary.put("how","như thế nào");
        dictionary.put("book","sách");
        dictionary.put("computer","máy tính");
        String search = req.getParameter("txtSearch");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if(result != null){
            writer.println(search);
            writer.println(result);
        }else {
            writer.println("not found");
        }

        writer.println("</html>");
    }

    public void destroy() {
    }
}