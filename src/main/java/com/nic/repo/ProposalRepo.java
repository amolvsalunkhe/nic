package com.nic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nic.model.Proposal;

@Repository
public interface ProposalRepo extends JpaRepository<Proposal, Long>{

}
