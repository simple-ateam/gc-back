package com.ateam.gc.common;

public class Constant {
	public static final int COMMON_JOB_SEC = 86400000;
	public static final String API_GO_CAMP_LIST = "go_camp_list:";
	public static final String API_TOTAL_PAGE_COUNT = "go_camp_total_page_count";
	public static final String API_GO_CAMP_CALL_DATE = "go_camp_call_date";

	public static final String API_ENCODING_TYPE = "UTF-8";
	public static final String DESC_SUCCESS = "정상 처리되었습니다.";
	public static final String ERROR_DESC = "에러 입니다.";

	private Constant() {
		throw new IllegalStateException("Utility class");
	}
}
