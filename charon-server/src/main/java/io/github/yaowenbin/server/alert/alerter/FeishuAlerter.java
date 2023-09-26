package io.github.yaowenbin.server.alert.alerter;


import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Alerter that send alert message to Feishu.
 * document reference: <a href="https://open.dingtalk.com/document/orgapp/third-party-robot-access">...</a>
 */


@Slf4j
public class FeishuAlerter implements WebhookAlerter {

    private final String webhookUrl;
    private final RestTemplate restTemplate;

    public FeishuAlerter(String webhookUrl) {
        this.restTemplate = new RestTemplate();
        this.webhookUrl = webhookUrl;

    }

    @Override
    public Type type() {
        return Type.FEISHU;
    }

    @Override
    public String webhook() {
        return webhookUrl;
    }

    @Override
    public void sendAlert(AlerterMessage msg) {
        JSONObject param = buildJSON(msg.getMessage());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JSONObject> entity = new HttpEntity<>(param, header);
        ResponseEntity<JSONObject> response = restTemplate.postForEntity(webhookUrl, entity, JSONObject.class);

        log.info("alerter msg send success by alerter: {}, response message: {}, response code: {}, ",
                type(), Optional.ofNullable(response.getBody()).map(body -> body.get("msg")) ,response.getStatusCode());
    }

    /**
     * convert msg to webhook params type:
     * {
     *     "msg_type": "text",
     *     "content": {
     *         "text": REAL MSG.
     *     }
     * }
     */
    private JSONObject buildJSON(String msg) {
        JSONObject content = new JSONObject();
        content.put("text", msg);

        JSONObject json = new JSONObject();
        json.put("msg_type", "text");
        json.put("content", content);

        return json;
    }


}
