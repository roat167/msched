package edu.mum.swe.msched.service;

import java.util.Date;
import java.util.List;

import edu.mum.swe.msched.domain.Entry;

public interface EntryService {
	List<Entry> findByName(String name);
	List<Entry> getAllEntries();
	void updateEntry(Entry entry);
	Entry findEntryById(Long entryId);
	Entry findByEntryDate(Date entryDate);
	Entry save(Entry entry);
	void remove(Long entryId);
	
}
