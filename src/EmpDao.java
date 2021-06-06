import java.util.*;
import java.sql.*;


public class EmpDao {
	


	public static Connection getConnection()
	{
		
		Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erp","root","Kenit@2000");
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return con;
	}
	
	
	public static int insert(Emp e) {
		int status=0;
		
		try {
			
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into register(name,country,gender,phone,password) values(?,?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2, e.getCountry());
			ps.setString(3, e.getGender());
			ps.setString(4, e.getphone());
			ps.setString(5, e.getPassword());
			
			status = ps.executeUpdate();
			
			con.close();
		}
		
		catch(Exception ex) {
			
			System.out.print(ex);
		
		}
		return status;
	}
	
	public static ArrayList<Emp> getAllEmployees(){
		ArrayList<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from register");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setCountry(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setPhone(rs.getString(5));
				e.setPassword(rs.getString(6));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
		
	public static int delete(int id)
	{
		
		int status=0;
		
		try {
			
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from register where id=?");
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
			con.close();
			}
		
		catch(Exception ex)
		{
			
			System.out.print(ex);
		
		}
		return status;
		
	}
	
	public static int update(Emp e) {
		int status=0;
		
		try {
			
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update register set name=?, Country=?, gender=?, phone=?, password=? where id=?");
			ps.setString(1,e.getName());
			ps.setString(2, e.getCountry());
			ps.setString(3, e.getGender());
			ps.setString(4, e.getphone());
			ps.setString(5, e.getPassword());
			ps.setInt(6, e.getid());
			
			status = ps.executeUpdate();
			
			con.close();
		}
		
		catch(Exception ex) {
			
			System.out.print(ex);
		
		}
		return status;
	
	}

	public static Emp getEmployeeById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from register where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setCountry(rs.getString(3));
				e.setGender(rs.getString(4));
				e.setPhone(rs.getString(5));
				e.setPassword(rs.getString(6));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}

}
