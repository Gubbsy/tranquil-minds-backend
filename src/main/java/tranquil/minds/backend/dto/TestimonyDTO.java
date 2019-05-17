package tranquil.minds.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestimonyDTO {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "date")
    private String date;

    @JsonProperty(value = "content")
    private String content;

    public TestimonyDTO(String title, String date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
