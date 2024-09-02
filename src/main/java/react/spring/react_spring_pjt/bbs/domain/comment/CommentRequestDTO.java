package react.spring.react_spring_pjt.bbs.domain.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommentRequestDTO {
    private String content;
    private int bbsId;
}