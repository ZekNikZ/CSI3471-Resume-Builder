package to.us.resume_builder.file;

import java.util.Date;

/**
 * This class contains metadata for a resume, such as the User attached to it
 * and when it was created and last modified.
 *
 * @author Jacob
 */
public class Metadata {

    // When the Resume was created
    private Date created;

    // When the Resume was last changed
    private Date lastModified;

    // The User attached to the Resume
//    private User user;

    /**
     * Creates a Metadata object with the given parameters.
     *
     * @param user The user attached to the Resume
     * @param created When the Resume was created
     * @param lastModified When the Resume was last modified.
     */
//    public Metadata(User user, Calendar created, Calendar lastModified) {
//        this.user = user;
//        this.created = created;
//        this.lastModified = lastModified;
//    }
}
