package edu.mum.swe.msched.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.dao.SectionDao;
import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	SectionDao sectionDao;

	@Override
	public Section findSectionById(long id) {
		return sectionDao.findOne(id);
	}

	@Override
	public List<Section> getAllSections() {
		return sectionDao.findAll();
	}

	@Override
	public void saveSection(Section section) {
		sectionDao.saveAndFlush(section);
	}

	@Override
	public void updateSection(Section section) {
		sectionDao.save(section);
	}

	@Override
	public void deleteSection(long id) {
		sectionDao.delete(id);
	}

	@Override
	public List<Section> findAvailabeSection(Block block) {
		return sectionDao.findAvailableSectionByBlock(block);
	}

}
