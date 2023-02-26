package com.google.android.gms.car.input;

public interface InputManager {
    boolean isCurrentCarEditable(CarEditable carEditable);

    boolean isInputActive();

    boolean isValid();

    void startInput(CarEditable carEditable);

    void stopInput();
}
