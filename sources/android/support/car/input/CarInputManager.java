package android.support.car.input;

import android.widget.EditText;

public abstract class CarInputManager {
    public abstract boolean isCurrentCarEditable(EditText editText);

    public abstract boolean isInputActive();

    public abstract boolean isValid();

    public abstract void startInput(EditText editText);

    public abstract void stopInput();
}
