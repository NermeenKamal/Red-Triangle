package Lab1;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class render {
    public static GLWindow window = null; // Represents the OpenGL window
    public static int width = 640; // Width of the window
    public static int height = 360; // Height of the window
    public static float wideUnits = 10; // Width of the coordinate system

    public static void init() {
        // Initialize OpenGL
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        // Create the OpenGL window
        window = GLWindow.create(caps);
        window.setSize(width, height);
        window.setVisible(true);
        window.setResizable(true);

        // Add event listener
        window.addGLEventListener(new EventListener());

        // Start animator
        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();

        EventListener listener = new EventListener();
        listener.addMouseListener();

    }

    public static void main(String[] args) {
        init();
    }
}