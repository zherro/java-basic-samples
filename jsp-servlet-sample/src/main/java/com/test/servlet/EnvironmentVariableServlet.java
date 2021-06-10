package com.test.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Properties;

public class EnvironmentVariableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EnvironmentVariableServlet() {
        super();
        System.out.println("EnvironmentVariableServlet constructor called");
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("EnvironmentVariableServlet \"Init\" method called");
    }

    public void destroy() {
        System.out.println("EnvironmentVariableServlet \"Destroy\" method called");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Username and email id is retrived from the session");
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        String testEnv = System.getenv("TEST_ENV");
        out.write("<html><body><h1>This is the environment variable: " + testEnv + "</h1></body></html>");

        String catalinaConfigDirectory = System.getenv("CATALINA_HOME") + "/conf/";
        File catalinaProperties = new File(catalinaConfigDirectory,"catalina.properties");
        InputStream stream = new FileInputStream(catalinaProperties);
        Properties props = new Properties();
        props.load(stream);

        //This can be any key-value pair in the properties file
        String catProp = props.getProperty("common.loader");
        out.write("<html><body><h1>This is a property from catalina.properties: " + catProp + "</h1></body></html>");


    }
}
