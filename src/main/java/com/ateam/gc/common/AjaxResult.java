package com.ateam.gc.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@ApiModel(value = "API응답공통모델", description = "API응답공통모델")
public class AjaxResult<T> {
	@Builder.Default
	@ApiModelProperty(value = "응답성공여부", example = "응답성공여부")
	boolean result = true;

	@Builder.Default
	@ApiModelProperty(value = "응답결과코드", example = "응답결과코드")
	int status = 200;

	@Builder.Default
	@ApiModelProperty(value = "응답결과문구", example = "응답결과문구")
	String desc = Constant.DESC_SUCCESS;

	@ApiModelProperty(value = "데이터", example = "API마다 상이한 Model")
	T data;
}
