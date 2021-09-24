package web.project.domain;

import lombok.Data;

@Data
public class AmountDto {

	private Integer total;
	private Integer tax_free;
	private Integer vat;
	private Integer point;
	private Integer discount;
	
}
