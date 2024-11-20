package com.servlet;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.Jobs;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "UpdateJobServlet", urlPatterns = {"/update"})
public class UpdateJobServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String category = request.getParameter("category");
			String status = request.getParameter("status");
			String location = request.getParameter("location");
			
			Jobs jobs = new Jobs();
			jobs.setId(id);
			jobs.setTitle(title);
			jobs.setDescription(description);
			jobs.setCategory(category);
			jobs.setStatus(status);
			jobs.setLocation(location);
			
			HttpSession session = request.getSession();
			//updating jobs to db
			JobDAO jobDao = new JobDAO(DBConnect.getConn());
			boolean update = jobDao.updateJob(jobs);
			if(update) {
				System.out.println("job updated");
				session.setAttribute("succMsg", "job updated successfuly");
				response.sendRedirect("view_jobs.jsp");
			} else {
				System.out.println("job not updated");
				session.setAttribute("succMsg", "job not updated. error coming..");
				response.sendRedirect("view_jobs.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }


}
