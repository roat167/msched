package edu.mum.swe.msched.service.impl;

import edu.mum.swe.msched.dao.BlockDao;
import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acer-usrpu on 2/2/2017.
 */
@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    BlockDao blockDao;

    @Override
    public void updateBlock(Block block) {
        blockDao.save(block);
    }

    @Override
    public List<Block> findAllByEntry(Long entry) {
        return blockDao.findAllByEntry(entry);
    }

    @Override
    public Block save(Block block) {
        return blockDao.saveAndFlush(block);
    }

    @Override
    public void remove(Long blockId) {
        blockDao.delete(blockId);
    }
}
