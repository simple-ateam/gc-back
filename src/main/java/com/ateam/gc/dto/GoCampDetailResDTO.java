package com.ateam.gc.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@ApiModel(value = "고캠프 상세 응답DTO", description = "고캠프 상세 응답DTO")
@Setter
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoCampDetailResDTO {
	@ApiModelProperty(value = "콘텐츠 ID")
	String contentId;

	@ApiModelProperty(value = "야영장명")
	String facltNm;

	@JsonIgnore
	@ApiModelProperty(value = "한줄소개")
	String lineIntro;

	@JsonIgnore
	@ApiModelProperty(value = "소개")
	String intro;

	@JsonIgnore
	@ApiModelProperty(value = "전체면적")
	String allar;

	@JsonIgnore
	@ApiModelProperty(value = "영업배상책임보험 가입여부(Y:사용, N:미사용)")
	String insrncAt;

	@JsonIgnore
	@ApiModelProperty(value = "관광사업자번호")
	String trsagntNo;

	@JsonIgnore
	@ApiModelProperty(value = "사업자번호")
	String bizrno;

	@JsonIgnore
	@ApiModelProperty(value = "사업주체.구분")
	String facltDivNm;

	@JsonIgnore
	@ApiModelProperty(value = "운영주체.관리주체 (직영, 위탁)")
	String mangeDivNm;

	@JsonIgnore
	@ApiModelProperty(value = "운영기관.관리기관")
	String mgcDiv;

	@JsonIgnore
	@ApiModelProperty(value = "운영상태.관리상태")
	String manageSttus;

	@JsonIgnore
	@ApiModelProperty(value = "휴장기간.휴무기간 시작일")
	String hvofBgnde;

	@JsonIgnore
	@ApiModelProperty(value = "휴장기간.휴무기간 종료일")
	String hvofEnddle;

	@JsonIgnore
	@ApiModelProperty(value = "특징")
	String featureNm;

	@JsonIgnore
	@ApiModelProperty(value = "업종")
	String induty;

	@JsonIgnore
	@ApiModelProperty(value = "입지구분")
	String lctCl;

	@ApiModelProperty(value = "도")
	String doNm;

	@ApiModelProperty(value = "시군구")
	String sigunguNm;

	@JsonIgnore
	@ApiModelProperty(value = "우편번호")
	String zipcode;

	@ApiModelProperty(value = "주소")
	String addr1;

	@JsonIgnore
	@ApiModelProperty(value = "주소상세")
	String addr2;

	@ApiModelProperty(value = "경도(X)")
	String mapX;

	@ApiModelProperty(value = "위도(Y)")
	String mapY;

	@JsonIgnore
	@ApiModelProperty(value = "오시는 길 컨텐츠")
	String direction;

	@ApiModelProperty(value = "전화")
	String tel;

	@ApiModelProperty(value = "홈페이지")
	String homepage;

	@JsonIgnore
	@ApiModelProperty(value = "예약 페이지")
	String resveUrl;

	@JsonIgnore
	@ApiModelProperty(value = "예약 구분")
	String resveCl;

	@JsonIgnore
	@ApiModelProperty(value = "상주관리인원")
	String manageNmpr;

	@JsonIgnore
	@ApiModelProperty(value = "주요시설 일반야영장")
	String gnrlSiteCo;

	@JsonIgnore
	@ApiModelProperty(value = "주요시설 자동차야영장")
	String autoSiteCo;

	@JsonIgnore
	@ApiModelProperty(value = "주요시설 글램핑")
	String glampSiteCo;

	@JsonIgnore
	@ApiModelProperty(value = "주요시설 카라반")
	String caravSiteCo;

	@JsonIgnore
	@ApiModelProperty(value = "주요시설 개인 카라반")
	String indvdlCaravSiteCo;

	@JsonIgnore
	@ApiModelProperty(value = "사이트간 거리")
	String sitedStnc;

	@JsonIgnore
	@ApiModelProperty(value = "사이트 크기1 가로")
	String siteMg1Width;
	@JsonIgnore
	@ApiModelProperty(value = "사이트 크기2 가로")
	String siteMg2Width;
	@JsonIgnore
	@ApiModelProperty(value = "사이트 크기3 가로")
	String siteMg3Width;
	@JsonIgnore
	@ApiModelProperty(value = "사이트 크기1 세로")
	String siteMg1Vrticl;
	@JsonIgnore
	@ApiModelProperty(value = "사이트 크기2 세로")
	String siteMg2Vrticl;
	@JsonIgnore
	@ApiModelProperty(value = "사이트 크기3 세로")
	String siteMg3Vrticl;
	@JsonIgnore
	@ApiModelProperty(value = "사이트 크기1 수량")
	String siteMg1Co;
	@JsonIgnore
	@ApiModelProperty(value = "사이트 크기2 수량")
	String siteMg2Co;
	@JsonIgnore
	@ApiModelProperty(value = "사이트 크기3 수량")
	String siteMg3Co;
	@JsonIgnore
	@ApiModelProperty(value = "잔디")
	String siteBottomCl1;
	@JsonIgnore
	@ApiModelProperty(value = "파쇄석")
	String siteBottomCl2;
	@JsonIgnore
	@ApiModelProperty(value = "테크")
	String siteBottomCl3;
	@JsonIgnore
	@ApiModelProperty(value = "자갈")
	String siteBottomCl4;
	@JsonIgnore
	@ApiModelProperty(value = "맨흙")
	String siteBottomCl5;
	@JsonIgnore
	@ApiModelProperty(value = "툴팁")
	String tooltip;
	@JsonIgnore
	@ApiModelProperty(value = "글램핑 - 내부시설")
	String glampInnerFclty;
	@JsonIgnore
	@ApiModelProperty(value = "카라반 - 내부시설")
	String caravInnerFclty;
	@ApiModelProperty(value = "인허가일자")
	String prmisnDe;
	@JsonIgnore
	@ApiModelProperty(value = "운영기간")
	String operPdCl;
	@JsonIgnore
	@ApiModelProperty(value = "운영일")
	String operDeCl;
	@JsonIgnore
	@ApiModelProperty(value = "개인 트레일러 동반 여부(Y:사용, N:미사용)")
	String trlerAcmpnyAt;
	@JsonIgnore
	@ApiModelProperty(value = "개인 카라반 동반 여부(Y:사용, N:미사용)")
	String caravAcmpnyAt;
	@JsonIgnore
	@ApiModelProperty(value = "화장실 개수")
	String toiletCo;
	@JsonIgnore
	@ApiModelProperty(value = "샤워실 개수")
	String swrmCo;
	@JsonIgnore
	@ApiModelProperty(value = "개수대 개수")
	String wtrplCo;
	@JsonIgnore
	@ApiModelProperty(value = "화로대")
	String brazierCl;
	@JsonIgnore
	@ApiModelProperty(value = "부대시설")
	String sbrsCl;
	@JsonIgnore
	@ApiModelProperty(value = "부대시설 기타")
	String sbrsEtc;
	@JsonIgnore
	@ApiModelProperty(value = "주변이용가능시설")
	String posblFcltyCl;
	@JsonIgnore
	@ApiModelProperty(value = "주변이용가능시설 기타")
	String posblFcltyEtc;
	@JsonIgnore
	@ApiModelProperty(value = "자체문화행사 여부(Y:사용, N:미사용)")
	String clturEventAt;
	@JsonIgnore
	@ApiModelProperty(value = "자체문화행사명")
	String clturEvent;
	@JsonIgnore
	@ApiModelProperty(value = "체험프로그램 여부(Y:사용, N:미사용)")
	String exprnProgrmAt;
	@JsonIgnore
	@ApiModelProperty(value = "체험프로그램명")
	String exprnProgrm;
	@JsonIgnore
	@ApiModelProperty(value = "소화기 개수")
	String extshrCo;
	@JsonIgnore
	@ApiModelProperty(value = "방화수 개수")
	String frprvtWrppCo;
	@JsonIgnore
	@ApiModelProperty(value = "방화사 개수")
	String frprvtSandCo;
	@JsonIgnore
	@ApiModelProperty(value = "화재감지기 개수")
	String fireSensorCo;
	@JsonIgnore
	@ApiModelProperty(value = "테마환경")
	String themaEnvrnCl;
	@JsonIgnore
	@ApiModelProperty(value = "캠핑장비대여")
	String eqpmnLendCl;
	@ApiModelProperty(value = "애완동물출입")
	String animalCmgCl;
	@JsonIgnore
	@ApiModelProperty(value = "여행시기")
	String tourEraCl;
	@ApiModelProperty(value = "대표이미지")
	String firstImageUrl;
	@JsonIgnore
	@ApiModelProperty(value = "등록일")
	String createdtime;
	@JsonIgnore
	@ApiModelProperty(value = "수정일")
	String modifiedtime;
}
