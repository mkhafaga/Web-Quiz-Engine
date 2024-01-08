package engine.services;

import engine.api.FeedbackResponse;
import engine.database.QuestionRepository;
import engine.exceptions.NotFoundException;
import engine.models.Question;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestion(long id) {
        return questionRepository.findById(id).orElseThrow(() -> new NotFoundException("Question not found"));
    }

    public Iterable<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public FeedbackResponse checkAnswer(long id, int index) {
        Question question = getQuestion(id);
        if( question.getAnswer() == index ) {
            return new FeedbackResponse(true, "Congratulations, you're right!");
        } else {
            return new FeedbackResponse(false, "Wrong answer! Please, try again.");
        }
    }
}
