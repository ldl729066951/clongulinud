package com.castor.configurations;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DSConfiguration extends JpaBaseConfiguration {

	/**
	 * 织入类型配置.
	 */
	public static final String WEAVING = "static";

	/**
	 * DDL配置.
	 */
	public static final String DDL = "create-or-extend-tables";

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	protected DSConfiguration(DataSource dataSource,
							  JpaProperties properties,
							  ObjectProvider<JtaTransactionManager> jtaTransactionManager,
							  ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
		super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
	}

	@Override
	protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
		return new EclipseLinkJpaVendorAdapter();
	}

	@Override
	protected Map<String, Object> getVendorProperties() {
		final Map<String, Object> map = new HashMap<>();
		map.put("eclipselink.weaving", WEAVING);
		map.put("eclipselink.ddl-generation", DDL);
		return map;
	}
}