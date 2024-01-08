package engine.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Question {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String text;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="question_id", nullable=false)
    private List<Option> options;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int answer;
}
