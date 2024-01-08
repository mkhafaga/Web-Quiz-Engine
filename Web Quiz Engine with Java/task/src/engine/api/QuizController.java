package engine.api;

import engine.exceptions.NotFoundException;
import engine.models.Question;
import engine.services.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api")
public class QuizController {
    private final QuestionService questionService;

    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/quizzes")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.createQuestion(question));
    }

    @PostMapping("/quizzes/{id}/solve")
    public ResponseEntity<FeedbackResponse> solveQuestion(@PathVariable long id, @RequestParam("answer") int index) {
        return ResponseEntity.ok(questionService.checkAnswer(id, index));
    }

    @GetMapping("/quizzes/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable long id) {
        return ResponseEntity.ok(questionService.getQuestion(id));
    }

    @GetMapping("/quizzes")
    public ResponseEntity<Iterable<Question>> getQuestionList() {
        return ResponseEntity.ok(questionService.getQuestions());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException ex, WebRequest req) {
        return ResponseEntity.notFound().build();
    }
}
