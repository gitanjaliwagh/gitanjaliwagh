package com.whatsappweb.dao;

import java.util.List;

import com.whatsappweb.entity.WhatsappUser;

public interface WhatsappDAOInterface {
	
	int createProfileDAO(WhatsappUser wu);

	boolean loginProfileDAO(WhatsappUser wu);

	WhatsappUser viewProfileDAO(WhatsappUser wu);
	
	int editProfileDAO(WhatsappUser wu);

	int deleteProfile(WhatsappUser wu);
	
	//List<WhatsappUser> viewAllDAO(WhatsappUser wu);
}
