package org.liuxy.rentcar.dao;

import java.sql.Connection;

public interface Connectable {
	void setConnection(Connection connection);
}
