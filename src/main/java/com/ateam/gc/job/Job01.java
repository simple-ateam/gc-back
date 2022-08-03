package com.ateam.gc.job;

import com.ateam.gc.common.Constant;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Job01 {

	private static final Logger logger = LoggerFactory.getLogger(Job01.class);

	@Scheduled(fixedDelay = Constant.COMMON_JOB_SEC)
	public void runJob() {
		logger.info("HI");
	}
}
