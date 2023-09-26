package io.github.yaowenbin.server.alert.alerter;

import io.github.yaowenbin.server.SpringContextTest;
import io.github.yaowenbin.server.UnitTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlerterTest extends SpringContextTest {

    @Resource
    Alerter alerter;

    @Test
    void alerter() {
        assertThat(alerter).isNotNull();
        assertThat(alerter).isInstanceOf(FeishuAlerter.class);

    }

}

class AlerterTypeTest extends UnitTest {

    @Test
    void equalsIgnoreCase() {
        assertTrue(Alerter.Type.FEISHU.equalsIgnoreCase("feishu"));
        assertTrue(Alerter.Type.FEISHU.equalsIgnoreCase("FeiSHU"));
    }
}
