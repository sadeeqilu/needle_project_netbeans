package com.needle.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.needle.business.Room;
import com.needle.business.Visit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomDB implements DAO<Room>{

	@Override
	public Room get(String type) {
		String getVacantRoomQuery = "SELECT room_number, type, price FROM room where type = ? AND status = 'vacant' LIMIT 1";
		try (PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(getVacantRoomQuery)){
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			
			Room room = new Room();
			while(rs.next()) {
				room.setRoomNumber(rs.getInt(1));
				room.setType(rs.getString(2));
				room.setPrice(rs.getDouble(3));
				
			}
			
			return room;
			
		} catch (Exception e) {
			System.out.println("Error in getting room: "+e.getMessage());
		}
		return null;
	}

	public ObservableList<Room> getMenu(){
		String getMenuQuery = "SELECT DISTINCT(type), price FROM room";
		try(PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(getMenuQuery);
				ResultSet rs = ps.executeQuery()) {
			ObservableList<Room> roomMenu = FXCollections.observableArrayList();
			while(rs.next()) {
				Room room = new Room();
				room.setType(rs.getString(1));
				room.setPrice(rs.getDouble(2));
				
				roomMenu.add(room);
			}
			
			return roomMenu;
			
		} catch (SQLException e) {
			System.out.println("Error in getMEnu: "+e.getMessage());
		}
		return null;
	}
	
	public int assignRoom(Room r,Visit v) {
		String bookRoomQuery = "SELECT Room.room_number FROM Room,Visit "
				+ "WHERE type = ? "
				+ "AND Visit.checkout < ? "
				+ "AND Room.status = 'vacant' "
				+ "AND Room.room_number = Visit.room_number";
		
		try(PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(bookRoomQuery)){
			ps.setString(1, r.getType());
			ps.setDate(2, Date.valueOf(v.getCheckIn()));
			
			ResultSet rs = ps.executeQuery();
			int roomnumber = 0;
			while(rs.next()) {
				roomnumber = rs.getInt(1);
				
			}
			
			return roomnumber;
			
		}catch(SQLException e) {
			
		}
		return 0;
	}
	@Override
	public ObservableList<Room> getAll() {
		String getRoomsQuery = "SELECT * FROM room";
		try(PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(getRoomsQuery);
				ResultSet rs = ps.executeQuery()){
			ObservableList<Room> rooms = FXCollections.observableArrayList();
			while(rs.next()) {
				Room r = new Room();
				r.setRoomNumber(rs.getInt(1));
				r.setType(rs.getString(2));
				r.setPrice(rs.getDouble(3));
				r.setStatus(rs.getString(4));
				
				rooms.add(r);
			}
			
			return rooms;
		}catch(SQLException ex) {
			
		}
				return null;
	}

	@Override
	public boolean add(Room t) {
		String addRoomQuery = "INSERT INTO room VALUES(?,?,?,?)";
		try (PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(addRoomQuery)){
			ps.setInt(1, t.getRoomNumber());
			ps.setString(2, t.getType());
			ps.setDouble(3, t.getPrice());
			ps.setString(4, t.getStatus());
			
			return ps.executeUpdate() > 0;
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean update(Room t) {
		String updateRoomQuery = "UPDATE room SET status = ? WHERE roomnumber = ?";
		try (PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(updateRoomQuery)){
			ps.setString(1, t.getStatus());
			ps.setInt(2, t.getRoomNumber());
			
			return ps.executeUpdate() > 0;
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(Room t) {
		// TODO Auto-generated method stub
		return false;
	}

}
