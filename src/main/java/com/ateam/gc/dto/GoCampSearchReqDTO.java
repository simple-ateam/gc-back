package com.ateam.gc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoCampSearchReqDTO {
	@ApiModelProperty(value = "반경(km)")
	double kilometer;
	@ApiModelProperty(value = "위도(Y)")
	double mapY;
	@ApiModelProperty(value = "경도(X)")
	double mapX;
	@ApiModelProperty(value = "축적도")
	double scale;

}
