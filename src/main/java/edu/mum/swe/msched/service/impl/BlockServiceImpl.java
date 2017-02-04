package edu.mum.swe.msched.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.swe.msched.dao.BlockDao;
import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.service.BlockService;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {
	@Autowired
	BlockDao blockDao;

	@Override
	public List<Block> getAllBlocks() {
		// TODO Auto-generated method stub
		return blockDao.findAll();
	}

	@Override
	public List<Block> findByName(String name) {
		// TODO Auto-generated method stub
		return blockDao.findByName(name);
	}

	@Override
	public void updateBlock(Block block) {
		// TODO Auto-generated method stub
		blockDao.save(block);
	}

	@Override
	public Block findByName(Long id) {
		return blockDao.findById(id);
	}

	public Block findById(Long id) {

		// TODO Auto-generated method stub
		return blockDao.findOne(id);
	}

	@Override
	public Block saveBlock(Block block) {
		// TODO Auto-generated method stub
		return blockDao.save(block);
	}

	@Override
	public void deleteBlock(Long id) {
		// TODO Auto-generated method stub
		blockDao.delete(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Block> findByStartDate(Date startDate) {
		// TODO Auto-generated method stub
		return (List<Block>) blockDao.findOneByStartDate(startDate);
	}

	@Override
	public List<Block> findAllByEntry(Entry entry) {
		return blockDao.findAllByEntry(entry);
	}

}
