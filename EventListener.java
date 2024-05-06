
package Lab1;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.newt.event.MouseAdapter;
import com.jogamp.newt.event.MouseEvent;

public class EventListener implements GLEventListener {
    private GL2 gl;
    private float mouseX = 0;
    private float mouseY = 0;
    private boolean mouseStopped = false;

    @Override
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1.0f, 0, 0.0f); // Yellow color
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex2f(-90, -90); // Top vertex
        gl.glVertex2f(90, -90); // Bottom left vertex
        gl.glVertex2f(-90, 90); // Bottom right vertex
        gl.glEnd();

    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
    }

    @Override
    public void init(GLAutoDrawable arg0) {
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
        gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_MODELVIEW); // Set the matrix mode to GL_MODELVIEW
        gl.glLoadIdentity();
        gl.glOrtho(-render.width / 2, render.width / 2, -render.height / 2, render.height / 2, -1, 1);
    }

    public void addMouseListener() {
        render.window.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX() - render.window.getWidth() / 2;
                mouseY = render.window.getHeight() / 2 - e.getY();
                mouseStopped = false;
                render.window.display();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                mouseStopped = false;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseStopped = true;
                render.window.display();
            }
        });
    }
}