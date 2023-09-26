package io.github.yaowenbin.server.alert.alerter;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
public class WeixinAlerter implements WebhookAlerter{

    private String webhook;
    private RestTemplate restTemplate;

    public WeixinAlerter(String webhook) {
        this.webhook = webhook;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Type type() {
        return Type.WEIXIN;
    }


    @Override
    public String webhook() {
        return webhook;
    }

    @Override
    public void sendAlert(AlerterMessage message) {
        JSONObject param = buildParam(message.getMessage());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JSONObject> entity = new HttpEntity<>(param, header);
        ResponseEntity<JSONObject> response = restTemplate.postForEntity(webhook, entity, JSONObject.class);

        log.info("alerter msg send success by alerter: {}, response message: {}, response code: {}, ",
                type(), Optional.ofNullable(response.getBody()).map(body -> body.get("msg")) ,response.getStatusCode());
    }

    /**
     * convert String type msg into wexin Webhook API's param.
     * {
     *     	"msgtype": "text",
     *     	"text": {
     *         	"content": REAL MSG.
     *      }
     * }
     * more detail check <a href="https://developer.work.weixin.qq.com/document/path/91770#%E5%A6%82%E4%BD%95%E4%BD%BF%E7%94%A8%E7%BE%A4%E6%9C%BA%E5%99%A8%E4%BA%BA">企业微信群机器人配置说明</a>
     *
     */
    JSONObject buildParam(String msg) {
        JSONObject text = new JSONObject();
        text.put("content", msg);

        JSONObject res = new JSONObject();
        res.put("text", text);
        res.put("msgtype", "text");

        return res;
    }

}
