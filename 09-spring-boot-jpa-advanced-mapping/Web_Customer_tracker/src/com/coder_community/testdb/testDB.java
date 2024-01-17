package com.coder_community.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/testDB")
public class testDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set up variable
		PrintWriter out = response.getWriter();

		String username = "springstudent";

		String password = "springstudent";

		String jdbcurl = "jdbc:mysql://localhost:3306/web_customer_tracker";

		String driver = "com.mysql.cj.jdbc.Driver";

		// get the connection

		try {

			out.println("Connecting to database " + jdbcurl);

			Class.forName(driver);

			Connection conn = DriverManager.getConnection(jdbcurl, username, password);

			out.println("Success !!!");
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}

	}

}
