package com.jonas.one.task;

import com.jonas.one.common.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenScheduledTask {
    private static Logger logger = LoggerFactory.getLogger(TokenScheduledTask.class);

    public final static long ONE_Minute = 60 * 1000 * 60 * 1;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 刷新Token
     */
    @Scheduled(fixedDelay = ONE_Minute)
    public void reloadApiToken() {
        String token = this.getToken();
        while (StringUtils.isBlank(token)) {
            try {
                Thread.sleep(1000);
                token = this.getToken();
            } catch (InterruptedException e) {
                logger.error("", e);
            }
        }
        System.setProperty("fangjia.auth.token", token);
        logger.info("申请token成功 :{}", token);
    }

    public String getToken() {
        ResponseEntity<ResponseData> responseEntity =
                restTemplate.getForEntity("http://service-one/oauth/token?accessKey=111&secretKey=111",ResponseData.class);
        ResponseData response = responseEntity.getBody();
        return response.getData() == null ? "" : response.getData().toString();
    }
}
