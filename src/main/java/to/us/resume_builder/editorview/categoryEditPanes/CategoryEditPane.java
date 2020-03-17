package to.us.resume_builder.editorview.categoryEditPanes;

import to.us.resume_builder.resume_components.category.Category;

import javax.swing.*;

/**
 * Standard interface between the main Resume Editor panel and the editor
 * subcomponents (e.g., editor for a bulleted list, the header, etc.).
 * 
 * @author Micah
 */
public abstract class CategoryEditPane extends JPanel {

	/**
	 * Version on 2/21.
	 */
	private static final long serialVersionUID = 3001154674271049780L;

	/**
	 * JPanel which we will add the separate JPanels from
	 */
	protected JPanel contents;
	protected JTextField name;
	protected JTextField displayName;

	public void editPane(Category category) {

		JTextField name = new JTextField(category.getName());
		JTextField displayName = new JTextField(category.getDisplayName());

		contents = new JPanel();
	}

	/**
	 * Saves the data in this EditPane to the copy of the ResumeData <em>in
	 * RAM</em>.
	 */
	public abstract void save();

	/**
	 * Determines if the current Category has been modified
	 * @return boolean indicating whether the Category was edited
	 */
	public abstract boolean isModified();
}
