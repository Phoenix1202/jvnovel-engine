package jvnovel.graphics;

import jvnovel.scene.Scene;

public interface ISceneRenderer {

  public abstract void render(Scene scene);

  public abstract void setWindow(long window);
}
