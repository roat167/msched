package edu.mum.swe.msched.service;

import java.util.List;

import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Faculty;
import edu.mum.swe.msched.domain.Section;

public interface SectionService {

	Section findSectionById(long id);
	List<Section> getAllSections();
	void saveSection(Section section);
	void updateSection(Section section);
	void deleteSection(long id);
	List<Section> findAvailabeSection(Block block);
	List<Section> findSectionByFacultyId(Faculty faculty);
	List<Section> findSectionByFacultyAndBlock(Faculty faculty, Block block);
}
