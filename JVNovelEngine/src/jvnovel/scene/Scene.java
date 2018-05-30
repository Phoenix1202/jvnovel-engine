package jvnovel.scene;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.glfw.GLFWImage;

public class Scene {

  private final String id;

  private GLFWImage background;

  private String filter;

  private int currentFrame = 0;

  private final HashMap<String, Actor> actors = new HashMap<>();

  private final ArrayList<Frame> frames = new ArrayList<>();

  public Scene(final String id) {
    this.id = id;
    currentFrame = 0;
  }

  public boolean addFrame(final Frame frame) {
    return frames.add(frame);
  }

  public Frame getFrameAt(final int index) {
    return frames.get(index);
  }

  public ArrayList<Frame> getFrames() {
    return frames;
  }
}
