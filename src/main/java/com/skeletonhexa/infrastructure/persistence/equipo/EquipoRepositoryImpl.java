package com.skeletonhexa.infrastructure.persistence.equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skeletonhexa.domain.entities.Equipo;
import com.skeletonhexa.domain.repository.EquipoRepository;
import com.skeletonhexa.infrastructure.database.ConnectionDb;

public class EquipoRepositoryImpl implements EquipoRepository{
    private final ConnectionDb connection;
    
    public EquipoRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Equipo equipo) {
        String sql = "INSERT INTO equipos (id, name, yearfoundation, coach) VALUES (?, ?, ?, ?)";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, equipo.getId());
            stmt.setString(2, equipo.getName());
            stmt.setString(3, equipo.getYearFound());
            stmt.setString(4, equipo.getCoach());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipo buscarPorId(int id) {
        String sql = "SELECT * FROM equipos WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Equipo(rs.getInt("id"), rs.getString("name"), rs.getString("yearfoundation"), rs.getString("coach"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Equipo> listarTodos() {
        List<Equipo> equipo = new ArrayList<>();
        String sql = "SELECT * FROM equipos";
        try (Connection conexion = connection.getConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                equipo.add(new Equipo(rs.getInt("id"), rs.getString("name"), rs.getString("yearfoundation"), rs.getString("coach")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipo;
    }

    @Override
    public void actualizar(Equipo equipo) {
        String sql = "UPDATE equipos SET name = ?, yearfoundation = ?, coach = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, equipo.getName());
            stmt.setString(2, equipo.getYearFound());
            stmt.setString(3, equipo.getCoach());
            stmt.setInt(4, equipo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM equipos WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
