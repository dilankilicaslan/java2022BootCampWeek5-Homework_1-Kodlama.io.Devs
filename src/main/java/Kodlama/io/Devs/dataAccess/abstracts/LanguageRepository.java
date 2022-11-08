package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguages;

@Repository
public interface LanguageRepository extends JpaRepository<ProgrammingLanguages,Integer> {

}
