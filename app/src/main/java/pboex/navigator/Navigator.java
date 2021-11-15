package pboex.navigator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import pboex.controller.MainController;

public class Navigator {
  public static final String MAIN = "/pboex/fxml/main.fxml";
  public static final String HOME = "/pboex/fxml/home.fxml";
  public static final String ADD_TODO = "/pboex/fxml/add_todo.fxml";

  /** The main application layout controller. */
  private static MainController mainController;

  /**
   * Stores the main controller for later use in navigation tasks.
   *
   * @param mainController the main application layout controller.
   */
  public static void setMainController(MainController mainController) {
    Navigator.mainController = mainController;
  }

  /**
   * Loads the page specified by the fxml file into the pageHolder pane of the
   * main application layout.
   * 
   * @param fxml the fxml file to be loaded.
   */
  public static void loadPage(String fxml) {
    try {
      mainController.setPage(FXMLLoader.load(Navigator.class.getResource(fxml)));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
