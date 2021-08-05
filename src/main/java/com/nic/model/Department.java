package com.nic.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "department")
@EntityListeners(AuditingEntityListener.class)
public class Department implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, name="name")
    private String name;
    
    @ManyToMany(mappedBy = "departments")
    Set<Notice> notices;

    public String getName() {
        return this.name;
    }

    public void setName(String userName) {
        this.name = userName;
    }
    
    public Set<Notice> getNotices() {
        return this.notices;
    }

    public void setNotices(Set<Notice> notices) {
        this.notices = notices;
    }

    public Long getId() {
        return this.id;
    }
}
