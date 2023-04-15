package metier.sessions;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import metier.entities.Student;
@Stateless(name="STU")
public class StudentMetierImpl implements IStudentLocal, IStudentRemote {

	@PersistenceContext(unitName = "UP_STUDENTS")
	private EntityManager em;
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		
		em.persist(s);

	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		em.merge(s);
	}

	@Override
	public Student getStudentByID(Long id) {
		Student s = em.find(Student.class, id);
		if(s==null) throw new RuntimeException("Etudiant introuvable");
		return s;
	}

	@Override
	public List<Student> getAllStudents() {
		Query req = em.createQuery("select s from Student s");
		return req.getResultList();
	}

	@Override
	public List<Student> getStudentByMC(String mc) {
		Query req = em.createQuery("select s from Student s where s.prenom="+mc);
		return req.getResultList();
	}

	@Override
	public void deleteStudent(Long id) {
		Student s = getStudentByID(id);
		em.remove(s);

	}

}
