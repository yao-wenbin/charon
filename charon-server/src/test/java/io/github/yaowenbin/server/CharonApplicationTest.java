package io.github.yaowenbin.server;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CharonApplicationTest extends UnitTest {

    public static final String START_ARGS = "--spring.config.additional-location=file:{}";

    @Test
    void checkIfConfigFilePathExists() {
        assertDoesNotThrow(() -> {
            CharonApplication.checkForArgs(START_ARGS);
        });
    }

    @Test
    void checkIfConfigFilePathNotExists() {
        assertThrows(RuntimeException.class, () -> {
            CharonApplication.checkForArgs("");
        });
    }

}
