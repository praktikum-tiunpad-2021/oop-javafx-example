package pboex.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class MainController {
  /** Holder of a switchable page. */
  @FXML
  private StackPane pageHolder;

  /**
   * Replaces the page displayed in the page holder with a new page.
   *
   * @param node the page node to be swapped in.
   */
  public void setPage(Node node) {
    pageHolder.getChildren().setAll(node);
  }
}
