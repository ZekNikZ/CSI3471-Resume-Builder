package to.us.resume_builder.presentation.components;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class allows a table cell to have two rows.
 *
 * @author Matthew McCaskill
 */
public class MultilineCellRenderer extends JTextArea implements TableCellRenderer {
    /**
     * Logs information about the TableCellRenderer
     */
    private static final Logger LOG = Logger.getLogger(MultilineCellRenderer.class.getName());

    /**
     * Constructs a <code>MultilineCellRenderer</code>
     */
    public MultilineCellRenderer() {
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setOpaque(true);
        this.setRows(2);
    }

    /**
     * Returns the component used for drawing the cell.  This method is used to
     * configure the renderer appropriately before drawing.
     * <p>
     * The <code>TableCellRenderer</code> is also responsible for rendering the
     * the cell representing the table's current DnD drop location if it has
     * one. If this renderer cares about rendering the DnD drop location, it
     * should query the table directly to see if the given row and column
     * represent the drop location:
     * <pre>
     *     JTable.DropLocation dropLocation = table.getDropLocation();
     *     if (dropLocation != null
     *             &amp;&amp; !dropLocation.isInsertRow()
     *             &amp;&amp; !dropLocation.isInsertColumn()
     *             &amp;&amp; dropLocation.getRow() == row
     *             &amp;&amp; dropLocation.getColumn() == column) {
     *
     *         // this cell represents the current drop location
     *         // so render it specially, perhaps with a different color
     *     }
     * </pre>
     * <p>
     * During a printing operation, this method will be called with
     * <code>isSelected</code> and <code>hasFocus</code> values of
     * <code>false</code> to prevent selection and focus from appearing
     * in the printed output. To do other customization based on whether or not
     * the table is being printed, check the return value from {@link
     * javax.swing.JComponent#isPaintingForPrint()}.
     *
     * @param table      the <code>JTable</code> that is asking the renderer to
     *                   draw; can be <code>null</code>
     * @param value      the value of the cell to be rendered.  It is up to the
     *                   specific renderer to interpret and draw the value.  For
     *                   example, if
     *                   <code>value</code>
     *                   is the string "true", it could be rendered as a string
     *                   or it could be rendered as a check box that is checked.
     *                   <code>null</code> is a valid value
     * @param isSelected true if the cell is to be rendered with the selection
     *                   highlighted; otherwise false
     * @param hasFocus   if true, render cell appropriately.  For example, put a
     *                   special border on the cell, if the cell can be edited,
     *                   render in the color used to indicate editing
     * @param row        the row index of the cell being drawn.  When drawing
     *                   the header, the value of
     *                   <code>row</code> is -1
     * @param column     the column index of the cell being drawn
     *
     * @return the component used for drawing the cell.
     * @see javax.swing.JComponent#isPaintingForPrint()
     */
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Change the background color depending on whether the cell is selected or not.
        if (isSelected) {
            this.setForeground(table.getSelectionForeground());
            this.setBackground(table.getSelectionBackground());
        } else {
            this.setForeground(table.getForeground());
            this.setBackground(table.getBackground());
        }

        // Set other options of the text area
        this.setFont(table.getFont());
        this.setText((value == null) ? "[New Bullet]" : value.toString());

        LOG.logp(Level.FINE, MultilineCellRenderer.class.getName(), "getTableCellRendererComponent", "returning table cell renderer");
        // Return this text area
        return this;
    }
}