package com.Maintenance.App.Notices.ui.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "notice")
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long noticeId;
	
	private Long userId;
	
	@NotBlank(message = "notice subject is mandatory.")
	private String noticeSubject;
	
	@NotNull(message = "notice description is mandatory.")
	private String noticeDescription;
	
	private String uploadImage;
	
	private Date dateOfCreation=new Date();
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getNoticeSubject() {
		return noticeSubject;
	}
	public void setNoticeSubject(String noticeSubject) {
		this.noticeSubject = noticeSubject;
	}
	public String getNoticeDescription() {
		return noticeDescription;
	}
	public void setNoticeDescription(String noticeDescription) {
		this.noticeDescription = noticeDescription;
	}
	public String getUploadImage() {
		return uploadImage;
	}
	public void setUploadImage(String uploadImage) {
		this.uploadImage = uploadImage;
	}
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public Notice(Long noticeId, Long userId, String noticeSubject, String noticeDescription, String uploadImage,
			Date dateOfCreation) {
		super();
		this.noticeId = noticeId;
		this.userId = userId;
		this.noticeSubject = noticeSubject;
		this.noticeDescription = noticeDescription;
		this.uploadImage = uploadImage;
		this.dateOfCreation = dateOfCreation;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", userId=" + userId + ", noticeSubject=" + noticeSubject
				+ ", noticeDescription=" + noticeDescription + ", uploadImage=" + uploadImage + ", dateOfCreation="
				+ dateOfCreation + "]";
	}
	
	

}
