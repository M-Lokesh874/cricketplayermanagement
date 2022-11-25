package com.ideas2it.cricketplayermanagement.util.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ideas2it.cricketplayermanagement.model.BaseModel;
import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.CricketPlayerStats;
import com.ideas2it.cricketplayermanagement.model.CricketTeam;

public class HibernateConnection {

	private static HibernateConnection hibernateConnection = null;
	private static SessionFactory sessionFactory = null;

	private HibernateConnection() {
		sessionFactory = new Configuration().configure().addAnnotatedClass(BaseModel.class)
				.addAnnotatedClass(CricketPlayerStats.class).addAnnotatedClass(CricketTeam.class)
				.addAnnotatedClass(CricketPlayer.class).buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		if (hibernateConnection == null) {
			hibernateConnection = new HibernateConnection();
		}
		return sessionFactory;
	}
}
