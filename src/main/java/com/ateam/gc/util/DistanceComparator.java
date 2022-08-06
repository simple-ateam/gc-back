package com.ateam.gc.util;

import com.ateam.gc.dto.GoCampingItem;

import java.util.Comparator;

public class DistanceComparator implements Comparator<GoCampingItem> {
	@Override
	public int compare(GoCampingItem f1, GoCampingItem f2) {
		if (f1.getDistance() > f2.getDistance()) {
			return 1;
		} else if (f1.getDistance() < f2.getDistance()) {
			return -1;
		}
		return 0;
	}
}
