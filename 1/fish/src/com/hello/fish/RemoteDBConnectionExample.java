package com.hello.fish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;


public class RemoteDBConnectionExample {
	
	//local
	public static final String PEM_FILE_LOCATION = "/home/test/Documents/amazon_instance_login_rs/rs-ec2-dev-key.pem"; //1
	
	//ec2 - server
	public static final String SSH_USER = "ubuntu"; //2 // SSH loging username
	public static final String SSH_HOST = "93.184.216.34"; //3 hostname or ip of SSH server
	public static final int SSH_PORT  = 22; //4 remote SSH host port number
	public static final String SSH_PASSWORD = "SomePassword";//5 // SSH login password
	
	//db-server-creds.
	public static final String DB_HOST = "db-exmaple.d90dn789dn7z.eu-north-1.rds.amazonaws.com"; //6 // hostname or ip of your database server
	public static final String DB_USERNAME  = "exampleUser"; //7 // database loging username
	public static final String DB_PASSWORD = "SomePassword"; //8 // database login password
	public static final String DB_DEFAULT_SCHEMA = "student"; //9
	public static final int DB_PORT = 3306; //10 // remote port number of your database
	
	public static final int LOCAL_PORT = 3366; // local port number used to bind SSH tunnel
	
	
	private static void doSshTunnel(String strSshUser, String strSshPassword, String strSshHost, int nSshPort,
			String strRemoteHost, int nLocalPort, int nRemotePort) throws JSchException {
		final JSch jsch = new JSch();
		
		jsch.addIdentity(PEM_FILE_LOCATION);
		
		Session session = jsch.getSession(strSshUser, strSshHost, 22);

		// session.setPassword(SSH_PASSWORD);

		final Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);

		session.connect();
		session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
	}
	
	public static void main(String[] args) {
		try {

			RemoteDBConnectionExample.doSshTunnel(SSH_USER, SSH_PASSWORD, SSH_HOST, SSH_PORT, DB_HOST, LOCAL_PORT , DB_PORT);

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:" + LOCAL_PORT, DB_USERNAME, DB_PASSWORD);

			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM student.data");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("____________________________");
				System.out.println(resultSet.getString("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("age"));
				System.out.println("____________________________");

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
