import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Cursor;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame69 extends JFrame implements MouseListener {

    JLabel label;

    // adding audio:
    Clip clipA;
    File fileA = new File("Song2a.wav");

    Clip clipB;
    File fileB = new File("Song2b.wav");

    // adding images
    ImageIcon disappointed;
    ImageIcon flushed;
    ImageIcon kiss;
    ImageIcon pleading;
    ImageIcon test;
    ImageIcon smileEyesKiss;
    ImageIcon smileHearts;
    ImageIcon smileFlushed;

    // adding timer
    Timer timer;

    // adding booleans for the if's
    boolean kissGiven = false;
    boolean happyState = false;

    // adding custom cursor
    Toolkit toolkit;
    Image image;

    // Counter variable
    int counter = 0;

    // constructor
    MyFrame69() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        label = new JLabel();
        label.addMouseListener(this);

        // images
        disappointed = new ImageIcon("disappointed96.png");
        flushed = new ImageIcon("flushed96.png");
        kiss = new ImageIcon("closed_eyes_kiss96.png");
        pleading = new ImageIcon("pleading96.png");
        smileEyesKiss = new ImageIcon("smiling_eyes_kiss96.png");
        smileHearts = new ImageIcon("smiling_with_hearts96.png");
        smileFlushed = new ImageIcon("smilingFaceA96.png");

        label.setIcon(disappointed);

        this.add(label);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // cursor
        toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage("kiss32.png");
        Cursor customCursor = toolkit.createCustomCursor(image, new Point(0, 0), "kiss");
        label.setCursor(customCursor);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    // 1__________________________________________________________________________
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("You pressed the mouse");

        if (counter == 0) {
            System.out.println("Counter = 0");

            label.setIcon(kiss);

            // adding audio
            try {

                clipA = AudioSystem.getClip();
                clipA.open(AudioSystem.getAudioInputStream(fileA));

            } catch (Exception f) {
            }

            clipA.start();

            timer = new javax.swing.Timer(5000, new ActionListener() {//
                @Override
                public void actionPerformed(ActionEvent e) {
                    // no hace nada
                    System.out.println("The kiss was given");
                    label.setIcon(smileEyesKiss);
                    kissGiven = true;
                }
            });
            timer.setRepeats(false);

            timer.start();

        } else if (counter == 1) {
            System.out.println("Counter = 1");

            label.setIcon(kiss);

            // adding audio
            try {

                clipB = AudioSystem.getClip();
                clipB.open(AudioSystem.getAudioInputStream(fileB));

            } catch (Exception f) {
            }

            clipB.start();

            timer = new javax.swing.Timer(5000, new ActionListener() {//
                @Override
                public void actionPerformed(ActionEvent e) {
                    // no hace nada
                    System.out.println("The second kiss was given");
                    label.setIcon(smileEyesKiss);
                    kissGiven = true;
                }
            });
            timer.setRepeats(false);

            timer.start();

        } else {
            System.out.println("Counter = more than 1");

            label.setIcon(kiss);

        }

    }

    // 2__________________________________________________________________________
    @Override
    public void mouseReleased(MouseEvent e) {

        System.out.println("You released the mouse");

        if (counter == 0) {
            System.out.println("Counter = 0");

            if (kissGiven) {

                label.setIcon(smileFlushed);
                kissGiven = false;
                happyState = true;
            } else {

                label.setIcon(pleading);
            }

            clipA.stop();
            timer.stop();

        } else if (counter == 1) {
            System.out.println("Counter = 1");

            if (kissGiven) {

                label.setIcon(smileHearts);
                kissGiven = false;
                happyState = true;
            } else {

                label.setIcon(pleading);
            }

            clipB.stop();
            timer.stop();

        } else {
            System.out.println("Counter = more than 1");
            label.setIcon(smileHearts);

        }

    }
    // __________________________________________________________________________

    @Override
    public void mouseEntered(MouseEvent e) {

        System.out.println("You entered the component");

        label.setIcon(flushed);

    }
    // 3__________________________________________________________________________

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("You exited the component");

        if (counter == 0) {
            System.out.println("Counter = 0");

            label.setIcon(smileFlushed); // this line is necessary, otherwise inconsistent cases can occur

            if (happyState) {
                timer = new javax.swing.Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("He's sad again.");

                        label.setIcon(disappointed);

                        happyState = false;

                        counter++;
                    }
                });
                timer.setRepeats(false);
                timer.start();

            } else {

                label.setIcon(disappointed);
            }

        } else if (counter == 1) {
            System.out.println("Counter = 1");

            label.setIcon(smileHearts); // this line is necessary, otherwise inconsistent cases can occur

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

                label.setIcon(disappointed);
            }

        } else {
            System.out.println("Counter = more than 1");
            label.setIcon(smileHearts);

        }

    }

}