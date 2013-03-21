package com.commerce;

import java.text.SimpleDateFormat;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath:test-applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ActiveProfiles("test")
public class SpringTestContext extends
		AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private SqlSession sqlSession;
	private static SimpleDateFormat requestDateTimeFormatter = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss.SSS");

	public TestMapper testMapper() {
		return sqlSession.getMapper(TestMapper.class);
	}

	public void createNewItem(String styleColorNumber, String desc,
			String colr, String style, int price) {
		testMapper().insertItem(styleColorNumber, desc, colr, style, price);
	}
}