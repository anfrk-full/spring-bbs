package react.spring.react_spring_pjt.bbs.domain;

import java.util.ArrayList;

import lombok.Data;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;

@Data //(Setter, Getter, ToString 다 포함하는 어노테이션)
public class BbsResponseDTO {
    private Integer id;
    private String title;
    private String content;

    private ArrayList<CommentResponseDTO> comment;
}
