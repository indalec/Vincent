//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import javax.swing.Timer;
//
////...
//
////declara un temporizador como atributo de la clase
//Timer timer;
//
////en el constructor, inicializa el temporizador con un intervalo de 100 milisegundos y un oyente vacío
//timer = new Timer(100, new ActionListener() {//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        //no hace nada
//    }
//});
//
////en el método mousePressed, inicia el temporizador
//@Override
//public void mousePressed(MouseEvent e) {
//    // Invoked when a mouse button has been pressed on a component
//    System.out.println("You pressed the mouse");
//    // label.setBackground(Color.yellow);
//    label.setIcon(partying);
//
//    //adding audio
//    try {
//
//        clip = AudioSystem.getClip();
//        clip.open(AudioSystem.getAudioInputStream(file));
//        //clip.start();
//    } catch (Exception f) {
//    }
//
//
//        clip.start();
//
//    //inicia el temporizador
//    timer.start();
//
//}
//
////en el método mouseReleased, detiene el temporizador y comprueba el tiempo transcurrido
//@Override
//public void mouseReleased(MouseEvent e) {
//    // Invoked when a mouse button has been release on a component
//    System.out.println("You released the mouse");
//    // label.setBackground(Color.green);
//    label.setIcon(pleading);
//
//
//    clip.stop();
//
//    //detiene el temporizador
//    timer.stop();
//
//    //obtiene el tiempo transcurrido en milisegundos
//    int tiempo = timer.getDelay() * timer.getActionListeners()[0].getCount();
//
//    //si el tiempo es mayor que 5000 milisegundos (5 segundos), cambia la imagen por otra específica
//    if (tiempo > 5000) {
//        label.setIcon(test); //cambia la imagen por la que quieras
//    }
//
//}
//