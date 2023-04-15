package metier.sessions;

import java.util.List;

import jakarta.ejb.Remote;
import metier.entities.Student;

@Remote
public interface IStudentRemote {

	void addStudent(Student s);
	void updateStudent(Student s);
	Student getStudentByID(Long id);
	List<Student> getAllStudents();
	List<Student> getStudentByMC(String mc);
	void deleteStudent(Long id);
}
