package com.ateam.gc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoCampingDetailItem {
	@ApiModelProperty(value = "콘텐츠 ID")
	String contentId;

	@ApiModelProperty(value = "야영장명")
	String facltNm;

	@ApiModelProperty(value = "한줄소개")
	String lineIntro;

	@ApiModelProperty(value = "소개")
	String intro;

	@ApiModelProperty(value = "전체면적")
	String allar;

	@ApiModelProperty(value = "영업배상책임보험 가입여부(Y:사용, N:미사용)")
	String insrncAt;

	@ApiModelProperty(value = "관광사업자번호")
	String trsagntNo;

	@ApiModelProperty(value = "사업자번호")
	String bizrno;

	@ApiModelProperty(value = "사업주체.구분")
	String facltDivNm;

	@ApiModelProperty(value = "운영주체.관리주체 (직영, 위탁)")
	String mangeDivNm;

	@ApiModelProperty(value = "운영기관.관리기관")
	String mgcDiv;

	@ApiModelProperty(value = "운영상태.관리상태")
	String manageSttus;

	@ApiModelProperty(value = "휴장기간.휴무기간 시작일")
	String hvofBgnde;

	@ApiModelProperty(value = "휴장기간.휴무기간 종료일")
	String hvofEnddle;

	@ApiModelProperty(value = "특징")
	String featureNm;

	@ApiModelProperty(value = "업종")
	String induty;

	@ApiModelProperty(value = "입지구분")
	String lctCl;

	@ApiModelProperty(value = "도")
	String doNm;

	@ApiModelProperty(value = "시군구")
	String sigunguNm;

	@ApiModelProperty(value = "우편번호")
	String zipcode;

	@ApiModelProperty(value = "주소")
	String addr1;

	@ApiModelProperty(value = "주소상세")
	String addr2;

	@ApiModelProperty(value = "경도(X)")
	String mapX;

	@ApiModelProperty(value = "위도(Y)")
	String mapY;

	@ApiModelProperty(value = "오시는 길 컨텐츠")
	String direction;

	@ApiModelProperty(value = "전화")
	String tel;

	@ApiModelProperty(value = "홈페이지")
	String homepage;

	@ApiModelProperty(value = "예약 페이지")
	String resveUrl;

	@ApiModelProperty(value = "예약 구분")
	String resveCl;

	@ApiModelProperty(value = "상주관리인원")
	String manageNmpr;

	@ApiModelProperty(value = "주요시설 일반야영장")
	String gnrlSiteCo;

	@ApiModelProperty(value = "주요시설 자동차야영장")
	String autoSiteCo;

	@ApiModelProperty(value = "주요시설 글램핑")
	String glampSiteCo;

	@ApiModelProperty(value = "주요시설 카라반")
	String caravSiteCo;

	@ApiModelProperty(value = "주요시설 개인 카라반")
	String indvdlCaravSiteCo;

	@ApiModelProperty(value = "사이트간 거리")
	String sitedStnc;

	@ApiModelProperty(value = "사이트 크기1 가로")
	String siteMg1Width;
	@ApiModelProperty(value = "사이트 크기2 가로")
	String siteMg2Width;
	@ApiModelProperty(value = "사이트 크기3 가로")
	String siteMg3Width;
	@ApiModelProperty(value = "사이트 크기1 세로")
	String siteMg1Vrticl;
	@ApiModelProperty(value = "사이트 크기2 세로")
	String siteMg2Vrticl;
	@ApiModelProperty(value = "사이트 크기3 세로")
	String siteMg3Vrticl;
	@ApiModelProperty(value = "사이트 크기1 수량")
	String siteMg1Co;
	@ApiModelProperty(value = "사이트 크기2 수량")
	String siteMg2Co;
	@ApiModelProperty(value = "사이트 크기3 수량")
	String siteMg3Co;
	@ApiModelProperty(value = "잔디")
	String siteBottomCl1;
	@ApiModelProperty(value = "파쇄석")
	String siteBottomCl2;
	@ApiModelProperty(value = "테크")
	String siteBottomCl3;
	@ApiModelProperty(value = "자갈")
	String siteBottomCl4;
	@ApiModelProperty(value = "맨흙")
	String siteBottomCl5;
	@ApiModelProperty(value = "툴팁")
	String tooltip;
	@ApiModelProperty(value = "글램핑 - 내부시설")
	String glampInnerFclty;
	@ApiModelProperty(value = "카라반 - 내부시설")
	String caravInnerFclty;
	@ApiModelProperty(value = "인허가일자")
	String prmisnDe;
	@ApiModelProperty(value = "운영기간")
	String operPdCl;
	@ApiModelProperty(value = "운영일")
	String operDeCl;
	@ApiModelProperty(value = "개인 트레일러 동반 여부(Y:사용, N:미사용)")
	String trlerAcmpnyAt;
	@ApiModelProperty(value = "개인 카라반 동반 여부(Y:사용, N:미사용)")
	String caravAcmpnyAt;
	@ApiModelProperty(value = "화장실 개수")
	String toiletCo;
	@ApiModelProperty(value = "샤워실 개수")
	String swrmCo;
	@ApiModelProperty(value = "개수대 개수")
	String wtrplCo;
	@ApiModelProperty(value = "화로대")
	String brazierCl;
	@ApiModelProperty(value = "부대시설")
	String sbrsCl;
	@ApiModelProperty(value = "부대시설 기타")
	String sbrsEtc;
	@ApiModelProperty(value = "주변이용가능시설")
	String posblFcltyCl;
	@ApiModelProperty(value = "주변이용가능시설 기타")
	String posblFcltyEtc;
	@ApiModelProperty(value = "자체문화행사 여부(Y:사용, N:미사용)")
	String clturEventAt;
	@ApiModelProperty(value = "자체문화행사명")
	String clturEvent;
	@ApiModelProperty(value = "체험프로그램 여부(Y:사용, N:미사용)")
	String exprnProgrmAt;
	@ApiModelProperty(value = "체험프로그램명")
	String exprnProgrm;
	@ApiModelProperty(value = "소화기 개수")
	String extshrCo;
	@ApiModelProperty(value = "방화수 개수")
	String frprvtWrppCo;
	@ApiModelProperty(value = "방화사 개수")
	String frprvtSandCo;
	@ApiModelProperty(value = "화재감지기 개수")
	String fireSensorCo;
	@ApiModelProperty(value = "테마환경")
	String themaEnvrnCl;
	@ApiModelProperty(value = "캠핑장비대여")
	String eqpmnLendCl;
	@ApiModelProperty(value = "애완동물출입")
	String animalCmgCl;
	@ApiModelProperty(value = "여행시기")
	String tourEraCl;
	@ApiModelProperty(value = "대표이미지")
	String firstImageUrl;
	@ApiModelProperty(value = "등록일")
	String createdtime;
	@ApiModelProperty(value = "수정일")
	String modifiedtime;

	@ApiModelProperty(value = "거리(km)")
	double distance;
}
