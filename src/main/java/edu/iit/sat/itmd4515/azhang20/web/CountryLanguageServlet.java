/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.azhang20.web;

import edu.iit.sat.itmd4515.azhang20.domain.CountryLanguage;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author AndrewZ
 */
@WebServlet(name = "", urlPatterns = {"/countrylanguage", "/cl", "/countryl", "/clanguage"})
public class CountryLanguageServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CountryLanguageServlet.class.getName());

    @Resource
    Validator validator;

    @Resource(name = "java:app/jdbc/itmd4515DS")
    DataSource ds;

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

        Set<ConstraintViolation<CountryLanguage>> violations = validator.validate(countryLanguage);

        if (violations.size() > 0) {
            //FAILED VALIDATION
            LOG.info("Country Language form has failed validation");
            for (ConstraintViolation<CountryLanguage> violation : violations) {
                LOG.info(violation.getPropertyPath() + " " + violation.getMessage());
            }

            req.setAttribute("countryLanguage", countryLanguage);
            req.setAttribute("violations", violations);

            RequestDispatcher rd = req.getRequestDispatcher("CountryLanguage.jsp");
            rd.forward(req, resp);

        } else {
            //PASSED VALIDATION
            LOG.info("Country Language form has passed validation");

            createCountryLanguage(countryLanguage);

            req.setAttribute("countryLanguage", countryLanguage);

            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/conf.jsp");
            rd.forward(req, resp);
        }
    }

    private void createCountryLanguage(CountryLanguage countryLanguage) {
        String insertCountryLanguage = "INSERT INTO countrylanguage (CountryCode, Language, IsOfficial, Percentage) VALUES (?, ?, ?, ?)";

        try (
                Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(insertCountryLanguage)) {
            ps.setString(1, countryLanguage.getCountryCode());
            ps.setString(2, countryLanguage.getLanguage());

            // Convert boolean to 'T' or 'F' to match the database column type
            ps.setString(3, countryLanguage.getIsOfficial() ? "T" : "F");

            ps.setFloat(4, countryLanguage.getPercentage());

            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

}
