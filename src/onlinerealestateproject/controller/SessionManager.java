package onlinerealestateproject.controller;

import javax.servlet.http.HttpSession;

public class SessionManager {
	private static SessionManager singletonSessionManager = new SessionManager();
	private HttpSession httpSession;
	
	private SessionManager() {
		
	}

	public HttpSession getHttpSession() {
		return httpSession;
	}
	
	public static SessionManager getInstance() {
		if(singletonSessionManager == null)
			singletonSessionManager = new SessionManager();
		return singletonSessionManager;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}
	
	public boolean isNewSession() {
		return httpSession.isNew();
	}
	
	public String getHttpSessionId() {
		return httpSession.getId();
	}

}
