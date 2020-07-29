package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAOMybatis;
import board.service.BoardServiceImpl;
import member.bean.MemberDTO;
import member.dao.MemberDAOMybatis;
import member.service.MemberServiceImpl;

@Configuration
public class SpringConfiguration {
	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("c##java");
		basicDataSource.setPassword("bit");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);

		return basicDataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		// sqlSessionFactoryBean.setMapperLocations(new
		// ClassPathResource("member/dao/memberMapper.xml"));
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:*/dao/*Mapper.xml"));

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	@Bean(name = "memberDTO")
	public MemberDTO memberDTO() {
		return new MemberDTO();
	}

	@Bean(name = "memberDAO")
	public MemberDAOMybatis memberDAOMybatis() {
		return new MemberDAOMybatis();
	}

	@Bean(name = "memberService")
	public MemberServiceImpl memberServiceImpl() {
		return new MemberServiceImpl();
	}

	@Bean(name = "boardDTO")
	public BoardDTO boardDTO() {
		return new BoardDTO();
	}

	@Bean(name = "boardDAO")
	public BoardDAOMybatis boardDAOMybatis() {
		return new BoardDAOMybatis();
	}

	@Bean(name = "boardService")
	public BoardServiceImpl boardServiceImpl() {
		return new BoardServiceImpl();
	}
	@Bean(name="boardPaging")
	public BoardPaging boardPaging() {
		return new BoardPaging();
	}

}