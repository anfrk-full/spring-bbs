package react.spring.react_spring_pjt.bbs.domain.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommentResponseDTO {
    private Integer id;
    private String content;
    private Integer bbsId;
}