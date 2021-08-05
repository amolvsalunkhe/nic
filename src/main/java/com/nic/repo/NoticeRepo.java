package com.nic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nic.model.Notice;

@Repository
public interface NoticeRepo extends JpaRepository<Notice, Long>{

}
