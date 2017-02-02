package edu.mum.swe.msched.dao;

import edu.mum.swe.msched.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by acer-usrpu on 2/2/2017.
 */

@Repository
public interface BlockDao extends JpaRepository<Block,Long> {
    List<Block>  findAllByEntry(Long entry);
}
