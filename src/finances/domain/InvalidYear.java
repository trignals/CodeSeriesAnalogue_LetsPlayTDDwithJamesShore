package finances.domain;

import finances.ui.RenderSubject;
import finances.util.Resource;

import java.awt.*;

public class InvalidYear extends Year{
    @Override
    public Year subsequentYear() {
        return new InvalidYear();
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String toString() {
        return "INVALID YEAR";
    }

    @Override
    public int hashCode() {
        return 13;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof InvalidYear);
    }

    public void render(Resource resource, RenderSubject subject) {
        subject.setIcon(resource.invalidYearIcon());
        subject.setText(null);
        subject.setToolTipText("Invalid year");
        subject.setForegroundColor(Color.RED);
    }

}
