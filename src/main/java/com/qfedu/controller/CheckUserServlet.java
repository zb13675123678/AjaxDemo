package com.qfedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
@WebServlet(name = "CheckUserServlet",urlPatterns = "/checkUserServlet")
public class CheckUserServlet extends HttpServlet {

    /**
     * 模拟用户数据源
     */
    List<String> users = Arrays.asList("suwukong","zhubajie","tangseng","saseng");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username").trim();

        if(users.contains(username)){
            response.getWriter().write("exist");
        }else {
            response.getWriter().write("no exist");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
