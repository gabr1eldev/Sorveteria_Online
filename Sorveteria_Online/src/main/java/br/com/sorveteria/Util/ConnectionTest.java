package br.com.sorveteria.Util;

import java.sql.Connection;

import br.com.sorveteria.Connection.ConnectionBase;

public class ConnectionTest {
	
	public static void main(String[] args) {
		Connection conexao = ConnectionBase.getConnection();
		System.out.println(conexao);
	}

}
