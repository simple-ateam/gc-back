package com.ateam.gc.service;

import com.ateam.gc.dto.GoCampingItem;

import java.util.List;

public interface MapService {
	List<GoCampingItem> findResult(double kilometer, double mapY, double mapX);
}
