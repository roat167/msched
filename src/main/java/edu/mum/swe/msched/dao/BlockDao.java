package edu.mum.swe.msched.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.swe.msched.domain.Block;


@Repository
public interface BlockDao extends JpaRepository<Block, Long> {
	Block findOneByEndDate(Date blockDate);

	List<Block> findByName(String name);
	Block findOneByStartDate(Date startDate);
}
