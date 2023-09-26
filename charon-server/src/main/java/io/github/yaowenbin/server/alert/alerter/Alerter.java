package io.github.yaowenbin.server.alert.alerter;

import io.github.yaowenbin.commons.string.Strings;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface Alerter {

    Type type();

    CompletableFuture<Void> sendAlert(AlerterMessage message);

    enum Type {
        DING,
        FEISHU,
        WEIXIN,
        MAIL;

        public boolean equalsIgnoreCase(String val) {
            return Strings.equalsIgnoreCase(name(), val);
        }

        public static Optional<Type> of(String val) {
            for (Type type : Type.values()) {
                if (type.equalsIgnoreCase(val)) {
                    return Optional.of(type);
                }
            }
            return Optional.empty();
        }


    }

}
