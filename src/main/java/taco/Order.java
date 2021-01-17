package taco;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class Order {

	private Long id;
	
	private Date createdAt;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@CreditCardNumber
	private String ccNumber;
	
	@Digits(fraction = 0, integer = 3, message="Invalid CVV")
	private String ccCVV;
	
	@Pattern(regexp ="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",message="Must be formatted MM/YY")
	private String ccExpiration;
	
}
