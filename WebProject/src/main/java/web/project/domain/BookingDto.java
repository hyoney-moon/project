package web.project.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingDto {

	Long boardNum;
	int count;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date startDatepicker;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date endDatepicker;
}
