package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguagesService;
import Kodlama.io.Devs.business.abstracts.TechnologyService;

import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	private TechnologyService technologyService;
	private ProgrammingLanguagesService programmingLanguagesService;
	public TechnologyController(TechnologyService technologyService,ProgrammingLanguagesService programmingLanguagesService) {
		this.technologyService=technologyService;
		this.programmingLanguagesService = programmingLanguagesService;
		
	}
	@GetMapping("/getall-technologies")
    public List<GetAllTechnologyResponse> getAll() {
        return technologyService.getAllTechnologies();
    }
	@PostMapping("/add-technologies")
	public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest)throws Exception {
		technologyService.addTechnology(createTechnologyRequest);
	}
	@DeleteMapping("/delete-technologies")
	public void delete(@RequestBody DeleteTechnologyRequest deleteTechnologyRequest) throws Exception  {
		technologyService.deleteTechnology(deleteTechnologyRequest);
		
	}
	@PutMapping("/update-technologies")
	public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest,int id) throws Exception{
		technologyService.update(updateTechnologyRequest, id);
		
	}
}
