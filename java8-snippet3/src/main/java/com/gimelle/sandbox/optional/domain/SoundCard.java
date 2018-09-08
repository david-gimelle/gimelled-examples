package com.gimelle.sandbox.optional.domain;

import java.util.Optional;

public class SoundCard {

    private Optional<USB> usb = Optional.empty();


    public Optional<USB> getUsb() {
        return usb;
    }

    public SoundCard withUsb(USB usb) {
        this.usb = Optional.of(usb);
        return this;
    }
}
