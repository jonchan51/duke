package duke.command;

import duke.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

public class DoneCommand extends Command {
    private int taskId;

    private static final String MESSAGE_DONE     = "Nice! I've marked this task as done:\n  %s";

    private static final String ERROR_INVALID_TASK_ID = "The id of the task must be a number. e.g. done 1";

    public DoneCommand(int taskId) {
        this.taskId = taskId;
    }

    public void execute(TaskList tasks, Storage storage) throws DukeException {
        if (taskId < 1 || taskId > tasks.size()) {
            throw new DukeException(ERROR_INVALID_TASK_ID);
        }
        Task task = tasks.get(taskId - 1);
        task.markAsDone();
        Ui.printIndented(String.format(MESSAGE_DONE, task.toString()));
    }
}