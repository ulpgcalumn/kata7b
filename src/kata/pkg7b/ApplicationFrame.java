package kata.pkg7b;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame{
    
    private static String ROOT = "C:\\Users\\Public\\Pictures\\Sample Pictures";
    private String[] images = {"desert.jpg", "jellyfish.jpg", "koala.jpg", "penguins.jpg"};
    private int imageIndex = -1;
    private ImagePanel imagePanel;

    public ApplicationFrame() {
        super("Image viewer");
        this.setSize(1024, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        drawNextImage();
        this.setVisible(true);
        
    }

    private void createComponents() {
        this.add(createImagePanel());
        this.add(createToolbar(), BorderLayout.SOUTH);
    }
    
    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createPrevButton());
        panel.add(createNextButton());
        return panel;
    }
    
    private JButton createPrevButton() {
        JButton button = new JButton("Prev");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                drawPrevImage();
            }
        });
        return button;
    }
    
    private void drawPrevImage(){
        imageIndex = (imageIndex - 1 + images.length) % images.length;
        setCurrentImage(imageIndex);
    }
    
    private JButton createNextButton() {
        JButton button = new JButton("Next");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                drawNextImage();
            }
        });
        return button;
    }
    
    private void drawNextImage() {
        imageIndex = (imageIndex + 1) % images.length;
        setCurrentImage(imageIndex);
    }

    private void setCurrentImage(int index) {
        imagePanel.setImage(ImageLoader.load(ROOT + "/" + images[index]));
    }

    private ImagePanel createImagePanel() {
        imagePanel = new ImagePanel();
        return imagePanel;
    }
    
}
