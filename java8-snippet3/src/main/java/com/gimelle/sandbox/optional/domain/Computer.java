package com.gimelle.sandbox.optional.domain;

import java.util.Optional;

public class Computer {

    private Optional<SoundCard> soundCard = Optional.empty();

    public final String nickName;

    public Computer(String nickName) {
        this.nickName = nickName;
    }

    public Optional<SoundCard> getSoundCard() {
        return soundCard;
    }

    public Computer withSoundCard(SoundCard soundCard) {
        this.soundCard = Optional.of(soundCard);
        return this;
    }
}
