package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.sql.*;

@WebServlet("/searchword")
public class MyServlet extends HttpServlet {
    private static final String url = "jdbc:h2:file:/Users/Beth/Lab4/db/Files";
    private static final String user = "Beth";
    private static final String password = "6742";

    private static Connection con;
    private static Statement stmt;
    private static Statement stm;
    private static PreparedStatement deleteTableStm;
    private static PreparedStatement statement;
    //String keyword из строки поиска после нажатия кнопки

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        PrintWriter writer = resp.getWriter();
        String result = new String();
        try {
            result = Main.GetDictionary(keyword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        writer.println(result);
        writer.flush();
    }
}
