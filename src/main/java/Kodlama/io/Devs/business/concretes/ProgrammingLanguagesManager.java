package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguagesService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguages;

@Service
public class ProgrammingLanguagesManager implements ProgrammingLanguagesService {

	
	private LanguageRepository languageRepository;
	private TechnologyRepository technologyRepository;
	@Autowired
	public ProgrammingLanguagesManager(LanguageRepository languageRepository) {
	        this.languageRepository = languageRepository;

	    }

	

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
	 ProgrammingLanguages programmingLanguage = new ProgrammingLanguages();
	 programmingLanguage.setLanguageName(createLanguageRequest.getName());
	 this.languageRepository.save(programmingLanguage);
	 
		
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<ProgrammingLanguages> programmingLanguages = languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponse = new ArrayList<GetAllLanguageResponse>();
		for (ProgrammingLanguages programmingLanguage : programmingLanguages) {
			
			GetAllLanguageResponse ResponseItem = new GetAllLanguageResponse();
			ResponseItem.setLanguageId(programmingLanguage.getLanguageId());
			ResponseItem.setLanguage_name(programmingLanguage.getLanguageName());
			languageResponse.add(ResponseItem);
			
			
		}

		return languageResponse;
	}



	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception  {
		  
			
           languageRepository.deleteById(deleteLanguageRequest.getLanguageId());
			
		
		
	}






	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest,int languageId) throws Exception {
		List<ProgrammingLanguages> programmingLanguages = languageRepository.findAll();
		for(ProgrammingLanguages language : programmingLanguages) {
			if(updateLanguageRequest.getLanguageName() == language.getLanguageName() || updateLanguageRequest.getLanguageName() == null) {
				throw new Exception("Yeni Programlama Dili Giriniz:");
			}else if(language.getLanguageId() == languageId){
				
				language.setLanguageName(updateLanguageRequest.getLanguageName());
			
				languageRepository.save(language);
			}
		}
	}






	
	
}
