package com.ateam.gc.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoCampingItem {
	String contentId;
	// 콘텐츠 ID

	String facltNm;
	// 야영장명

	String lineIntro;
	//한줄소개

	String intro;
//	소개

	String allar;
//	전체면적

	String insrncAt;
//	영업배상책임보험 가입여부(Y:사용, N:미사용)

	String trsagntNo;
//	관광사업자번호

	String bizrno;
//	사업자번호

	String facltDivNm;
//	사업주체.구분

	String mangeDivNm;
//운영주체.관리주체 (직영, 위탁)

	String mgcDiv;
//	운영기관.관리기관

	String manageSttus;
//	운영상태.관리상태

	String hvofBgnde;
//	휴장기간.휴무기간 시작일

	String hvofEnddle;
//	휴장기간.휴무기간 종료일

	String featureNm;
//	특징

	String induty;
//	업종

	String lctCl;
//	입지구분

	String doNm;
//	도

	String sigunguNm;
//	시군구

	String zipcode;
//	우편번호

	String addr1;
//	주소

	String addr2;
	//	주소상세
	String mapX;
	//경도(X)
	String mapY;
	//위도(Y)
	String direction;
	//오시는 길 컨텐츠
	String tel;
	//전화
	String homepage;
	//홈페이지
	String resveUrl;
	//예약 페이지
	String resveCl;
	//예약 구분
	String manageNmpr;
	//상주관리인원
	String gnrlSiteCo;
	//주요시설 일반야영장
	String autoSiteCo;
	//주요시설 자동차야영장
	String glampSiteCo;
	//주요시설 글램핑
	String caravSiteCo;
	//주요시설 카라반
	String indvdlCaravSiteCo;
	//주요시설 개인 카라반
	String sitedStnc;
	//사이트간 거리
	String siteMg1Width;
	//사이트 크기1 가로
	String siteMg2Width;
	//사이트 크기2 가로
	String siteMg3Width;
	//사이트 크기3 가로
	String siteMg1Vrticl;
	//사이트 크기1 세로
	String siteMg2Vrticl;
	//사이트 크기2 세로
	String siteMg3Vrticl;
	//사이트 크기3 세로
	String siteMg1Co;
	//사이트 크기1 수량
	String siteMg2Co;
	//사이트 크기2 수량
	String siteMg3Co;
	//사이트 크기3 수량
	String siteBottomCl1;
	//잔디
	String siteBottomCl2;
	//파쇄석
	String siteBottomCl3;
	//테크
	String siteBottomCl4;
	//자갈
	String siteBottomCl5;
	//맨흙
	String tooltip;
	//툴팁
	String glampInnerFclty;
	//글램핑 - 내부시설
	String caravInnerFclty;
	//카라반 - 내부시설
	String prmisnDe;
	//인허가일자
	String operPdCl;
	//운영기간
	String operDeCl;
	//운영일
	String trlerAcmpnyAt;
	//개인 트레일러 동반 여부(Y:사용, N:미사용)
	String caravAcmpnyAt;
	//개인 카라반 동반 여부(Y:사용, N:미사용)
	String toiletCo;
	//화장실 개수
	String swrmCo;
	//샤워실 개수
	String wtrplCo;
	//개수대 개수
	String brazierCl;
	//화로대
	String sbrsCl;
	//부대시설
	String sbrsEtc;
	//부대시설 기타
	String posblFcltyCl;
	//주변이용가능시설
	String posblFcltyEtc;
	//주변이용가능시설 기타
	String clturEventAt;
	//자체문화행사 여부(Y:사용, N:미사용)
	String clturEvent;
	//자체문화행사명
	String exprnProgrmAt;
	//체험프로그램 여부(Y:사용, N:미사용)
	String exprnProgrm;
	//체험프로그램명
	String extshrCo;
	//소화기 개수
	String frprvtWrppCo;
	//방화수 개수
	String frprvtSandCo;
	//방화사 개수
	String fireSensorCo;
	//화재감지기 개수
	String themaEnvrnCl;
	//테마환경
	String eqpmnLendCl;
	//캠핑장비대여
	String animalCmgCl;
	//애완동물출입
	String tourEraCl;
	//여행시기
	String firstImageUrl;
	//대표이미지
	String createdtime;
	//등록일
	String modifiedtime;
	//	//	//수정일
}
