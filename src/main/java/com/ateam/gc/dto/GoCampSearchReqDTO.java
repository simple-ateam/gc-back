package com.ateam.gc.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@ApiModel(value = "고캠프 검색 요청DTO", description = "고캠프 검색 요청DTO")
@Setter
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoCampSearchReqDTO {
	@Positive
	@ApiModelProperty(value = "반경(km)", example = "20")
	double kilometer;
	@Positive
	@ApiModelProperty(value = "위도(Y)", example = "37.4922173")
	double mapY;
	@Positive
	@ApiModelProperty(value = "경도(X)", example = "126.8849478")
	double mapX;
	@Positive
	@ApiModelProperty(value = "축적도", example = "5")
	double scale;

}
