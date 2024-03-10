import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;

public class MyButton extends JButton implements ActionListener {
    
    JLabel label;

    public MyButton(String text) {
        // Configure button
        this.setText(text);
        this.setFocusable(false);
        this.setIcon(new ImageIcon("images/rewind48.png"));
        //this.setHorizontalTextPosition(JButton.CENTER);
        //this.setVerticalTextPosition(JButton.BOTTOM);
        //this.setFont(new Font("Comic Sans", Font.BOLD, 25));
        //this.setIconTextGap(-2);
        //this.setForeground(Color.blue);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.addActionListener(this);

        // Inicialización de la etiqueta
        label = new JLabel();
        label.setVisible(false); // Inicialmente no visible
        // Aquí puedes agregar la etiqueta a tu frame o panel
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acciones a realizar cuando se presiona el botón
        label.setVisible(true);
        
    }
}
