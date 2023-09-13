package blip.ui;

import blip.tasks.*;

/**
 * Represents the user interface of Blip ChatBot.
 */
public class BlipUI {

    /**
     * Returns the string representation of the intro message.
     *
     * @return String representation of the intro message
     */
    public String showIntro() {
        // Intro message by Blip.
        String intro = "Hello! I'm Blip\n"
                + "What can I do for you?";
        return intro;
    }

    /**
     * Returns the string representation of the outro message.
     *
     * @return String representation of the outro message
     */
    public String showOutro() {
        // Outro message by Blip.
        String outro = "Bye. Hope to see you again soon!";
        return outro;
    }

    /**
     * Returns the string representation of the empty task number error message.
     *
     * @return String representation of the empty task number error
     */
    public String showEmptyTaskNumErr() {
        return "\nOh no! The task number cannot be empty."
        + "\nPlease key in the task number you would like to mark/unmark/delete.";
    }

    /**
     * Returns the string representation of the invalid task number error message.
     *
     * @return String representation of the invalid task number error
     */
    public String showInvalidTaskNumErr() {
        return "Oh no! The task number does not exist."
        + "\nYou can find out the tasks and their numbers by typing list."
        + "\nPlease re-enter the correct task number to mark/unmark/delete.";
    }

    /**
     * Returns the string representation of the empty description error message.
     *
     * @return String representation of the empty description error
     */
    public String showEmptyDescErr() {
        return "Oh no! The task description cannot be empty."
        + "\nPlease key in the task description, with date time where applicable."
        + "\n1. deadline [task description] /by [yyyy-MM-dd HH:mm]"
        + "\n2. event [task description] /from [yyyy-MM-dd HH:mm] /to [yyyy-MM-dd HH:mm]"
        + "\n3. todo [task description].";
    }

    /**
     * Returns the string representation of the invalid command error message.
     *
     * @return String representation of the invalid command error
     */
    public String showInvalidCmdErr() {
        return "Oh no! I don't understand what you mean. Please key in either"
        + "\n1. deadline [task description] /by [yyyy-MM-dd HH:mm]"
        + "\n2. event [task description] /from [yyyy-MM-dd HH:mm] /to [yyyy-MM-dd HH:mm]"
        + "\n3. todo [task description]."
        + "\n4. mark [task number]"
        + "\n5. unmark [task number]"
        + "\n6. delete [task number]"
        + "\n7. list";
    }


    /**
     * Returns the string representation of the loading data file error message.
     *
     * @return String representation of the loading data file error
     */
    public String showLoadingErr() {
        return "Error loading file: ";
    }

    /**
     * Returns the string representation of the saving data file error message.
     *
     * @return String representation of the saving data file error
     */
    public String showSavingErr() {
        return "Error saving file: ";
    }

    /**
     * Returns the string representation of the date time format error message.
     *
     * @return String representation of the date time format error
     */
    public String showDateTimeFormatErr() {
        return "Please format your date time to be yyyy-mm-dd HH:mm";
    }



    /**
     * Returns the string representation of the list of tasks.
     *
     * @param tasks The task list to list out tasks from
     * @return String representation of the list of tasks matched
     */
    public static String listsTasksMsg(TaskList tasks) {
        String listIntro = "Here are the tasks in your list:";
        String emptyListMessage = "There are no tasks in your list";
        String tasksInList = "";
        if (tasks.size() == 0) {
            return emptyListMessage;
        }
        for (int i = 0; i < tasks.size(); i++) {
            tasksInList += "\n" + (i + 1) + "." + tasks.getTask(i).toString();
        }
        return listIntro + tasksInList;
    }

    /**
     * Returns the string representation of the list of tasks matched.
     *
     * @param tasks The task list to match tasks from
     * @param description The description to match with tasks from task list
     * @return String representation of the list of tasks matched
     */

    public static String listTasksMatched(TaskList tasks, String description) {
        String matchedTasksIntro = "Here are the matching tasks in  your list:";
        String noMatchMessage = "There are no matching tasks in the list";
        String matchedTasksList = "";
        if (tasks.size() == 0) {
            return noMatchMessage;
        }
        int numOfTasksMatched = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.getTask(i).toString().contains(description)) {
                matchedTasksList += "\n" + (numOfTasksMatched + 1) + "." + tasks.getTask(i).toString();
                numOfTasksMatched++;
            }
        }
        if (numOfTasksMatched == 0) {
            return noMatchMessage;
        }
        return matchedTasksIntro + matchedTasksList;
    }

    /**
     * Prints the message that task has been added.
     *
     * @param task The task that was added to task list
     * @param size The size of the task list after it has added new task
     */
    public String addsTasksMsg(Task task, int size) {
        return "Alright! I've added this task:\n " + task.toString()
        + "\nNow you have " + size + " tasks in the list.";
    }

    /**
     * Prints the message that task has been deleted.
     *
     * @param task The task that was deleted from task list
     * @param size The size of the task list after it has deleted a task
     */
    public String deletesTasksMsg(Task task, int size) {
       return "Ok, I've removed this task:"  + task.toString()
        + "\nNow you have " + size + " tasks in the list.";
    }

    /**
     * Prints the message that task has been marked.
     *
     * @param task The task that was marked as done
     */
    public String marksTasksMsg(Task task) {
        return "Nice! I've marked this task as done:" + task.toString();
    }

    /**
     * Prints the message that task has been unmarked.
     *
     * @param task The task that was unmarked as not done
     */
    public String unmarksTasksMsg(Task task) {
        return "Nice! I've marked this task as not done yet:" + task.toString();
    }

    /**
     * Prints the message that task has been set a priority apart from its default.
     *
     * @param task The task that was unmarked as not done
     */
    public String setPriorityMsg(Task task) {
        return "Nice! I've set the priority of this task:" + task.toString();
    }

}
