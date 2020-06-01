package servlets;

import logic.ValidateService;
import model.User;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class FirstServlet extends HttpServlet {
    private ValidateService serv = new ValidateService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        serv.findAll().stream().forEach(x -> writer.println(new StringBuilder().append(x.getName()).append("   ").append(x.getLogin()).toString()));
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String name = request.getParameter("name");
            String login = request.getParameter("login");
            User userForAdd = new User();
            userForAdd.setName(name);
            userForAdd.setLogin(login);
            serv.add(userForAdd);
        }
        if (action.equals("update")) {
            if (action.equals("update")) {
                String name = request.getParameter("name");
                String login = request.getParameter("login");
                User userForAdd = new User();
                userForAdd.setName(name);
                userForAdd.setLogin(login);
                serv.update(userForAdd);
            }
        }
        if (action.equals("delete")) {
            if (action.equals("update")) {
                String name = request.getParameter("name");
                String login = request.getParameter("login");
                User userForAdd = new User();
                userForAdd.setName(name);
                userForAdd.setLogin(login);
                serv.delete(userForAdd);
            }
        }
        writer.close();

    }


}

