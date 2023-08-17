package io.github.yaowenbin.starter.core;

import io.github.yaowenbin.starter.UnitTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yaowenbin
 * @Date 2023/8/17
 */
class CommandTest extends UnitTest {

    @Test
    void load() {
        String[] args = new String[]{"-c", "yaowenbin", "-u", "really"};

        Commands commands = Commands.load(args);
        assertThat(commands.get(CONFIG_PATH)).isEqualTo("yaowenbin");
    }

}