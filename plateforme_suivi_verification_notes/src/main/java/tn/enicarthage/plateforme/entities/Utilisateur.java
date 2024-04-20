package tn.enicarthage.plateforme.entities;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Inheritance
@DiscriminatorColumn(name="product_type", 
discriminatorType = DiscriminatorType.INTEGER)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public abstract class Utilisateur implements Serializable   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idUtilisateur;
	String nom;
	String prenom;
	long numTel;

}
