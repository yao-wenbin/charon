package io.github.yaowenbin.server.refresh;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Refresh.class)
public class RefreshAutoConfiguration {

    @Bean
    public RefreshScope refreshScope() {
        return new RefreshScope();
    }

}
