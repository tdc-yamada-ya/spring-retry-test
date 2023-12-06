package org.example;

import org.springframework.stereotype.Component;

@Component
public class BazImpl implements Baz {
    public void baz() {
        System.out.println("baz");
    }
}
