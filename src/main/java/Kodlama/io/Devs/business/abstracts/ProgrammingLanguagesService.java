package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguageResponse;



public interface ProgrammingLanguagesService {
	List<GetAllLanguageResponse> getAll();

	void add(CreateLanguageRequest createLanguageRequest);

	void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;


	void update(UpdateLanguageRequest updateLanguageRequest, int languageId) throws Exception;

}
