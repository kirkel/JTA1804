package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dispatcher.AjaxDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "AjaxServlet")
public class AjaxServlet extends HttpServlet {
    private static final long serialVersionUID = -7556002809882084334L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        // Get a reference to the ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Write the POJO as JSON to the response
        response.getWriter().write(mapper.writeValueAsString(AjaxDispatcher.process(request, response)));
    }
}
