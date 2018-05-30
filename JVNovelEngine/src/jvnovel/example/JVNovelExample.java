package jvnovel.example;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

import jvnovel.scene.Frame;
import jvnovel.scene.Scene;
import jvnovel.scene.SceneLoader;

public class JVNovelExample {
  public static void main(final String[] args) {
    Scene scene = null;
    try {
      scene = SceneLoader.loadScene(new File(JVNovelExample.class.getClassLoader().getResource("example.xml").toURI()));
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (scene != null) {
      for (Frame frame : scene.getFrames()) {
        System.out.flush();
        if ("self".equals(frame.getSource())) {
          System.err.println(frame.getText());
        } else {
          System.out.println(MessageFormat.format("{0}: \"{1}\"", frame.getSource(), frame.getText()));
        }
        try {
          System.in.read();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
