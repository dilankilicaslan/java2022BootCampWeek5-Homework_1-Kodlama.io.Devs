package Kodlama.io.Devs.entities.concretes;



import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="programingLanguages")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgrammingLanguages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="languageId")
	private int languageId;
	
	@Column(name="languageName")
	private String languageName;
	
	@JsonIgnore
    @OneToMany(mappedBy = "programmingLanguages", cascade = CascadeType.DETACH)
	private Set<Technology> technologies;
	

}
