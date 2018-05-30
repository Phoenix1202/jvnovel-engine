package jvnovel.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;

public class Mesh {
  protected int triCount;
  protected FloatBuffer vertBuf;
  protected int vertId;
  protected int indexId;
  protected IntBuffer indexBuf;
  protected int[] indices;
  protected float[] vertices;

  public Mesh() {
  }

  public Mesh(final float[] vertices, final int[] indices) {
    this.vertices = vertices;
    this.indices = indices;

    fillVertexBuffer(vertices);

    fillIndexBuffer(indices);

  }

  protected void fillIndexBuffer(final int[] indices) {
    if (indexId == 0) {
      indexId = glGenBuffers();
    }
    triCount = indices.length;
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexId);
    indexBuf = BufferUtils.createIntBuffer(indices.length);
    indexBuf.put(indices);
    indexBuf.flip();
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, indexBuf, GL_STATIC_DRAW);
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

  }

  protected void fillVertexBuffer(final float[] vertices) {
    if (vertId == 0) {
      vertId = glGenBuffers();
    }
    glBindBuffer(GL_ARRAY_BUFFER, vertId);
    vertBuf = BufferUtils.createFloatBuffer(vertices.length);
    vertBuf.put(vertices);
    vertBuf.flip();
    glBufferData(GL_ARRAY_BUFFER, vertBuf, GL_STATIC_DRAW);
    glBindBuffer(GL_ARRAY_BUFFER, 0);
  }

  public void render() {
    glEnableClientState(GL_VERTEX_ARRAY);

    glBindBuffer(GL_ARRAY_BUFFER, vertId);
    glVertexPointer(2, GL_FLOAT, 0, 0);

    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexId);
    glDrawElements(GL_TRIANGLES, triCount, GL_UNSIGNED_INT, 0);

    glBindBuffer(GL_ARRAY_BUFFER, 0);
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

    glDisableClientState(GL_VERTEX_ARRAY);

  }
}
