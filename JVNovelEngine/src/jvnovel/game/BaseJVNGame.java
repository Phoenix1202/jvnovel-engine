
package jvnovel.game;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_TEXTURE;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;

import org.lwjgl.glfw.GLFWVidMode;

import jvnovel.graphics.DefaultSceneRenderer;
import jvnovel.graphics.ISceneRenderer;

public class BaseJVNGame {

  private static final int HEIGHT = 600;

  private static final int WIDTH = 800;

  protected long window;

  int x = 0;
  int y = 0;

  int curFrame = 0;
  protected ISceneRenderer renderer;

  public static void main(final String[] args) {
    BaseJVNGame game = new BaseJVNGame();
    game.setSceneRenderer(new DefaultSceneRenderer());
    game.run();
  }

  private void setSceneRenderer(final ISceneRenderer renderer) {
    this.renderer = renderer;
  }

  public void run() {
    init();
  }

  protected void init() {
    if (!glfwInit()) {
      throw new IllegalStateException("Unable to start ");
    }

    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
    long window = glfwCreateWindow(WIDTH, HEIGHT, "Base VN", 0, 0);
    if (window == 0) {
      throw new IllegalStateException();
    }

    GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
    glfwSetWindowPos(window, (vidMode.width() - WIDTH) / 2, (vidMode.height() - HEIGHT) / 2);
    glfwShowWindow(window);
    glfwMakeContextCurrent(window);
    createCapabilities();
    glEnable(GL_TEXTURE);
    renderer.setWindow(window);

    while (!glfwWindowShouldClose(window)) {
      if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_TRUE) {
        glfwSetWindowShouldClose(window, true);
      }

      glfwPollEvents();
      glClear(GL_COLOR_BUFFER_BIT);

      renderer.render(null);

      glfwSwapBuffers(window);

    }

    glfwTerminate();
  }

}