package pboex;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pboex.controller.MainController;
import pboex.navigator.Navigator;

public final class Main extends Application {
  private static final String APP_TITLE = "To-Do App";
  private static final String APP_ICON = "/pboex/icon.png";
  private static final String APP_CSS = "/pboex/css/app.css";

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle(APP_TITLE);
    primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream(APP_ICON)));
    primaryStage.setResizable(false);

    primaryStage.setScene(createScene(loadMainPane()));
    primaryStage.show();
  }

  private Scene createScene(Pane mainPane) {
    Scene scene = new Scene(mainPane);
    scene.getStylesheets().setAll(getClass().getResource(APP_CSS).toExternalForm());

    return scene;
  }

  private Pane loadMainPane() throws IOException {
    FXMLLoader loader = new FXMLLoader();

    Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(Navigator.MAIN));

    MainController mainController = loader.getController();

    Navigator.setMainController(mainController);
    Navigator.loadPage(Navigator.HOME);

    return mainPane;
  }
}
