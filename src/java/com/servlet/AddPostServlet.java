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


@WebServlet(name = "AddPostServlet", urlPatterns = {"/add_Job"})
public class AddPostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String title = request.getParameter("title");
            String location = request.getParameter("location");
            String category = request.getParameter("category");
            String status = request.getParameter("status");
            String desc = request.getParameter("desc");
            
            Jobs j = new Jobs();
            j.setTitle(title);
            j.setLocation(location);
            j.setCategory(category);
            j.setStatus(status);
            j.setDescription(desc);
            
            HttpSession session = request.getSession();
            JobDAO dao = new JobDAO(DBConnect.getConn());
            boolean f = dao.addJobs(j);
            if(f) {
                session.setAttribute("succMsg", "Job Post Successful...");
                response.sendRedirect("add_job.jsp");
            } else {
                session.setAttribute("succMsg", "Something Wrong on server");
                response.sendRedirect("add_job.jsp");
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
