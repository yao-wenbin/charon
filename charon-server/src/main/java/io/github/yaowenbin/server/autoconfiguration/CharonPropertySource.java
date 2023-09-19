package io.github.yaowenbin.server.autoconfiguration;

import org.springframework.core.env.MapPropertySource;

import java.util.Collections;
import java.util.Map;

public class CharonPropertySource extends MapPropertySource {

    private static Map<String, Object> data = Collections.emptyMap();

    public CharonPropertySource() {
        super("CharonPropertySource", data);
    }

    @Override
    public Object getProperty(String name) {
        Object o = data.get(name);
        if (null != o) {
            return o;
        }
        return super.getProperty(name);
    }

    @Override
    public boolean containsProperty(String name) {
        if (data.containsKey(name)) {
            return true;
        }
        return super.containsProperty(name);
    }

}
