package com.needle.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.needle.business.Visit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VisitDB implements DAO<Visit>{

	public int getVisitCount(String phone) {
		String getVisitCountQuery = "SELECT COUNT(*) FROM visit where guest_phonenumber = ?";
		try (PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(getVisitCountQuery)){
			ps.setString(1, phone);
			
			ResultSet rs = ps.executeQuery();
			int visitCount = 0;
			while (rs.next()) {
				visitCount = rs.getInt(1);
			}
			
			return visitCount;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	@Override
	public Visit get(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<Visit> getAll() {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Visit t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Visit t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Visit t) {
		// TODO Auto-generated method stub
		return false;
	}

}
