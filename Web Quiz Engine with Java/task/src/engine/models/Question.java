package engine.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class Question {
    private String title;
    private String text;
    private String[] options;
}
