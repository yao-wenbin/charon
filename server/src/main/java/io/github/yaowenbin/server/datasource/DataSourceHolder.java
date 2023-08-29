package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.commons.obj.Objs;
import io.github.yaowenbin.server.core.Strings;
import org.springframework.core.NamedThreadLocal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public class DataSourceHolder {

    private static final ThreadLocal<Deque<String/* dataSourceKey */>> LOOKUP_KEY_HOLDER =
            new NamedThreadLocal<>("datasource-holder") {
                @Override
                protected Deque<String> initialValue() {
                    return new ArrayDeque<>();
                }
            };

    public static String peek() {
        return Objs.getOrDefault(LOOKUP_KEY_HOLDER.get().peek(), Strings.EMPTY);
    }

    public static String push(String dataSourceKey) {
        String valueKey = Objs.getOrDefault(dataSourceKey, Strings.EMPTY);
        LOOKUP_KEY_HOLDER.get().push(valueKey);
        return valueKey;
    }

    public static void poll() {
        LOOKUP_KEY_HOLDER.get().poll();
        if (LOOKUP_KEY_HOLDER.get().isEmpty()) {
            clear();
        }
    }

    public static void clear() {
        LOOKUP_KEY_HOLDER.remove();
    }


}
