/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.CountryLanguage;
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
        resp.sendRedirect(req.getContextPath() + "/CountryLanguage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Inside CountryLanguageServlet.doPost()");

        String countryCodeParam = req.getParameter("countryCode");
        String countryLanguageParam = req.getParameter("language");
        String isLanguageOfficialParam = req.getParameter("isOfficial");
        String percentageParam = req.getParameter("percentage");

        LOG.info("countryCodeParam: " + countryCodeParam);
        LOG.info("countryLanguageParam: " + countryLanguageParam);
        LOG.info("isLanguageOfficialParam: " + isLanguageOfficialParam);
        LOG.info("percentageParam: " + percentageParam);

        //starting with an empty initialized country language
        CountryLanguage countryLanguage = new CountryLanguage();

        if (countryCodeParam != null && !countryCodeParam.isBlank()) {
            countryLanguage.setCountryCode(countryCodeParam);
        }

        if (countryLanguageParam != null && !countryLanguageParam.isBlank()) {
            countryLanguage.setLanguage(countryLanguageParam);
        }

        if (isLanguageOfficialParam != null && !isLanguageOfficialParam.isBlank()) {
            countryLanguage.setIsOfficial(Boolean.valueOf(isLanguageOfficialParam));
        }

        if (percentageParam != null && !percentageParam.isBlank()) {
            try {
                countryLanguage.setPercentage(Float.valueOf(percentageParam));
            } catch (NumberFormatException e) {
                LOG.warning(String.format("Invalid percentage value: %s", percentageParam));
                countryLanguage.setPercentage(0.0f);
            }

        }
        //ending with a built country language form, but not officially validated
        LOG.info("built country language form: " + countryLanguage.toString());
    }

}
