package taco;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Taco {

	private Long id;
	
	private Data createdAt;
	
	@NotNull
	@Size(min=5, message="Name must be 5 characters long")
	private String name;
	
	@Size(min=1, message="Atleast 1 ingredient has to be selected")
	private List<String> ingredients; 
}
