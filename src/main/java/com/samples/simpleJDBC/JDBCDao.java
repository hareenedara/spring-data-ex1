package com.samples.simpleJDBC;

import java.sql.*;

/**
 * Created by edara on 8/4/16.
 */
public class JDBCDao {

    public Circle getCircleByID(int id) {
        // simple jdbc
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Circle circle =null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/testdb");
            ps = connection.prepareStatement("select * from circle where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()) {
                circle = new Circle(id,rs.getString("name"));
            }
            rs.close();
            ps.close();
        }catch(ClassNotFoundException ex) {
            System.out.println("Unable to find Driver. Exiting");
            System.exit(9);
        }catch(SQLException ex) {
            System.out.println("SQL exception running query");
            System.exit(9);
        }catch(Exception ex) {
            System.out.println("Unknown exception");
            System.exit(9);
        }finally{
            try {
                rs.close();
                ps.close();
            }catch(Exception ex) {}
        }

        return circle;
    }
}
