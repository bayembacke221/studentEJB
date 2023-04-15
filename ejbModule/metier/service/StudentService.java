package metier.service;

import java.nio.charset.Charset;
import java.util.Random;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import metier.entities.Role;
import metier.entities.Student;
import metier.sessions.IStudentLocal;
@Stateless
@WebService
public class StudentService {
	
	@EJB
	IStudentLocal metier;
	
	@WebMethod
	public void addStudent(
			@WebParam(name="nom") String nom,
			@WebParam(name="prenom") String prenom
			) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 6; i++) {
		    // g�n�re un chiffre al�atoire entre 0 et 9
		    sb.append(rand.nextInt(10));
		}

		for (int i = 0; i < 3; i++) {
		    // g�n�re une lettre al�atoire de l'alphabet en majuscule
		    sb.append((char)(rand.nextInt(26) + 'A'));
		}

		String generatedString = sb.toString();
		//System.out.println(generatedString);
		Student s = new Student(nom,prenom,generatedString,Role.ETUDIANT);
		    metier.addStudent(s);
	}
	@WebMethod
	public void listStudent() {
		metier.getAllStudents();
	}

}
