package com.nic.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "notice")
@EntityListeners(AuditingEntityListener.class)
public class Notice implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false, name = "subject")
	private String subject;

	@NotBlank
	@Column(nullable = false, name = "letterBody")
	private String letterBody;

	@NotBlank
	@Column(nullable = false, name = "fileName")
	private String fileName;

	@NotBlank
	@Column(nullable = false, name = "status")
	private String status;

	@NotBlank
	@Column(nullable = false)
	@JoinColumn(name = "createdBy")
	private User createdBy;

	@NotBlank
	@Column(nullable = false)
	@JoinColumn(name = "modifiedBy")
	private User modifiedBy;

	@NotBlank
	@Column(nullable = false, name = "creationTS")
	private Timestamp creationTS;

	@NotBlank
	@Column(nullable = false, unique = true, name = "noticeId")
	private String noticeId;

	@ManyToMany
	@JoinTable(name = "notice_department", joinColumns = @JoinColumn(name = "noticeId"), inverseJoinColumns = @JoinColumn(name = "departmentId"))
	Set<Department> departments;
	
    public Set<Department> getDepartments() {
        return this.departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getLetterBody() {
		return this.letterBody;
	}

	public void setLetterBody(String letterBody) {
		this.letterBody = letterBody;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public Timestamp getCreationTS() {
		return this.creationTS;
	}

	public void setCreationTS(Timestamp creationTS) {
		this.creationTS = creationTS;
	}

	public Long getId() {
		return this.id;
	}
}
