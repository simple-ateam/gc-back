package com.ateam.gc.dto;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoCampSearchReqDTO {
	@NotNull
	@ApiModelProperty(value = "반경(km)", example = "20")
	double kilometer;
	@NotNull
	@ApiModelProperty(value = "위도(Y)", example = "37.4922173")
	double mapY;
	@NotNull
	@ApiModelProperty(value = "경도(X)", example = "126.8849478")
	double mapX;
	@NotNull
	@ApiModelProperty(value = "축적도", example = "5")
	double scale;

}
