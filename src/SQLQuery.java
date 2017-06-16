/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

/**
 *
 * @author SenMa
 */
public class SQLQuery {
    protected Connection conn;
    protected PreparedStatement consulta;
    protected ResultSet dati;
    
    public void connetti(String servidor, String bd, String usuario, String password) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+bd, usuario, password);
    }
    
    public void disconnetti() throws SQLException{
        this.conn.close();
        this.consulta.close();
    }
    
    public void disconnetti(ResultSet rs) throws SQLException{
        this.disconnetti();
        rs.close();
    }
}
