package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class BarImpl implements Bar {
    private final Baz baz;

    @Autowired
    public BarImpl(Baz baz) {
        this.baz = baz;
    }

    @Retryable(retryFor = Exception.class, maxAttempts = 3)
    public void bar() {
        System.out.println("bar");
        baz.baz();
    }

    @Recover
    public void recover() {
        System.out.println("recover");
    }
}
