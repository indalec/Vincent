import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class MyFrame69 extends JFrame implements MouseListener {

    // declaring panels
    JPanel panelImage;
    JPanel panelText;

    // declaring labels
    JLabel labelImage;
    JLabel labelText;

    // declaring audio clips
    Clip clipA;
    File fileA = new File("Song2a.wav");

    Clip clipB;
    File fileB = new File("Song2b.wav");

    // declaring images
    ImageIcon disappointed;
    ImageIcon flushed;
    ImageIcon kiss;
    ImageIcon pleading;
    ImageIcon test;
    ImageIcon smileEyesKiss;
    ImageIcon smileHearts;
    ImageIcon smileFlushed;

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

    // constructor
    MyFrame69() {
        // window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);

        // panels
        panelImage = new JPanel();
        panelText = new JPanel();

        panelImage.setPreferredSize(new Dimension(100, 130));
        panelText.setPreferredSize(new Dimension(300, 150));
        // labels
        labelImage = new JLabel();
        labelImage.addMouseListener(this);

        labelText = new JLabel();
        labelText.setText("This is Vincent :D");
        panelText.add(labelText);

        // images
        disappointed = new ImageIcon("disappointed96.png");
        flushed = new ImageIcon("flushed96.png");
        kiss = new ImageIcon("closed_eyes_kiss96.png");
        pleading = new ImageIcon("pleading96.png");
        smileEyesKiss = new ImageIcon("smiling_eyes_kiss96.png");
        smileHearts = new ImageIcon("smiling_with_hearts96.png");
        smileFlushed = new ImageIcon("smilingFaceA96.png");

        labelImage.setIcon(disappointed);
        // for developement purposes:
        labelImage.setOpaque(true); // !!!
        labelImage.setBackground(Color.RED);// !!!

        labelText.setOpaque(true);// !!!
        labelText.setBackground(Color.green);// !!!

        panelText.setOpaque(true);// !!!
        panelText.setBackground(Color.ORANGE);// !!!

        panelImage.setOpaque(true);// !!!
        panelImage.setBackground(Color.BLUE);// !!!

        // cursor
        toolkit = Toolkit.getDefaultToolkit();
        lips = toolkit.getImage("kiss32.png");
        customCursor = toolkit.createCustomCursor(lips, new Point(0, 0), "kiss");
        labelImage.setCursor(customCursor);

        this.setTitle("Vincent 0.2");
        this.add(panelImage);
        this.add(panelText);
        this.setResizable(false);
        // this.pack();// quit so the window does not fit to the elements
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        panelImage.add(labelImage);
        panelText.add(labelText);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    // 1__________________________________________________________________________
    @Override
    public void mousePressed(MouseEvent e) {

        labelText.setText("Giving a kiss...");

        // disable right mouse button
        if (SwingUtilities.isRightMouseButton(e)) {

            System.out.println("Right mouse button disabled.");

        } else {

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

                timer = new javax.swing.Timer(5000, new ActionListener() {//
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("The kiss was given");
                        labelImage.setIcon(smileEyesKiss);
                        labelText.setText("You gave Vincent a kiss :D");
                        kissGiven = true;
                    }
                });

                timer.setRepeats(false);

                timer.start();

                // second itineration:
            } else if (counter == 1) {
                System.out.println("Counter = 1");

                labelImage.setIcon(kiss);

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

                timer = new javax.swing.Timer(5000, new ActionListener() {//
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        System.out.println("The second kiss was given");
                        labelImage.setIcon(smileEyesKiss);
                        kissGiven = true;
                    }
                });
                timer.setRepeats(false);

                timer.start();

            // third itineration:
            } else {
                System.out.println("Counter = more than 1");

                labelImage.setIcon(kiss);

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

                try {
                    clipA.stop();
                } catch (Exception f) {
                }

                timer.stop();

                if (kissGiven) {

                    labelImage.setIcon(smileFlushed);
                    kissGiven = false;
                    happyState = true;

                } else {

                    labelImage.setIcon(pleading);
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
                } else {

                    labelImage.setIcon(pleading);
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
                timer = new javax.swing.Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("He's sad again.");

                        labelImage.setIcon(pleading);

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
            labelImage.setIcon(smileHearts);

        }

    }

}