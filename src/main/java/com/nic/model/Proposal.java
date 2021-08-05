package com.nic.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "proposal")
@EntityListeners(AuditingEntityListener.class)
public class Proposal implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, name="totalVaccancy")
    private Integer totalVaccancy;
    
    @NotBlank
    @Column(nullable = false, name="scVaccancy")
    private Integer scVaccancy;
    
    @NotBlank
    @Column(nullable = false, name="stVaccancy")
    private Integer stVaccancy;
    
    @NotBlank
    @Column(nullable = false, name="obcVaccancy")
    private Integer obcVaccancy;
    
    @NotBlank
    @Column(nullable = false, name="generalVaccancy")
    private Integer generalVaccancy;
    
    @NotBlank
    @Column(nullable = false, name="letterBody")
    private String letterBody;
    
    @NotBlank
    @Column(nullable = false, name="status")
    private String status;
    
    @NotBlank
    @Column(nullable = false)
    @JoinColumn(name="createdBy")
    private User createdBy;
    
    @NotBlank
    @Column(nullable = false)
    @JoinColumn(name="modifiedBy")
    private User modifiedBy;
    
    @NotBlank
    @Column(nullable = false, name="creationTS")
    private Timestamp creationTS;
    
    @NotBlank
    @Column(nullable = false, unique = true)
    @JoinColumn(name="noticeId")
    private Notice notice;

    public Integer getTotalVaccancy() {
        return this.totalVaccancy;
    }

    public void setTotalVaccancy(Integer totalVaccancy) {
        this.totalVaccancy = totalVaccancy;
    }
    
    public Integer getScVaccancy() {
        return this.scVaccancy;
    }

    public void setScVaccancy(Integer scVaccancy) {
        this.scVaccancy = scVaccancy;
    }
    
    public Integer getStVaccancy() {
        return this.stVaccancy;
    }

    public void setStVaccancy(Integer stVaccancy) {
        this.stVaccancy = stVaccancy;
    }
    
    public Integer getObcVaccancy() {
        return this.obcVaccancy;
    }

    public void setObcVaccancy(Integer obcVaccancy) {
        this.obcVaccancy = obcVaccancy;
    }
    
    public Integer getGeneralVaccancy() {
        return this.generalVaccancy;
    }

    public void setGeneralVaccancy(Integer generalVaccancy) {
        this.generalVaccancy = generalVaccancy;
    }
    
    public String getLetterBody() {
        return this.letterBody;
    }

    public void setLetterBody(String letterBody) {
        this.letterBody = letterBody;
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
    
    public Notice getNotice() {
        return this.notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
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
