// package io.github.yaowenbin.server.autoconfiguration;
//
// import org.apache.logging.log4j.util.Strings;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.env.EnvironmentPostProcessor;
// import org.springframework.core.annotation.Order;
// import org.springframework.core.env.ConfigurableEnvironment;
//
// @Order
// public class CharonEnvironmentPostProcessor implements EnvironmentPostProcessor {
//
//     @Value("${charon-config:}")
//     private String charonConfig;
//
//     @Override
//     public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
//         if (Strings.isEmpty(charonConfig)) {
//             throw new RuntimeException("Please set a charon config path");
//         }
//
//     }
// }
