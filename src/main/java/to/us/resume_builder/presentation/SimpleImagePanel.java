package to.us.resume_builder.presentation;

import javax.swing.*;

import to.us.resume_builder.business.util.ImageCache;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class SimpleImagePanel extends JPanel {
    /**
     *
     */
    private static Logger LOGGER = Logger.getLogger(SimpleImagePanel.class.getName());

    /**
     *
     */
    private final Image image;

    /**
     *
     */
    private final float scale;

    /**
     * Constructor for the SimpleImagePanel with a path
     * @param path path to the specified image
     */
    public SimpleImagePanel(String path) {
        this(path, 1.0f);
    }

    /**
     * Constructs a SimpleImagePanel with a path and scale
     * @param path path to the specified image
     * @param scale the scale to create the image width
     */
    public SimpleImagePanel(String path, float scale) {
        this.scale = scale;
        
        Image img = ImageCache.getInstance().getImage(path);
        image = img.getScaledInstance(img.getWidth(this), img.getHeight(this), Image.SCALE_DEFAULT);
        this.setSize(new Dimension(image.getHeight(this), image.getWidth(this)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int imgWidth =  (int) (image.getWidth(this) * scale);
        int imgHeight = (int) (image.getHeight(this) * scale);

        LOGGER.logp(Level.INFO, SimpleImagePanel.class.getName(), "paintComponent", "drawing image panel");
        g.drawImage(image, (this.getWidth() - imgWidth) / 2, (this.getHeight() - imgHeight) / 2, imgWidth, imgHeight, this);
    }
}