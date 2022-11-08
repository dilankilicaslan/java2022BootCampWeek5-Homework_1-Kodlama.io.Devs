package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;


public interface TechnologyService {
	List<GetAllTechnologyResponse> getAllTechnologies();
	void addTechnology(CreateTechnologyRequest createTechnologyRequest);
	void deleteTechnology(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
	void update(UpdateTechnologyRequest updateTechnologyRequest,int id) throws  Exception;

}
