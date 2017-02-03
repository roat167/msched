package edu.mum.swe.msched.service;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.swe.msched.domain.Block;
@Service
@Transactional
public interface BlockService {
	List<Block> getAllBlocks();

	List<Block> findByName(String name);

	List<Block> findByStartDate(Date startDate);

	public void updateBlock(Block block);

	public Block saveBlock(Block block);

	public void deleteBlock(Long id);

	public Block findById(Long id);


}
