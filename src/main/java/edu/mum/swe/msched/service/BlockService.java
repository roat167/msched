package edu.mum.swe.msched.service;

import edu.mum.swe.msched.domain.Block;

import java.util.List;

/**
 * Created by acer-usrpu on 2/2/2017.
 */
public interface BlockService {
    void updateBlock(Block block);
    List<Block> findAllByEntry(Long entry);
    Block save(Block block);
    void remove(Long blockId);

}
