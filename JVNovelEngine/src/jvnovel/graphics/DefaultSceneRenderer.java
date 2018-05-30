package jvnovel.graphics;

import jvnovel.scene.Scene;

public class DefaultSceneRenderer implements ISceneRenderer {

  private Mesh m;

  public DefaultSceneRenderer() {
  }

  @Override
  public void render(final Scene scene) {
    m.render();
  }

  @Override
  public void setWindow(final long window) {
    // m = new Mesh(new float[] { -1, -1, -1, 1, 1, -1, 1, 1 }, new int[] { 0, 1, 2,
    // 1, 3, 2 });
    m = new Quad(0f, 0f, 0.5f, 0.5f);

  }

}
