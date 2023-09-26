package io.github.yaowenbin.server.alert.alerter;

public interface Alerter {

    Type type();

    void sendAlert(AlerterMessage message);

    enum Type {
        DING("ding"),
        FEISHU("feishu"),
        WETALK("wexin"),
        MAIL("mail");

        private final String val;

        Type(String val) {
            this.val = val;
        }

        boolean equals(String val) {
            return this.val.equals(val);
        }
    }

}
