package Kodlama.io.Devs.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponse {
	private int languageId;
	private String language_name;
}
