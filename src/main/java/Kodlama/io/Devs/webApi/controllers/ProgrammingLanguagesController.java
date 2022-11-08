package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguagesService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguageResponse;





@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguagesService programmingLanguagesService;
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguagesService programmingLanguagesService) {
		
		this.programmingLanguagesService = programmingLanguagesService;
	}
	@GetMapping("/getall-languages")
	public List<GetAllLanguageResponse> getAll(){
		return programmingLanguagesService.getAll();
		
	}
	@PostMapping("/add-languages")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest)throws Exception {
		programmingLanguagesService.add(createLanguageRequest);
	}
	@DeleteMapping("/delete-languages")
	public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) throws Exception{
		programmingLanguagesService.delete(deleteLanguageRequest);
		
	}
	@PutMapping("/update-languages")
	public void update(@NotNull @RequestBody UpdateLanguageRequest updateLanguageRequest,int languageId) throws Exception{
		programmingLanguagesService.update(updateLanguageRequest, languageId);
		
	}
		
	
}

  

