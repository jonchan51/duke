package duke.command;

import duke.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {
    private static final String MESSAGE_LIST     = "Here are the tasks in your list:\n";
    private static final String MESSAGE_NO_TASKS = "You have no tasks in your list yet!";

    public void execute(TaskList tasks, Storage storage) throws DukeException {
        StringBuilder lines = new StringBuilder();
        if (tasks.isEmpty()) {
            lines.append(MESSAGE_NO_TASKS);
            Ui.printIndented(lines.toString());
            return;
        }
        lines.append(MESSAGE_LIST);
        for (int i = 0; i < tasks.size(); i++) {
            lines.append(String.format("%d. %s\n", i + 1, tasks.get(i).toString()));
        }
        Ui.printIndented(lines.toString());
    }
}
