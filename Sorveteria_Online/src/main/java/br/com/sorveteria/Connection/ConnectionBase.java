package br.com.sorveteria.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBase {

	private static Connection conexao = null;

	public static Connection getConnection() {

		try {
			String sql = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "gabriel";
			String password = "12345";
			Class.forName(sql);

			conexao = DriverManager.getConnection(url, user, password);
			return conexao;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}

}
