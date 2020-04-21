package com.qfedu.controller;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 */
@WebServlet(name = "SearchServlet", urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {

    private static List<String> datas = Arrays.asList("java", "javascript", "jsp", "aaa", "abc", "bbb");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");

        System.out.println(keyword);
        List<String> list = getResult(keyword);

        Gson gson = new Gson();

        response.getWriter().write(gson.toJson(list));
    }

    /**
     * 根据关键字判断数据源，并返回数据
     */
    private List<String> getResult(String keyword) {
        List<String> list = new ArrayList<>();

        if (keyword == null || keyword.isEmpty()) {
            return list;
        }

        for (String d : datas) {
            if (d.contains(keyword)) {
                list.add(d);
            }
        }

        //Collections.sort(list);

        return list;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
