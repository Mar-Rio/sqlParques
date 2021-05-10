/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Comunidad;
import Modelo.Parques;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 52659401g
 */
public class Gestion {

    private Connection conn;
    private String db,
            user,
            pwd;
    private List<Comunidad> comunidades;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/" + db + "?serverTimezone=UTC";
        conn = DriverManager.getConnection(url, user, pwd);
        return true;
    }

    public int insertarParque(Parques parque) throws SQLException {
        boolean insertado = false;
        String sql = "INSERT INTO PARQUE VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(parque.getId()));
        ps.setString(2, parque.getNombre());
        ps.setDouble(3, Integer.parseInt(parque.getExtension()));
        ps.setInt(4, Integer.parseInt(parque.getIdComunidad()));
        return ps.executeUpdate();
    }

    public boolean borrarParque(Parques parque) throws SQLException {
        boolean borrado = false;
        String sql = "DELETE FROM PARQUE WHERE id ='" + parque.getId() + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        int num_filas = ps.executeUpdate(sql);
        if (num_filas == 1) {
            borrado = true;
        }
        return borrado;
    }

    public boolean listar() throws SQLException {
        boolean listado = false;
        comunidades = new ArrayList<>();
        try (Connection cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db + "?serverTimezone=UTC", user, pwd)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, "Comunidad");
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Comunidad comunidad = new Comunidad();
                    comunidad.setId(rs.getInt("id"));
                    comunidad.setComunidad(rs.getString("nombre"));
                    comunidades.add(comunidad);
                }
            }
            listado = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
        }
        return listado;
    }
}