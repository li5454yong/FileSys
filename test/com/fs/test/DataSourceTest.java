package com.fs.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxg
 *
 * 2015年12月7日下午8:36:27
 */
public class DataSourceTest {
	@SuppressWarnings("resource")
	@Test
	public void demo() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource ds = (DataSource) applicationContext.getBean("dataSource");
		System.out.println(ds);
	}
}
