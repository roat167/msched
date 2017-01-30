package edu.mum.swe.msched.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.dao.EntryDao;
import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.service.EntryService;

@Service
public class EntryServiceImpl implements EntryService {
	@Autowired 
	EntryDao entryDao;
	
	@Override
	public List<Entry> findByName(String name) {
		return entryDao.findByName(name);
	}

	@Override
	public List<Entry> getAllEntries() {
		return entryDao.findAll();
	}

	@Override
	public void updateEntry(Entry entry) {
		entryDao.save(entry);
	}

	@Override
	public Entry findEntryById(Long entryId) {		
		return entryDao.findOne(entryId);
	}

	@Override
	public Entry save(Entry entry) {
		return entryDao.saveAndFlush(entry);
	}

	@Override
	public Entry findByEntryDate(Date entryDate) {		
		return entryDao.findOneByEntryDate(entryDate);
	}

	@Override
	public void remove(Long entryId) {
		entryDao.delete(entryId);		
	}

}
