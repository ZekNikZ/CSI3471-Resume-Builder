package to.us.resume_builder.export;

/**
 * Implementing this interface indicates that the class is LaTeX-serializable
 * through the use of a {@link ResumeTemplate}.
 */
public interface ILaTeXConvertable {
    /**
     * Get the result of serializing this object using the specified template.
     *
     * @param template The template to format this object with.
     *
     * @return A String representing the object in the LaTeX template.
     */
    String formatLaTeXString(ResumeTemplate template);
}
