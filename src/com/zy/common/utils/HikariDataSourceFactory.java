package com.zy.common.utils;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceFactory extends UnpooledDataSourceFactory {

	public HikariDataSourceFactory() {
		HikariConfig config = new HikariConfig("gameConfig/hikariPool.properties");
		this.dataSource = new HikariDataSource(config);
	}
}
