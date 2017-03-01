package com.prokarma.health.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;



import com.prokarma.health.dao.BaseDao;
import com.prokarma.health.dao.IPKHealthDao;
import com.prokarma.health.domain.LoginUser;

 
 
@Repository
public class PKHealthDao  extends BaseDao implements IPKHealthDao{


	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public PKHealthDao( )
	{
		System.out.println("PostDao.PostDao()");
	}
	 
	
	public List<LoginUser> findAll(){
		System.out.println("PostDao.findAll()");
		String sql = "SELECT * FROM pk_user";

		List<LoginUser> loginUsers = new ArrayList<LoginUser>();

		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map row : rows) {
			LoginUser loginUser = new LoginUser();
			loginUser.setId((int) row.get("oid"));
			loginUser.setUserId((String) row.get("UserId"));
			loginUser.setPassword((String) row.get("Password"));
			loginUser.setUserType((String) row.get("UserType"));
			loginUsers.add(loginUser);
		}
		
		for (LoginUser lu : loginUsers) {
			System.out.println(lu.getId()+" : "+lu.getUserId()+" , "+lu.getPassword());
		}

		
		return loginUsers;
	}
	
	public  LoginUser  findByUserId(String userId){
		System.out.println("findByUserId");
		String sql = "SELECT * FROM pk_user where userid = ?";
		LoginUser loginUser = null;
		

 
		System.out.println(sql);
try
{
		loginUser = (LoginUser)getJdbcTemplate().queryForObject(
				sql, new Object[] { userId }, new RowMapper<LoginUser>() {
					public LoginUser mapRow(ResultSet rs, int rowNum) throws SQLException {
						System.out.println("PostRowMapper.mapRow()");
						LoginUser loginUser = new LoginUser();
						loginUser.setId(rs.getInt("oid"));
						loginUser.setUserId( rs.getString("UserId"));
						loginUser.setPassword( rs.getString("Password"));
						loginUser.setUserType(rs.getString("UserType"));
						loginUser.setValidicUserAccessToken(rs.getString("validic_access_token"));
						loginUser.setValidicUserId(rs.getString("validic_uid"));
						//loginUser.setOrganizationId(rs.getInt("org_oid"));
						return loginUser;
					}
				});
}catch(Exception e)
{
	
}
		return loginUser;
		 
	}


	@Override
	public void saveValidicUserDetails(LoginUser loginUser) {
		
		 
		  String updateStatement = " UPDATE pk_user"
		                         + " SET validic_uid=?, validic_access_token=?"
		                         + " WHERE UserId=?";
		  this.getJdbcTemplate().update(updateStatement, new Object[] {loginUser.getValidicUserId(), loginUser.getValidicUserAccessToken(),loginUser.getUserId()});
		 
		
	}
	
	 
	
 
	
	   

}
