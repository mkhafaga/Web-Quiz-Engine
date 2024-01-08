package engine.models;

import com.fasterxml.jackson.annotation.JsonValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class Option {
    @Id
    @GeneratedValue
    private int id;
    @JsonValue
    @NonNull private String val;
}
