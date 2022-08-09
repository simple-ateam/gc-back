package com.ateam.gc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Positive;

@ApiModel(value = "고캠프 검색 요청DTO", description = "고캠프 검색 요청DTO")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoCampSearchReqDTO {
	@Positive(message = "반경(km)은 양수를 입력해주세요.")
	@ApiModelProperty(value = "반경(km)", example = "20")
	double kilometer;
	@Positive(message = "위도(Y)는 양수를 입력해주세요.")
	@ApiModelProperty(value = "위도(Y)", example = "37.4922173")
	double mapY;
	@Positive(message = "경도(X)는 양수를 입력해주세요.")
	@ApiModelProperty(value = "경도(X)", example = "126.8849478")
	double mapX;
	@Positive(message = "축적도는 양수를 입력해주세요.")
	@ApiModelProperty(value = "축적도", example = "5")
	double scale;

}
