package pboex.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pboex.model.TodoTaskModel;
import pboex.navigator.Navigator;
import pboex.repository.Repository;
import pboex.repository.TodoTaskMemoryRepository;

public class AddTodoController implements Initializable {
  @FXML
  public TextField descTextField;

  private Repository<TodoTaskModel> todoRepo;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    todoRepo = new TodoTaskMemoryRepository();
  }

  @FXML
  public void onAdd() {
    String description = descTextField.getText();
    if (description.isEmpty()) {
      return;
    }
    TodoTaskModel newTodo = new TodoTaskModel(description);
    try {
      todoRepo.save(newTodo);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      Navigator.loadPage(Navigator.HOME);
    }
  }

  @FXML
  public void onCancel() {
    Navigator.loadPage(Navigator.HOME);
  }

}
