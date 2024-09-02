package react.spring.react_spring_pjt.bbs.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;

@Mapper
public interface BbsMapper {
    
    public List<BbsResponseDTO> findAllRow() ;

    public void saveRow(BbsRequestDTO params);

    public Optional<BbsResponseDTO> viewRow(Map<String, Integer> map);

    public ArrayList<CommentResponseDTO> commentViewRow(Map<String, Integer> map);
}
