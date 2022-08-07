package com.ateam.gc.util;

import com.ateam.gc.dto.GoCampSearchResDTO;

import java.util.Comparator;

public class DistanceComparator implements Comparator<GoCampSearchResDTO> {
	@Override
	public int compare(GoCampSearchResDTO f1, GoCampSearchResDTO f2) {
		if (f1.getDistance() > f2.getDistance()) {
			return 1;
		} else if (f1.getDistance() < f2.getDistance()) {
			return -1;
		}
		return 0;
	}
}
