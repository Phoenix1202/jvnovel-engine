package jvnovel.scene;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SceneLoader {

  public static Scene loadScene(final File file) {
    Scene scene = null;
    DocumentBuilder builder = null;
    Document doc = null;
    try {
      builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      doc = builder.parse(file);
    } catch (ParserConfigurationException | SAXException | IOException e) {
      e.printStackTrace();
      return null;
    }

    Node firstChild = doc.getFirstChild();
    if (Node.ELEMENT_NODE == firstChild.getNodeType() && "scene".equals(firstChild.getNodeName())) {
      Element sceneNode = (Element) firstChild;
      scene = new Scene(sceneNode.getAttribute("name"));

      if (sceneNode.hasChildNodes()) {
        NodeList sceneChildNodes = sceneNode.getChildNodes();
        for (int i = 0; i < sceneChildNodes.getLength(); i++) {
          if (isValidElement(sceneChildNodes.item(i), "frame")) {
            Element frameNode = (Element) sceneChildNodes.item(i);
            scene.addFrame(new Frame(frameNode.getAttribute("source"), frameNode.getAttribute("text")));
          }
        }
      }
    }
    return scene;
  }

  static private boolean isValidElement(final Node node, final String name) {
    if (node == null || name == null) {
      return false;
    }
    return Node.ELEMENT_NODE == node.getNodeType() && name.equals(node.getNodeName());
  }

}
