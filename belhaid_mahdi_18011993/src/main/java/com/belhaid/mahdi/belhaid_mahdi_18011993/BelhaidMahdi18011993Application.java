package com.belhaid.mahdi.belhaid_mahdi_18011993;

import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.FullName;
import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.SchoolClass;
import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Student;
import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Teacher;
import com.belhaid.mahdi.belhaid_mahdi_18011993.repositories.SchoolClassRepository;
import com.belhaid.mahdi.belhaid_mahdi_18011993.repositories.StudentRepository;
import com.belhaid.mahdi.belhaid_mahdi_18011993.repositories.TeacherRepository;
import com.belhaid.mahdi.belhaid_mahdi_18011993.services.AuthenticationService;
import com.belhaid.mahdi.belhaid_mahdi_18011993.dto.RegisterRequest;
import com.belhaid.mahdi.belhaid_mahdi_18011993.services.SchoolManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Role.ADMIN;
import static com.belhaid.mahdi.belhaid_mahdi_18011993.entities.Role.MANAGER;

@SpringBootApplication
@RequiredArgsConstructor
public class BelhaidMahdi18011993Application implements CommandLineRunner{

	private final AuthenticationService service;
	private final  SchoolManagementService schoolManagementService;
	private final  SchoolClassRepository schoolClassRepository;
	private final  StudentRepository studentRepository;
	private final  TeacherRepository teacherRepository;

	public static void main(String[] args) {
		SpringApplication.run(BelhaidMahdi18011993Application.class, args);
	}




	@Override
	public void run(String... args) throws Exception {
		var admin = RegisterRequest.builder()
				.firstname("Admin")
				.lastname("Admin")
				.email("admin@mail.com")
				.password("password")
				.role(ADMIN)
				.build();
		System.out.println("Admin token: " + service.register(admin).accessToken());

		var manager = RegisterRequest.builder()
				.firstname("manager")
				.lastname("manager")
				.email("manager@mail.com")
				.password("password")
				.role(MANAGER)
				.build();
		System.out.println("Manager token: " + service.register(manager).accessToken());

		SchoolClass c = SchoolClass
				.builder()
				.name("classA")
				.build();
		schoolClassRepository.save(c);

		Student s = Student.builder()
				.fullName(new FullName("mahdi","belhaid"))
				.schoolClass(c)
				.build();
		studentRepository.save(s);
		Teacher teacher = Teacher.builder()
				.fullName(new FullName("teacher1","teacher1S"))

				.build();
		teacherRepository.save(teacher);
		c.setTeacher(teacher);
		schoolClassRepository.save(c);

	}
}
