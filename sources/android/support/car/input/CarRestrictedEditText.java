package android.support.car.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;

public class CarRestrictedEditText extends EditText implements CarEditable {
    private static final boolean SELECTION_CLAMPING_ENABLED = false;
    private CarEditableListener mCarEditableListener;
    private boolean mCursorClamped;
    private int mLastSelEnd = 0;
    private int mLastSelStart = 0;
    /* access modifiers changed from: private */
    public KeyListener mListener;

    public interface KeyListener {
        void onCloseKeyboard();

        void onCommitText(String str);

        void onDelete();

        void onKeyDown(int i);

        void onKeyUp(int i);
    }

    public CarRestrictedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setInputType(getInputType() | 524288);
        setTextIsSelectable(false);
        setSelection(getText().length());
        this.mCursorClamped = true;
        setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (CarRestrictedEditText.this.mListener == null || i != 6) {
                    return false;
                }
                CarRestrictedEditText.this.mListener.onCloseKeyboard();
                return false;
            }
        });
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new InputConnectionWrapper(super.onCreateInputConnection(editorInfo), false) {
            public boolean commitText(CharSequence charSequence, int i) {
                if (CarRestrictedEditText.this.mListener == null) {
                    return super.commitText(charSequence, i);
                }
                CarRestrictedEditText.this.mListener.onCommitText(charSequence.toString());
                return true;
            }

            public boolean deleteSurroundingText(int i, int i2) {
                if (CarRestrictedEditText.this.mListener == null) {
                    return super.deleteSurroundingText(i, i2);
                }
                CarRestrictedEditText.this.mListener.onDelete();
                return true;
            }

            public boolean sendKeyEvent(KeyEvent keyEvent) {
                if (CarRestrictedEditText.this.mListener == null) {
                    return super.sendKeyEvent(keyEvent);
                }
                if (keyEvent.getAction() == 0) {
                    CarRestrictedEditText.this.mListener.onKeyDown(keyEvent.getKeyCode());
                    return true;
                } else if (keyEvent.getAction() != 1) {
                    return true;
                } else {
                    CarRestrictedEditText.this.mListener.onKeyUp(keyEvent.getKeyCode());
                    char unicodeChar = (char) keyEvent.getUnicodeChar();
                    if (!Character.isDigit(unicodeChar)) {
                        return true;
                    }
                    commitText(String.valueOf(unicodeChar), 1);
                    return true;
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i, int i2) {
        if (this.mCursorClamped) {
        }
        if (this.mCarEditableListener != null) {
            this.mCarEditableListener.onUpdateSelection(this.mLastSelStart, this.mLastSelEnd, i, i2);
        }
        this.mLastSelStart = i;
        this.mLastSelEnd = i2;
    }

    public void setCarEditableListener(CarEditableListener carEditableListener) {
        this.mCarEditableListener = carEditableListener;
    }

    public void setInputEnabled(boolean z) {
        this.mCursorClamped = !z;
    }

    public void setKeyListener(KeyListener keyListener) {
        this.mListener = keyListener;
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }
}
