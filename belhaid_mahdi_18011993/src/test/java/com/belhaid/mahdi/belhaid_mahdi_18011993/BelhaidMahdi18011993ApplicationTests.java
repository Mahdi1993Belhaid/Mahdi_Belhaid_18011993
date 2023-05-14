package com.belhaid.mahdi.belhaid_mahdi_18011993;

import com.belhaid.mahdi.belhaid_mahdi_18011993.repositories.StudentRepository;
import com.belhaid.mahdi.belhaid_mahdi_18011993.services.SchoolManagementService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

@SpringBootTest
class BelhaidMahdi18011993ApplicationTests {


	@Autowired
	StudentRepository studentRepository;
	@Autowired
	SchoolManagementService schoolManagementService;
	@BeforeEach
	public void init(){

	}

	@Test
	void contextLoads() {
	}
	@Test
	public void testGetAllStudents() {
		String firstName = "John";
		String className = "Maths";
		int page = 0;
		int size = 5;

		Page studentsPage = new PageImpl(Collections.emptyList());

		Pageable paging = PageRequest.of(page, size);

		Mockito.when(studentRepository.findStudents(firstName,className,paging)).thenReturn(studentsPage);

		Page returnedPage = schoolManagementService.getAllStudents(firstName, className, page, size);

		Assertions.assertThat(returnedPage).isNotNull();
		Assertions.assertThat(studentsPage).isEqualTo(returnedPage);
	}

}
