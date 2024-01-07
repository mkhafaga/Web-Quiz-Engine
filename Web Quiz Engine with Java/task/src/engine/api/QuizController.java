package engine.api;

import engine.models.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @GetMapping
    public ResponseEntity<Question> getQuestion() {
        Question question = new Question("The Java Logo", "What is depicted on the Java logo?",
                new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"});
        return ResponseEntity.ok(question);
    }

    @PostMapping
    public ResponseEntity<FeedbackResponse> solveQuestion(@RequestParam int answer) {
        if(answer == 2) {
            return ResponseEntity.ok(new FeedbackResponse(true, "Congratulations, you're right!"));
        } else {
            return ResponseEntity.ok(new FeedbackResponse(false, "Wrong answer! Please, try again."));
        }
    }
}
