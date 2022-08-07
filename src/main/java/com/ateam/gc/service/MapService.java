package com.ateam.gc.service;

import com.ateam.gc.dto.GoCampSearchReqDTO;
import com.ateam.gc.dto.GoCampDetailResDTO;
import com.ateam.gc.dto.GoCampSearchResDTO;

import java.util.List;

public interface MapService {
	List<GoCampSearchResDTO> findResult(GoCampSearchReqDTO param);
	GoCampDetailResDTO getDetail(String contentId);
}
