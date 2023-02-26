package android.support.car.input;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public interface CarEditable {
    InputConnection onCreateInputConnection(EditorInfo editorInfo);

    void setCarEditableListener(CarEditableListener carEditableListener);

    void setInputEnabled(boolean z);
}
