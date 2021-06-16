package Main;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.VideoInputFrameGrabber;
import org.bytedeco.javacpp.opencv_core.IplImage;

public class Webcam implements Runnable {

    IplImage image;
    CanvasFrame canvas = new CanvasFrame("Web cam");

    public Webcam() {
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void run() {
        System.out.println("The webcamThread is now up and running");
        FrameGrabber grabber = new VideoInputFrameGrabber(0);
        int i = 0;
        try {
            grabber.start();
            Frame img;
            while (true) {
                img = grabber.grab();
                System.out.println();
                if (img != null) {
                    canvas.showImage(img);
                }
            }
        } catch(Exception e) {
            System.out.println("There was an issue with the camera");
            e.printStackTrace();
        }
    }
}
