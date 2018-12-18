package com.needle.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.needle.business.Guest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GuestDB implements DAO<Guest>{

	@Override
	public Guest get(String t) {
		String getGuestQuery = "Select * FROM guest WHERE phonenumber = ?";
		try (PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(getGuestQuery)){
			ps.setString(1, t);
			
			ResultSet rs = ps.executeQuery();
			Guest g = new Guest();
			
			while(rs.next()) {
				g.setPhonenumber(rs.getString(1));
				g.setFirstName(rs.getString(2));
				g.setLastName(rs.getString(3));
				g.setGender(rs.getString(4));
				g.setDob(rs.getDate(5).toLocalDate());
			}
			
			return g;
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}
	

	@Override
	public ObservableList<Guest> getAll() {
		String getAllGuestsQuery = "SELECT * FROM guest";
		try(PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(getAllGuestsQuery);
				ResultSet rs = ps.executeQuery()){
			ObservableList<Guest> guests = FXCollections.observableArrayList();
			while (rs.next()) {
				Guest g = new Guest();
				g.setPhonenumber(rs.getString(1));
				g.setFirstName(rs.getString(2));
				g.setLastName(rs.getString(3));
				g.setGender(rs.getString(4));
				g.setDob(rs.getDate(5).toLocalDate());
				
				guests.add(g);
			}
			
			return guests;
		}catch(SQLException e) {
			
		}
				return null;
	}

	@Override
	public boolean add(Guest t) {
		String insertQuery = "INSERT INTO guest VALUES(?,?,?,?,?)";
		try (PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(insertQuery)){
			ps.setString(1, t.getPhonenumber());
			ps.setString(2, t.getFirstName());
			ps.setString(3, t.getLastName());
			ps.setString(4, t.getGender());
			ps.setDate(5, Date.valueOf(t.getDob()));
			
			return ps.executeUpdate() > 0;
			
		} catch (SQLException e) {
			System.out.println("Error!!" +e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Guest t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Guest t) {
		// TODO Auto-generated method stub
		return false;
	}

}
