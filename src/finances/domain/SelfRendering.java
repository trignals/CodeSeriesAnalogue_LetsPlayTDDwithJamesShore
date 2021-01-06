package finances.domain;

import finances.ui.RenderSubject;
import finances.util.Resource;

public interface SelfRendering {

    void render(Resource resource, RenderSubject subject);
}
