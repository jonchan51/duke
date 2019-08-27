package duke.command;

import duke.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeleteCommand extends Command {
    private int taskId;

    private static final String MESSAGE_DELETE   = "Noted. I've removed this task:\n  %s\n"
            + "Now you have %d %s in the list.";

    private static final String ERROR_INVALID_TASK_ID = "The id of the task must be a number. e.g. done 1";

    public DeleteCommand(int taskId) {
        this.taskId = taskId;
    }

    public void execute(TaskList tasks, Storage storage) throws DukeException {
        if (taskId < 1 || taskId > tasks.size()) {
            throw new DukeException(ERROR_INVALID_TASK_ID);
        }
        Task task = tasks.get(taskId - 1);
        tasks.remove(taskId - 1);
        Ui.printIndented(String.format(MESSAGE_DELETE, task.toString(), tasks.size(),
                tasks.size() != 1 ? "tasks" : "task"));
    }
}