package finances.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class RequireTest {

    @Test
    public void that() {
        try {
            Require.that(false, "some message");
            fail("expected exception");
        } catch (RequireException e) {
            assertEquals("some message", e.getMessage());
        }
    }

}

