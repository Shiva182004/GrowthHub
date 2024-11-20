package com.dao;
import com.entity.Jobs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class JobDAO {
    private Connection conn;
    
    public JobDAO(Connection conn){
        super();
        this.conn = conn;
    }
        
    public boolean addJobs (Jobs j){
        boolean f=false;
        try {
            String sql = "insert into jobs (title,description,category,status,location) values(?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);
            
            ps.setString(1, j.getTitle());
            ps.setString(2, j.getDescription());
            ps.setString(3, j.getCategory());
            ps.setString(4, j.getStatus());
            ps.setString(5, j.getLocation());
            
            int i = ps.executeUpdate();
            
            if(i==1) {
                f=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
        }
    
    public List<Jobs> getAllJobs() {
		List<Jobs> List = new ArrayList<Jobs>();		
		Jobs j= null;
		
		try {
			String sql= "select * from jobs order by id desc";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(sql);
			while (rs.next()) {
				j = new Jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6)); 
				j.setPdate(rs.getTimestamp(7)+"");
				List.add(j);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return List;
	}
	
	public Jobs getJobByID(int id) {				
		Jobs job= null;		
		try {
			String sql = "SELECT * FROM jobs WHERE id = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setInt(1, id); // Set the parameter value for `id`
                        ResultSet rs = ps.executeQuery(); // Execute the query without passing the SQL string

			while (rs.next()) {
				job= new Jobs();
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setDescription(rs.getString(3));
				job.setCategory(rs.getString(4));
				job.setStatus(rs.getString(5));
				job.setLocation(rs.getString(6)); 
				job.setPdate(rs.getTimestamp(7)+"");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return job;
	}
	
	public boolean updateJob(Jobs j) {
		boolean f=false;
		try {
			String sql = "update jobs set title=?,description=?,category=?,status=?,location=? where id=?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			ps.setInt(6, j.getId());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteJob(Integer id) {
		boolean f=false;
		try {
			String sql = "delete from jobs where id=?";
			PreparedStatement ps =conn.prepareStatement(sql);			
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
