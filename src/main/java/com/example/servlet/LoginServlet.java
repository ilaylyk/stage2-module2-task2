package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null)
            resp.sendRedirect("/login.jsp");
        else
            resp.sendRedirect("/user/hello.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isLoginValid = req.getParameter("login") != null && Users.getInstance().getUsers().contains(req.getParameter("login"));
        boolean isPasswordValid = req.getParameter("password") != null && !req.getParameter("password").trim().isEmpty();
        if (isLoginValid && isPasswordValid) {
            req.getSession().setAttribute("user", "user");
            resp.sendRedirect(" /user/hello.jsp");
        } else {
            req.getRequestDispatcher("/login.jsp.*/").forward(req, resp);
        }
    }
}
