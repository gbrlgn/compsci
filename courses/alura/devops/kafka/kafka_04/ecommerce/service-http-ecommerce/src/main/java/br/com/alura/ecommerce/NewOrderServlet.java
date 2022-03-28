package br.com.alura.ecommerce;

import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderServlet extends HttpServlet {

    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();
    private final KafkaDispatcher<String> emailDispatcher = new KafkaDispatcher<>();

    @Override
    public void destroy() {
        super.destroy();
        orderDispatcher.close();
        emailDispatcher.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        try {
            var email = req.getParameter("email");
            var amount = new BigDecimal(req.getParameter("amount"));
            var orderId = req.getParameter("uuid");
            var order = new Order(orderId, amount, email);

            var database = new OrdersDatabase();
            if (database.saveNew(order)) {
                orderDispatcher.send(
                    "ECOMMERCE_NEW_ORDER", 
                    email, 
                    new CorrelationId(NewOrderServlet.class.getSimpleName()),
                    order
                );
                System.out.println("New order sent successfully.");
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().println("New order sent.");
            } else {
                System.out.println("New order received.");
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().println("Old order received.");
            }
        } catch (InterruptedException | SQLException | ExecutionException e) {
            throw new ServletException(e);
        }
    }
}
