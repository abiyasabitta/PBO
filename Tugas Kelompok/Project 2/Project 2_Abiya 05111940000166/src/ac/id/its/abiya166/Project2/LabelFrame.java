package ac.id.its.abiya166.Project2;

import javax.swing.*;
import java.awt.*;

public class LabelFrame extends JLabel {
    private final JLabel biodata;

    public LabelFrame(){
        setLayout(new FlowLayout());

        ImageIcon foto = new ImageIcon(getClass().getResource("/image/3x4.jpg"));
        biodata = new JLabel();
        biodata.setText("Abiya Sabitta Ragadani (05111940000166)");
        biodata.setIcon(foto);
        biodata.setHorizontalTextPosition(SwingConstants.CENTER);
        biodata.setVerticalTextPosition(SwingConstants.BOTTOM);
        biodata.setToolTipText("This is my photo");
        add(biodata);

    }
}
