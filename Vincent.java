import java.awt.Toolkit;
import java.awt.Image;
//import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vincent extends JFrame implements MouseListener, ButtonClickListener {

    // declaring panels
    JPanel panelImage;
    JPanel panelText;
    JPanel panelButton;

    // declaring labels
    JLabel labelImage;
    JLabel labelText;

    // declaring audio clips
    Clip clipA;
    File fileA = new File("audio/Song2a.wav");

    Clip clipB;
    File fileB = new File("audio/Song2b.wav");

    // declaring images
    ImageIcon disappointed;
    ImageIcon flushed;
    ImageIcon kiss;
    ImageIcon pleading;
    ImageIcon test;
    ImageIcon smileEyesKiss;
    ImageIcon smileHearts;
    ImageIcon smileFlushed;
    ImageIcon smile;
    Image barIcon;//not working??

    // declaring timer
    Timer timer;

    // declaring boolean values for the if statements
    boolean kissGiven = false;
    boolean happyState = false;

    // declaring custom cursor
    Toolkit toolkit;
    Image lips;
    Cursor customCursor; // this could have been inside the constructor because the override methods
                         // don't have to change it.

    // declaring counter variable
    int counter = 0;

    // declaring button
    MyResetButton button;

    //declaring Font
    Font font;

    // constructor
    Vincent() {
        // frame
        this.setTitle("Vincent 0.2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 300);

        // panels
        panelImage = new JPanel();
        panelText = new JPanel();
        panelButton = new JPanel();
        button = new MyResetButton("", this);
        // setting size of the panels
        panelImage.setPreferredSize(new Dimension(100, 130));
        panelText.setPreferredSize(new Dimension(300, 150));
        panelButton.setPreferredSize(new Dimension(300, 150));
        // labels
        labelImage = new JLabel();
        labelImage.addMouseListener(this);
        // text
        labelText = new JLabel();
        labelText.setText(
                "<html><center>Meet Vincent.<br>He's feeling blue.<br>A sweet kiss might just make his day!</center></html>");
        panelText.add(labelText);

        // images
        disappointed = new ImageIcon("images/disappointed96.png");
        flushed = new ImageIcon("images/flushed96.png");
        kiss = new ImageIcon("images/closed_eyes_kiss96.png");
        pleading = new ImageIcon("images/pleading96.png");
        smileEyesKiss = new ImageIcon("images/smiling_eyes_kiss96.png");
        smileHearts = new ImageIcon("images/smiling_with_hearts96.png");
        smileFlushed = new ImageIcon("images/smilingFaceA96.png");
        smile = new ImageIcon("images/smile96.png");//not working??

        //tab icon 
        barIcon = Toolkit.getDefaultToolkit().getImage("images/barIcon.ico");//not working??


        labelImage.setIcon(disappointed);

        /*
         * // for developement purposes:
         * labelImage.setOpaque(true); // !!!
         * labelImage.setBackground(Color.RED);// !!!
         * 
         * labelText.setOpaque(true);// !!!
         * labelText.setBackground(Color.green);// !!!
         * 
         * panelText.setOpaque(true);// !!!
         * panelText.setBackground(Color.ORANGE);// !!!
         * 
         * panelImage.setOpaque(true);// !!!
         * panelImage.setBackground(Color.BLUE);// !!!
         * 
         * panelButton.setOpaque(true);// !!!
         * panelButton.setBackground(Color.RED);// !!!
         */


         //font
         font = new Font("Arial", Font.BOLD, 14);

        // custom cursor for labelImage
        toolkit = Toolkit.getDefaultToolkit();
        lips = toolkit.getImage("images/kiss32.png");
        customCursor = toolkit.createCustomCursor(lips, new Point(0, 0), "kiss");
        labelImage.setCursor(customCursor);

        //
        this.add(panelImage);
        this.add(panelText);
        this.add(panelButton);
        this.setResizable(false);
        // this.pack();// quit so the window does not "fit" to the elements
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // Layout (organize panels):
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        panelImage.add(labelImage);
        panelText.add(labelText);
        labelText.setFont(font);
        this.setIconImage(barIcon); //not working??

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    // 1__________________________________________________________________________
    @Override
    public void mousePressed(MouseEvent e) {
        panelButton.add(button);

        // disable right mouse button
        if (SwingUtilities.isRightMouseButton(e)) {

            System.out.println("Right mouse button disabled.");

        } else {
            labelText.setText("<html><center>You're giving him a kiss...</center></html>");

            System.out.println("You pressed the mouse");

            // first itineration:
            if (counter == 0) {

                System.out.println("Counter = 0");

                labelImage.setIcon(kiss);

                // adding audio clip
                try {

                    clipA = AudioSystem.getClip();
                    clipA.open(AudioSystem.getAudioInputStream(fileA));

                } catch (Exception f) {
                }
                if (happyState) {

                    clipA = null;// probably unnecessary line of code

                } else {

                    clipA.start();

                }
                // setting timer
                timer = new javax.swing.Timer(2900, new ActionListener() {//
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("The kiss was given");
                        labelImage.setIcon(smileEyesKiss);
                        labelText.setText("<html><center>*mwah*</center></html>");
                        kissGiven = true;
                    }
                });

                timer.setRepeats(false);

                timer.start();

                // second itineration:
            } else if (counter == 1) {
                System.out.println("Counter = 1");

                labelImage.setIcon(kiss);
                labelText.setText("<html><center>Hold tight!<br>Keep pressing to show some love!</center></html>");

                // adding audio
                try {

                    clipB = AudioSystem.getClip();
                    clipB.open(AudioSystem.getAudioInputStream(fileB));

                } catch (Exception f) {
                }

                if (happyState) {

                    clipA = null;

                } else {
                    clipB.start();
                }

                // setting timer
                timer = new javax.swing.Timer(6000, new ActionListener() {//
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("The second kiss was given");
                        labelImage.setIcon(smileEyesKiss);
                        kissGiven = true;
                        labelText.setText("<html><center>*smack*</center></html>");

                    }
                });
                timer.setRepeats(false);

                timer.start();

                // third itineration:
            } else {
                System.out.println("Counter = more than 1");

                labelImage.setIcon(kiss);
                labelText.setText("<html><center>You're giving him another kiss...</center></html>");

            }
        }

    }

    // 2__________________________________________________________________________
    @Override
    public void mouseReleased(MouseEvent e) {

        // disable right mouse button
        if (SwingUtilities.isRightMouseButton(e)) {

            System.out.println("Right mouse button disabled.");
        } else {

            System.out.println("You released the mouse");

            if (counter == 0) {
                System.out.println("Counter = 0");

                // try and catch to avoid error in the terminal:
                try {
                    clipA.stop();
                } catch (Exception f) {
                }

                timer.stop();

                if (kissGiven) {

                    labelImage.setIcon(smileFlushed);
                    kissGiven = false;
                    happyState = true;
                    labelText.setText("<html><center>That was a nice kiss...</center></html>");

                } else {

                    labelImage.setIcon(pleading);
                    labelText.setText(
                            "<html><center>Oh no, Vincent didn't feel that one.<br>Try a longer kiss!</center></html>");

                }

            } else if (counter == 1) {
                System.out.println("Counter = 1");

                try {
                    clipB.stop();
                } catch (Exception f) {
                }

                timer.stop();

                if (kissGiven) {

                    labelImage.setIcon(smileHearts);
                    kissGiven = false;
                    happyState = true;
                    labelText.setText(
                            "<html><center>Vincent is overwhelmed with joy<br>thanks to your kisses!</center></html>");

                } else {

                    labelImage.setIcon(pleading);
                    labelText.setText(
                            "<html><center>So close! Vincent felt that one,<br>but let's try for a longer kiss.</center></html>");

                }

            } else {
                System.out.println("Counter = more than 1");
                labelImage.setIcon(smileHearts);

            }
        }

    }
    // __________________________________________________________________________

    @Override
    public void mouseEntered(MouseEvent e) {

        System.out.println("You entered the component");

        labelImage.setIcon(flushed);

    }
    // 3__________________________________________________________________________

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("You exited the component");

        if (counter == 0) {
            System.out.println("Counter = 0");

            labelImage.setIcon(smileFlushed); // this line is necessary, otherwise inconsistent cases can occur

            if (happyState) {
                timer = new javax.swing.Timer(1300, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("He's sad again.");

                        labelImage.setIcon(pleading);
                        labelText.setText(
                                "<html><center>... but Vincent is still feeling blue.<br>Almost there! Another kiss might be<br>just what Vincent needs.</center></html>");

                        happyState = false;

                        counter++;
                    }
                });
                timer.setRepeats(false);
                timer.start();

            } else {

                labelImage.setIcon(disappointed);
            }

        } else if (counter == 1) {
            System.out.println("Counter = 1");

            labelImage.setIcon(smileHearts); // this line is necessary, otherwise inconsistent cases can occur

            if (happyState) {
                timer = new javax.swing.Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        happyState = false;

                        counter++;
                    }
                });
                timer.setRepeats(false);
                timer.start();

            } else {

                labelImage.setIcon(disappointed);
            }

        } else {
            System.out.println("Counter = more than 1");
            labelImage.setIcon(smile);
            labelText.setText(
                    "<html><center>There you go! With that kiss,<br>Vincent's day is brighter, and so is yours.<br>Now you can go further with your life!</center></html>");

        }

    }

    @Override
    public void onButtonClick() {

        System.out.println("The rewind button was pressed");

        timer.stop();
        counter = 0;
        kissGiven = false;
        happyState = false;
        labelImage.setIcon(disappointed);
        try {
            clipA.stop();
            clipB.stop();
        } catch (Exception f) {
        }
        labelText.setText(
                "<html><center>This is Vincent.<br>He's feeling blue.<br>A sweet kiss might just make his day!</center></html>");
        timer.stop();
        panelButton.remove(button);

        // unnecessary if frame is not resizable???:
         panelButton.revalidate();
         panelButton.repaint();
    }

}


//interface ButtonClickListener {
//    void onButtonClick();
//}
