package to.us.resume_builder.data.resume_components.category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import to.us.resume_builder.business.export_LaTeX.ResumeTemplate;
import to.us.resume_builder.data.resume_components.Bullet;
import to.us.resume_builder.data.resume_components.Resume;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test class for the {@link Category}
 *
 * @author none
 */
public abstract class CategoryTester {
    private static Resume r;
    private static String cid;

    /**
     * Initializes the resume
     */
    @BeforeEach
    public void init() {
        r = new Resume();
    }

    /**
     * Abstract getType checks to make sure the type of the category is expected
     * value
     */
    @Test
    abstract void testGetType();

    /**
     * Verifies that set and get DisplayName work
     */
    @Test
    abstract void testDisplayName();

    /**
     * Verifies that set and get Name work
     */
    @Test
    abstract void testName();

}
