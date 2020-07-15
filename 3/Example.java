import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Example {
	private static final String DB_NAME = "student";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "SomePassword";
	private static final String DB_TABLE = "room_booking";

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, DB_USERNAME, DB_PASSWORD);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from " + DB_TABLE);

			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
