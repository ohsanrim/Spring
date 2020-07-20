package user.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import user.bean.UserDTO;
import user.dao.UserDAOMybatis;
import user.main.HelloSpring;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;

@Configuration
public class SpringConfiguration {


	  @Bean(name="dataSource") 
	  public BasicDataSource dataSource() {
		  BasicDataSource basicDataSource = new BasicDataSource();
		  basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		  basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		  basicDataSource.setUsername("c##java"); basicDataSource.setPassword("bit");
		  basicDataSource.setMaxTotal(20); basicDataSource.setMaxIdle(3); return
		  basicDataSource; 
	  }

	   @Bean(name="sqlSessionFactory")
	   public SqlSessionFactory getSqlSessionFactory() throws Exception {
	      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	      sqlSessionFactoryBean.setDataSource(dataSource());
	      
	      // PathMatchingResourcePatternResolver resource = new  PathMatchingResourcePatternResolver();
	      sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("spring/mybatis-config.xml"));
	      sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("user/dao/userMapper.xml"));
	      return sqlSessionFactoryBean.getObject();
	   }
	
	   @Bean(name="sqlSession")
	   public SqlSessionTemplate getsqlSessionTemplate() throws Exception {
	      return new SqlSessionTemplate(getSqlSessionFactory()); 
	   }

	   @Bean(name="transactionManager")
	   public DataSourceTransactionManager transactionManager() {
		   DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		   transactionManager.setDataSource(dataSource());
		   return transactionManager;
	   }
	   
	   @Bean(name="userInsertService")
	   public UserInsertService userInsertService() {
		   return new UserInsertService();
	   }
	   
	   @Bean(name="userSelectService")
	   public UserSelectService UserSelectService() {
		   return new UserSelectService();
	   }
	   
	   @Bean(name="userUpdateService")
	   public UserUpdateService userUpdateService() {
		   return new UserUpdateService();
	   }
	   
	   @Bean(name="userDeleteService")
	   public UserDeleteService userDeleteService() {
		   return new UserDeleteService();
	   }
		 //
	   @Bean(name="userDTO")
	   public UserDTO userDTO() {
		   return new UserDTO();
	   }
	   //
	   @Bean(name="jdbcTemplate")
	   public JdbcTemplate jdbcTemplate() {
		   return new JdbcTemplate(dataSource());
	   }
	   @Bean(name="helloSpring")
	   public HelloSpring helloSpring() {
		   return new HelloSpring();
	   }
	   //
	   @Bean(name="userDAOMybatis")
	   public UserDAOMybatis userDAOMybatis() {
		   UserDAOMybatis userDAOMybatis = new UserDAOMybatis();
		   return userDAOMybatis;
	   }
}
