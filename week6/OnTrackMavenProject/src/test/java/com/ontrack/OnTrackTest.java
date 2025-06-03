
package com.ontrack;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OnTrackTest {

    @Test
    public void testSubmitAndRetrieveTask() {
        OnTrack system = new OnTrack();
        OnTrack.Task task = system.submitTask("student1", "Sample Task");
        List<OnTrack.Task> inbox = system.getTaskInbox("student1");
        assertEquals(1, inbox.size());
        assertEquals("Sample Task", inbox.get(0).title);
    }

    @Test
    public void testAddFeedback() {
        OnTrack system = new OnTrack();
        OnTrack.Task task = system.submitTask("student1", "Task A");
        OnTrack.Task updated = system.addFeedback(task.taskId, "Well done!");
        assertNotNull(updated);
        assertEquals("Well done!", updated.feedback);
    }

    @Test
    public void testMessaging() {
        OnTrack system = new OnTrack();
        OnTrack.Task task = system.submitTask("student1", "Task B");
        system.sendMessage(task.taskId, "student1", "tutor1", "Please review");
        List<OnTrack.Message> messages = system.getMessages(task.taskId);
        assertEquals(1, messages.size());
        assertEquals("Please review", messages.get(0).message);
    }
}
