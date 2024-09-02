package react.spring.react_spring_pjt.bbs.domain;

import lombok.Data;

@Data
public class BbsRequestDTO {
    private String title;
    private String content;

    public boolean isEmpty() {
        return (title == null || title.isEmpty()) || (content == null || content.isEmpty());
    }
}
