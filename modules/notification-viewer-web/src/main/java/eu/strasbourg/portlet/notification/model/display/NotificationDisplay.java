package eu.strasbourg.portlet.notification.model.display;

import java.util.Date;

//Simple holder de données pour l'affichage
public class NotificationDisplay {
	
	private String title;
	private Date date;
	private boolean isRead;
	private Long notificationId;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	
	
}
