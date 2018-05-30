package jvnovel.scene;

public class Frame {

  public static final String UNKNOWN = "???";
  private final String text;
  private final String source;
  private Actor actor;

  public Actor getActor() {
    return actor;
  }

  public void setActor(final Actor actor) {
    this.actor = actor;
  }

  public String getText() {
    return text;
  }

  public String getSource() {
    return source;
  }

  public Frame(final String source, final String text) {
    this.source = source != null && !source.isEmpty() ? source : UNKNOWN;
    this.text = text;
  }

}
