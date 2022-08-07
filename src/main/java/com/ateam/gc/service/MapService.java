package com.ateam.gc.service;

import com.ateam.gc.dto.GoCampSearchReqDTO;
import com.ateam.gc.dto.GoCampingDetailItem;
import com.ateam.gc.dto.GoCampingItem;

import java.util.List;

public interface MapService {
	List<GoCampingItem> findResult(GoCampSearchReqDTO param);
	GoCampingDetailItem getDetail(String contentId);
}
