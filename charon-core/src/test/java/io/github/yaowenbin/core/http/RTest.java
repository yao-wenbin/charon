package io.github.yaowenbin.core.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.yaowenbin.commons.map.Maps;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RTest {

    ObjectMapper serializer = new ObjectMapper();

    @Test
    void serializable_success() throws JsonProcessingException {
        R<Object> result = R.success();
        String json = serializer.writeValueAsString(result);

        JsonNode jsonNode = serializer.readTree(json);
        assertEquals(200, jsonNode.get("code").asInt());
        assertEquals("success", jsonNode.get("msg").asText());
        assertTrue(jsonNode.get("data").isNull());

        Map<Object, Object> data = Maps.builder().put("id", 1L).put("name", "foo").build();
        result = R.success(data);
        json = serializer.writeValueAsString(result);
        jsonNode = serializer.readTree(json);
        assertEquals(200, jsonNode.get("code").asInt());
        assertEquals("success", jsonNode.get("msg").asText());
        assertEquals(1L, jsonNode.get("data").get("id").asLong());
        assertEquals("foo", jsonNode.get("data").get("name").asText());
    }

    @Test
    void serializable_failed() throws JsonProcessingException {
        R<Object> result = R.failed();
        String json = serializer.writeValueAsString(result);

        JsonNode jsonNode = serializer.readTree(json);
        assertEquals(500, jsonNode.get("code").asInt());
        assertEquals("server internal error, please contact administrator", jsonNode.get("msg").asText());
        assertTrue(jsonNode.get("data").isNull());

        String failedMsg = "you cannot do this";
        result = R.failed(failedMsg);
        json = serializer.writeValueAsString(result);
        jsonNode = serializer.readTree(json);
        assertEquals(500, jsonNode.get("code").asInt());
        assertEquals("you cannot do this", jsonNode.get("msg").asText());
        assertTrue(jsonNode.get("data").isNull());
    }


}