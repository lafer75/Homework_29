package com.example.coffee.order;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "Main", value = "/Main")
public class Main extends HttpServlet {

    private static final Logger consoleLogger = Logger.getLogger("consoleLogger");
    private static final Logger fileLogger = Logger.getLogger("fileLogger");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Налаштування логгера для виведення до консолі
            consoleLogger.setUseParentHandlers(false);
            consoleLogger.setLevel(Level.INFO);
            consoleLogger.addHandler(new java.util.logging.ConsoleHandler());

            int numberOrder = 1;
            // Використання логгерів у методі main
            CoffeeOrderBoard board = new CoffeeOrderBoard();
            board.add(new Order("John"));
            consoleLogger.info("New order added");
            fileLogger.info("New order added");
            board.draw();
            consoleLogger.info("Order board drawn");
            fileLogger.info("Order board drawn");
            board.deliver(numberOrder);
            consoleLogger.info("Search order number" + numberOrder);
            fileLogger.info("Search order number" + numberOrder);
            board.deliver();
            consoleLogger.info("Order delivered");
            fileLogger.info("Order delivered");
        }
        catch (Exception e) {
            fileLogger.log(Level.SEVERE, "Exception caught", e);
        }
    }

}

