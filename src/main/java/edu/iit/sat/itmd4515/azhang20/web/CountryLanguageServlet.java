/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author AndrewZ
 */
@WebServlet(name = "", urlPatterns = {"/countrylanguage", "/cl", "/countryl", "/clanguage"})
public class CountryLanguageServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CountryLanguageServlet.class.getName());

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Inside CountryLanguageServlet.doGet()");
        resp.sendRedirect(req.getContextPath() + "CountryLanguage.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Inside CountryLanguageServlet.doPost()");
        
        String countryCodeParam;
        String countryLanguageParam;
        String isLanguageOfficialParam;
        String percentageParam;
    }

    

}
