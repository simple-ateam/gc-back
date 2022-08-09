package com.ateam.gc.service;

import com.ateam.gc.dto.GoCampSearchReqDTO;
import com.ateam.gc.dto.GoCampDetailResDTO;
import com.ateam.gc.dto.GoCampSearchResDTO;
import com.ateam.gc.service.common.EmptyDataException;

import java.util.List;

public interface MapService {
	List<GoCampSearchResDTO> findResult(GoCampSearchReqDTO param);
	GoCampDetailResDTO getDetail(Integer contentId) throws EmptyDataException;
}
