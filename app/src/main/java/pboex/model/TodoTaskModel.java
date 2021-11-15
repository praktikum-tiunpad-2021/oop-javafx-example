package pboex.model;

public class TodoTaskModel extends Model {
  private String description;
  private Boolean completed = false;

  public TodoTaskModel(String description) {
    this.description = description;
  }

  public TodoTaskModel(Integer id, String description, Boolean completed) {
    this.id = id;
    this.description = description;
    this.completed = completed;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public Boolean isCompleted() {
    return completed;
  }
}
