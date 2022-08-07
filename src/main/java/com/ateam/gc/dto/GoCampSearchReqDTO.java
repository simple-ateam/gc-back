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
	@ApiModelProperty(value = "반경(km)", example = "20")
	double kilometer;
	@ApiModelProperty(value = "위도(Y)", example = "37.4922173")
	double mapY;
	@ApiModelProperty(value = "경도(X)", example = "126.8849478")
	double mapX;
	@ApiModelProperty(value = "축적도", example = "5")
	double scale;

}
