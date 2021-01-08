package finances.ui;

import finances.domain.InvalidYear;
import finances.domain.ValidYear;
import finances.domain.Year;
import finances.util.Resource;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Calendar;

// If you want to subclass this class, it's okay to remove the 'final designator, but be careful of potential race
// conditions with the event handler in the constructor. It could execute before the subclass constructor.
public final class YearInputField extends JTextField {
    private static final long serialVersionID = 1L;

    private static class YearInputFieldRenderSubjectAdapter implements RenderSubject {
        private YearInputField field;

        public YearInputFieldRenderSubjectAdapter(YearInputField field) {
            this.field = field;
        }

        @Override
        public void setText(String text) {
        }

        @Override
        public void setIcon(Icon icon) {
        }

        @Override
        public void setToolTipText(String text) {
        }

        @Override
        public void setForegroundColor(Color color) {
            field.setForeground(color);
        }
    }


    public YearInputField(Year initialValue) {
        this.setText(initialValue.toString());
        addTextChangedListener(new ChangeListener() {
                                   public void textChanged() {
                                       getYear().render(new Resource(), new YearInputFieldRenderSubjectAdapter(YearInputField.this));
                                   }
                               }
        );
    }


    public Year getYear() {
        return Year.parse(getText());
    }

    public void addTextChangedListener(ChangeListener listener) {
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                render();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                render();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                render();
            }

            private void render() {
                listener.textChanged();
            }
        });
    }

    public interface ChangeListener {
        public void textChanged();
    }
}
