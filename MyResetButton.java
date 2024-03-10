import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import java.awt.Font;
import javax.swing.BorderFactory;

public class MyResetButton extends JButton implements ActionListener {
    private ButtonClickListener listener; // Agregar un campo para el listener

    
    JLabel label;
    

    public MyResetButton(String text, ButtonClickListener listener) {
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
        this.listener = listener;

        // Inicialización de la etiqueta
        label = new JLabel();
        label.setVisible(false); // Inicialmente no visible
        // Aquí puedes agregar la etiqueta a tu frame o panel
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (listener != null) {
            listener.onButtonClick(); // Llamar al método del listener
        }
    }
}

// La interfaz ButtonClickListener para manejar los clics del botón
interface ButtonClickListener {
    void onButtonClick();
}