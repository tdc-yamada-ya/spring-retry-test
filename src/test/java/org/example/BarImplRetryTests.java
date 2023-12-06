package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BarImplRetryTests {
    @Autowired
    private Bar bar;

    @MockBean
    private Baz baz;

    @Test
    public void retry() {
        Mockito.doThrow(new RuntimeException()).when(baz).baz();
        bar.bar();
        Mockito.verify(baz, Mockito.times(3)).baz();
    }
}
