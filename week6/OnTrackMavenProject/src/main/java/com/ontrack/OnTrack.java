
package com.ontrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnTrack {
    public static class Task {
        public int taskId;
        public String studentId;
        public String title;
        public String feedback;

        public Task(int taskId, String studentId, String title) {
            this.taskId = taskId;
            this.studentId = studentId;
            this.title = title;
            this.feedback = null;
        }
    }

    public static class Message {
        public int taskId;
        public String from;
        public String to;
        public String message;

        public Message(int taskId, String from, String to, String message) {
            this.taskId = taskId;
            this.from = from;
            this.to = to;
            this.message = message;
        }
    }

    private List<Task> tasks = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    private int idCounter = 1;

    public Task submitTask(String studentId, String title) {
        Task task = new Task(idCounter++, studentId, title);
        tasks.add(task);
        return task;
    }

    public List<Task> getTaskInbox(String studentId) {
        return tasks.stream().filter(t -> t.studentId.equals(studentId)).collect(Collectors.toList());
    }

    public Task addFeedback(int taskId, String feedback) {
        for (Task t : tasks) {
            if (t.taskId == taskId) {
                t.feedback = feedback;
                return t;
            }
        }
        return null;
    }

    public Message sendMessage(int taskId, String from, String to, String message) {
        Message msg = new Message(taskId, from, to, message);
        messages.add(msg);
        return msg;
    }

    public List<Message> getMessages(int taskId) {
        return messages.stream().filter(m -> m.taskId == taskId).collect(Collectors.toList());
    }
}
