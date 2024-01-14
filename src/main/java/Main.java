import controllers.TerminalController;
import dao.MenuDao;
import dao.OrderDao;
import dao.OrderItemDao;
import services.MenuService;
import services.OrderService;
import utils.DatabaseUtils;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {

        if (DatabaseUtils.testConnection()) {
            System.out.println("Database connection is okay.");
        } else {
            System.out.println("Error: Unable to connect to the database.");
        }

        MenuDao menuDao = new MenuDao();
        OrderDao orderDao = new OrderDao();
        OrderItemDao orderItemDao = new OrderItemDao();

        MenuService menuService = new MenuService(new MenuDao());
        OrderService orderService = new OrderService(orderDao, menuDao, orderItemDao);

        TerminalController terminalController = new TerminalController(menuService, orderService);

        menuService.initMenu();
        terminalController.printMenu();

        terminalController.loadAppInteraction();
    }
}