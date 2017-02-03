package edu.mum.swe.msched.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.dao.SectionDao;
import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	SectionDao sectionDao;

	@Override
	public Section findSectionById(long id) {
		// TODO Auto-generated method stub
		return sectionDao.findOne(id);
	}

	@Override
	public List<Section> getAllSections() {
		// TODO Auto-generated method stub
		return sectionDao.findAll();
	}

	@Override
	public void saveSection(Section section) {
		// TODO Auto-generated method stub
		sectionDao.saveAndFlush(section);
	}

	@Override
	public void updateSection(Section section) {
		// TODO Auto-generated method stub
		sectionDao.save(section);
	}

	@Override
	public void deleteSection(long id) {
		// TODO Auto-generated method stub
		sectionDao.delete(id);
	}

}
