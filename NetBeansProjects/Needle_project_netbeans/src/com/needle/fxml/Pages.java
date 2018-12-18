package com.needle.fxml;

import java.net.URL;

public enum Pages {
	MAIN("MainPage.fxml"),
	USERPAGE("UserPage.fxml"),
	LOGIN("PasswordPrompt.fxml"),
	GUEST("GuestPage.fxml"),
	HISTORY("HistoryPage.fxml"),
	ROOM("RoomPage.fxml"),
	DASHBOARD("Dashboard.fxml");
	
	private final String fxml;
    Pages(String fxml){
        this.fxml = fxml;
    }
    
    public URL getPage(){
        return getClass().getResource(fxml);
    }
}
