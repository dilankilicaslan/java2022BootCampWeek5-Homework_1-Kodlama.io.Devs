package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguages;
import Kodlama.io.Devs.entities.concretes.Technology;
@Service
public class TechnologyManager implements TechnologyService {
	private LanguageRepository languageRepository;
	private TechnologyRepository technologyRepository;
	
	@Autowired
	public TechnologyManager(LanguageRepository languageRepository, TechnologyRepository technologyRepository) {
	    this.languageRepository = languageRepository;
        this.technologyRepository = technologyRepository;
	}
	     

	@Override
	public List<GetAllTechnologyResponse> getAllTechnologies() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponse = new ArrayList<GetAllTechnologyResponse>();
        for (Technology technology : technologies) {
			
			GetAllTechnologyResponse ResponseItem = new GetAllTechnologyResponse();
			ResponseItem.setId(technology.getId());
			ResponseItem.setTechnology_name(technology.getTechnologyName());
			ResponseItem.setLanguage_name(technology.getProgrammingLanguages().getLanguageName());
			technologyResponse.add(ResponseItem);
			
			
		}
    	return technologyResponse;
	}

	


	@Override
	public void addTechnology(CreateTechnologyRequest createTechnologyRequest)  {
		ProgrammingLanguages language=languageRepository.findById(createTechnologyRequest.getLanguageId()).get();
		Technology technology = new Technology();
		
		technology.setTechnologyName(createTechnologyRequest.getName());
        technology.setProgrammingLanguages(language);

        technologyRepository.save(technology);
	
		
			
	       
	}


	@Override
	public void deleteTechnology(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyRepository.deleteById(deleteTechnologyRequest.getId());
	}


	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest, int id) throws Exception {
		 Technology technology = technologyRepository.findById(id).get();
		 if(technology == null) {
			 new RuntimeException("Kayıtlı teknoloji yok");
		 }else {
			 technology.setTechnologyName(updateTechnologyRequest.getTechnologyName());
		     technologyRepository.save(technology);


		       
		 }
		 
	


	


	}
}