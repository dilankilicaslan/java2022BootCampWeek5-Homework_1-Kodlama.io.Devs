package Kodlama.io.Devs.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologyResponse {
	private int id;
	private String technology_name;
	private String language_name;
	
}
