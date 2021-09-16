package com.whatsappweb.utility;

import com.whatsappweb.dao.WhatsappDAOHibernate;
import com.whatsappweb.dao.WhatsappDAOInterface;

public class DAOFactory {

	public static WhatsappDAOInterface createObjectHibernate() {
		// TODO Auto-generated method stub
		return new WhatsappDAOHibernate();
	}

	

}
