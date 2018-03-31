package com.ejemplo.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class DBConfiguration {


	public DataSource dataSource() {
		
		DataSourceBuilder dataSource = DataSourceBuilder.create();
		dataSource.url("jdbc:sqlserver://LP-MARIO:1433;instanceName=SQLEXPRESS;databaseName=tienda");
		dataSource.username("sa");
		dataSource.password("root");
		dataSource.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
		
		return dataSource.build();
	}
	
}
