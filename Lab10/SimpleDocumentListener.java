package Lab10;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@FunctionalInterface
public interface SimpleDocumentListener extends DocumentListener {

    void onTextChanged(DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
        onTextChanged(e);
    }
    @Override
    default void removeUpdate(DocumentEvent e) {
        onTextChanged(e);
    }
    @Override
    default void changedUpdate(DocumentEvent e) {
        onTextChanged(e);
    }
}
