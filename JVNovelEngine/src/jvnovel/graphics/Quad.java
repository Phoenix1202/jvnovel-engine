package jvnovel.graphics;

import org.lwjgl.BufferUtils;

import jvnovel.example.JVNovelExample;

public class Quad extends Mesh {
  Quad(final float x, final float y, final float w, final float h) {
    float u1, u2, v1, v2;
    u1 = x - w / 2;
    v1 = y - w / 2;
    u2 = x + w / 2;
    v2 = y + w / 2;

    this.vertBuf = BufferUtils.createFloatBuffer(8);
    this.vertices = new float[] { u1, v1, u1, v2, u2, v1, u2, v2 };
    fillVertexBuffer(vertices);

    this.indexBuf = BufferUtils.createIntBuffer(6);
    indices = new int[] { 0, 1, 2, 1, 3, 2 };
    fillIndexBuffer(indices);

    String path = JVNovelExample.class.getClassLoader().getResource("/img/back.png").getPath();

  }
}
