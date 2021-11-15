package pboex.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import pboex.model.TodoTaskModel;
import pboex.navigator.Navigator;
import pboex.repository.Repository;
import pboex.repository.TodoTaskMemoryRepository;

public class HomeController implements Initializable {
  @FXML
  private FlowPane todoFlowPane;

  private Repository<TodoTaskModel> todoRepo = new TodoTaskMemoryRepository();

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      List<TodoTaskModel> todos = todoRepo.getAll();
      buildTodoList(todos);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void onAddTodo() {
    Navigator.loadPage(Navigator.ADD_TODO);
  }

  private void buildTodoList(List<TodoTaskModel> todos) {
    for (TodoTaskModel todo : todos) {
      Text desc = new Text(todo.getDescription());
      if (todo.isCompleted()) {
        desc.setStyle("-fx-strikethrough: true;");
      }

      CheckBox check = new CheckBox();
      check.setSelected(todo.isCompleted());
      check.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
          todo.setCompleted(newValue);
          try {
            todoRepo.update(todo);
          } catch (Exception e) {
            e.printStackTrace();
          }
          desc.setStyle("-fx-strikethrough: " + newValue.toString() + ";");
        }
      });

      HBox box = new HBox(20.0f);
      box.getChildren().addAll(check, desc);
      todoFlowPane.getChildren().add(box);
    }
  }
}
