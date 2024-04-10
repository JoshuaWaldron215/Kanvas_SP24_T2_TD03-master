package model.modulecontent;

import java.time.LocalDateTime;

public class Announcement {
    private String topic;
    private String text;
    private LocalDateTime publishDateTime;

    public Announcement(String topic, String text) {
        this.topic = topic;
        this.text = text;
    }

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

}
