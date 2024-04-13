package com.unsubble.assertj._01;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ExceptionsAssertJ {

    @Test
    void throwTest() {
        assertThatThrownBy(() -> {throw new RuntimeException();}).isInstanceOf(RuntimeException.class)
                .hasStackTraceContaining("Runtime");
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {throw new RuntimeException();})
                .isInstanceOf(RuntimeException.class);
        assertThatRuntimeException().isThrownBy(() -> {throw new RuntimeException();}).isInstanceOf(RuntimeException.class);
    }
}
