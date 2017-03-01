package com.prokarma.health.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.prokarma.health.filter.SecurityFilter;

 

@Configuration
public class ApplicationConfig { 
	 
	
	private String MYSQL_DB_URL = "MYSQL_DB_URL";

	private String MYSQL_DB_USERNAME = "MYSQL_DB_USERNAME";

	private String MYSQL_DB_PASSWORD = "MYSQL_DB_PASSWORD";

	private String DB_PROPS = "db.properties";
	/*@Bean   
	public IPostService postService()
	{
		return new PostServiceImpl();
	}*/
	
	/*@Bean
	public IPostDao postDao( )
	{
		return new PostDao( );
	}*/
	@Bean
	public JdbcTemplate getJdbcTemplate(final DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	

	@Bean
	public MysqlDataSource dataSource() {
		Properties props = new Properties();
		InputStream fis = null;
		MysqlDataSource dataSource = null;
		try {
			fis = getClass().getClassLoader().getResourceAsStream(DB_PROPS);
			props.load(fis);

			dataSource = new MysqlDataSource();

			dataSource.setURL(props.getProperty(MYSQL_DB_URL));
			dataSource.setUser(props.getProperty(MYSQL_DB_USERNAME));
			dataSource.setPassword(props.getProperty(MYSQL_DB_PASSWORD));
		} catch (IOException e) {			
			e.printStackTrace();
		//	logger.error(e.getMessage());
		}
		return dataSource;
		}
		
	
	/*@Bean
	public DataSource dataSource()
	{
		System.out.println("ApplicationConfig.dataSource() Nitin ");
		EmbeddedDatabaseBuilder edbb = new  EmbeddedDatabaseBuilder();
		EmbeddedDatabase edb = edbb.setType(EmbeddedDatabaseType.H2).addScript("create-db.sql").addScript("insert-data.sql").build();
		return edb;
	}*/
	
	 @Bean
	    public FilterRegistrationBean helloFilterRegistrationBean() {
	        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	        registrationBean.setName("hello");
	        SecurityFilter helloFilter = new SecurityFilter();
	        registrationBean.setFilter(helloFilter);
	        registrationBean.setOrder(1);
	        return registrationBean;
	    }

	
}
