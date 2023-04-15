package metier.entities;

import java.io.Serializable;

import jakarta.persistence.*;
@Entity
@Table(name = "etudiants")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@Column(unique=true)
	private String numCarteEtudiant;
	@Enumerated(EnumType.STRING)
	private Role role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumCarteEtudiant() {
		return numCarteEtudiant;
	}
	public void setNumCarteEtudiant(String numCarteEtudiant) {
		this.numCarteEtudiant = numCarteEtudiant;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Student(String nom, String prenom, String numCarteEtudiant, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numCarteEtudiant = numCarteEtudiant;
		this.role = role;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
