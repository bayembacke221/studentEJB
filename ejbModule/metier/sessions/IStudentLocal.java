package metier.sessions;

import java.util.List;

import jakarta.ejb.Local;
import metier.entities.Student;

@Local
public interface IStudentLocal {
	void addStudent(Student s);
	void updateStudent(Student s);
	Student getStudentByID(Long id);
	List<Student> getAllStudents();
	List<Student> getStudentByMC(String mc);
	void deleteStudent(Long id);
}
