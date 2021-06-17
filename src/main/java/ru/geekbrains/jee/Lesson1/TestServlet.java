package ru.geekbrains.jee.Lesson1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;

@WebServlet(name = "TestServlet", urlPatterns = "/show_page")
public class TestServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(TestServlet.class);

    // GET http://localhost:8080/jee/show_page
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: TestServlet" + new GregorianCalendar().getCalendarType());
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        ArrayList< Product > products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String str = "Product"+i;
            float coast = (float) (Math.random()*1000);
            products.add(new Product(i+1,str,coast));
        }

        for (Product product : products) {
            out.println("<html><body><h1>"+ product.info() +"</h1></body></html>");
        }

        out.close();
    }


}
