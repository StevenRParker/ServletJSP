package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import casestudy1.Student;

/**
 * Servlet implementation class QueryStudents
 */
@WebServlet(description= "Intorrogate the Student database", urlPatterns = {"/QueryStudents"})
public class QueryStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String sql = "SELECT STUDENT_ID, NAME, SUBJECT, SCORE FROM STUDENT_DETAIL";
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_05c37232add5cca";
	
	static final String USER = "b077599f12415c";
	static final String PASS = "3058f590";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> students= new ArrayList<String>();
		try{
			//step 2: register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Step 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected to database...");
			
			 //STEP 4: Execute a query
			stmt = conn.createStatement();
		}catch (ClassNotFoundException | SQLException e){
			throw new ServletException("Could not connect to Students database", e);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String student_id  = rs.getString("STUDENT_ID");
				String name = rs.getString("NAME");
		        String subject = rs.getString("SUBJECT");
		        int score = rs.getInt("SCORE");
		        students.add(student_id + name + subject + score);
			}
		}catch  (SQLException e) {
			throw new ServletException("Could not read data from Classmates database", e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException e) {
					throw new ServletException("Could not close result set", e);
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new ServletException("Could not close statement", e);
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch(SQLException e) {
					throw new ServletException("Could not close statement", e);
				}
			}
		}
		request.setAttribute("ListOfStudents", students);
		RequestDispatcher d = request.getRequestDispatcher("/Students.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
