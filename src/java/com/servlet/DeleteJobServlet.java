/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.DB.DBConnect;
import com.dao.JobDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Shivam
 */
@WebServlet(name = "DeleteJobServlet", urlPatterns = {"/delete"})
public class DeleteJobServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			int id= Integer.parseInt(request.getParameter("id"));
			
			HttpSession session = request.getSession();
			//updating jobs to db
			JobDAO jobDao = new JobDAO(DBConnect.getConn());
			boolean delete = jobDao.deleteJob(id);
			if(delete) {
				System.out.println("job deleted");
				session.setAttribute("succMsg", "job deleted successfuly");
				response.sendRedirect("view_jobs.jsp");
			} else {
				System.out.println("job not deleted");
				session.setAttribute("succMsg", "job not deleted. error coming..");
				response.sendRedirect("view_jobs.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
