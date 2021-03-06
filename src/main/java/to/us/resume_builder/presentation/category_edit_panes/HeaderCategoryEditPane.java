package to.us.resume_builder.presentation.category_edit_panes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import to.us.resume_builder.data.resume_components.category.HeaderCategory;


/**
 * Facilitates editing of the HeaderCategory resume component.
 *
 * @author Brooklynn Stone
 */
public class HeaderCategoryEditPane extends CategoryEditPane {
    /** SerialUID, valid as of Iteration 3 of development (4/30/2020) */
    private static final long serialVersionUID = 8917865735485157487L;
    
    /**
     * Logs saving a HeaderCategoryEditPane
     */
    private static final Logger LOG = Logger.getLogger(HeaderCategoryEditPane.class.getName());

    /**
     * An array of each of the editable Text Fields for a Header Category. 0:
     * Link 1: Email, 2: Phone Number
     */
    private JTextField fields[];
    /**
     * A JTextArea which can hold multi-line addresses from the user
     */
    private JTextArea address;
    /**
     * The Header Category to display
     */
    private transient HeaderCategory headerCategory;

    /**
     * Constructor for Header Category edit pane which displays each of the
     * Header fields in a UI
     *
     * @param hc The HeaderCategory that is being displayed.
     */
    public HeaderCategoryEditPane(HeaderCategory hc) {
        this.setLayout(new BorderLayout());

        headerCategory = hc;

        // Button for removing Header Category
        JPanel info = new JPanel(new GridBagLayout());
        info.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;

        // Initialize each text field
        fields = new JTextField[] {
            new JTextField(hc.getLink(), SwingConstants.LEFT),
            new JTextField(hc.getEmail(), SwingConstants.LEFT),
            new JTextField(hc.getPhoneNumber(), SwingConstants.LEFT)
        };

        // Address text area with default 2 lines
        address = new JTextArea(hc.getAddress());
        address.setLineWrap(true);
        address.setWrapStyleWord(true);
        address.setRows(2);
        address.setBorder(fields[0].getBorder());

        // Labels for each editable field
        JLabel labels[] = {
            new JLabel("Link: ", SwingConstants.LEFT),
            new JLabel("Email: ", SwingConstants.LEFT),
            new JLabel("Phone Number: ", SwingConstants.LEFT),
            new JLabel("Address: ", SwingConstants.LEFT)
        };

        // Starting X and Y for elements in the Panel
        int xPos = 0;
        int yPos = 0;

        grid.gridwidth = 1;
        grid.gridx = xPos;

        // Iterate through each text field and add it to the information panel
        for (int i = 0; i < fields.length; i++) {
            fields[i].setMinimumSize(new Dimension(200, fields[i].getHeight()));
            fields[i].setMaximumSize(new Dimension(this.getWidth(), fields[i].getHeight()));

            labels[i].setLabelFor(fields[i]);

            grid.gridwidth = 1;
            grid.weightx = 0;
            grid.gridx = xPos;
            grid.gridy = yPos++;
            info.add(labels[i], grid);

            grid.gridwidth = 2;
            grid.weightx = 1;
            grid.gridx = xPos + 1;
            info.add(fields[i], grid);
        }

        // Add address label and text area
        grid.gridwidth = 1;
        grid.weightx = 0;
        grid.gridx = xPos;
        grid.gridy = yPos;
        info.add(labels[3], grid);

        grid.gridwidth = 2;
        grid.weightx = 1;
        grid.gridx = xPos + 1;
        info.add(address, grid);

        // Set ScrollPane
        JScrollPane scrollPane = new JScrollPane(info);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        this.add(scrollPane, BorderLayout.NORTH);
    }

    /**
     * Saves information in each of the fields of the Header Category Edit Pane
     * to the Header Category
     */
    @Override
    public void save() {
        LOG.logp(Level.INFO, HeaderCategoryEditPane.class.getName(), "save", "saving link, email, phone number, address");
        headerCategory.setLink(fields[0].getText());
        headerCategory.setEmail(fields[1].getText());
        headerCategory.setPhoneNumber(fields[2].getText());
        headerCategory.setAddress(address.getText());
    }

    /**
     * Determines if the current Header Category has been modified
     *
     * @return boolean indicating whether the Category was edited by the user
     */
    @Override
    public boolean isModified() {
        if (headerCategory.getLink().equals(fields[0].getText()) &&
            headerCategory.getEmail().equals(fields[1].getText()) &&
            headerCategory.getPhoneNumber().equals(fields[2].getText()) &&
            headerCategory.getAddress().equals(address.getText()))
            return false;
        return true;
    }
}
