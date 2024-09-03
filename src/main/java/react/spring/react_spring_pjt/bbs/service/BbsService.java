package react.spring.react_spring_pjt.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import react.spring.react_spring_pjt.bbs.dao.BbsMapper;
import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BbsService {
    
    @Autowired
    private BbsMapper bbsMapper;

    public List<BbsResponseDTO> findAll() {
        System.out.println("debug >>> service findAll " + bbsMapper);
        return bbsMapper.findAllRow();
    };

    public void save(BbsRequestDTO params) {
        System.out.println("debug >>> service save " + bbsMapper);
        System.out.println("params = " + params);
        bbsMapper.saveRow(params);
    }

    public Optional<BbsResponseDTO> view(Map<String, Integer> map){
        System.out.println("debug >>> service view " + bbsMapper);
        Optional<BbsResponseDTO> response = bbsMapper.viewRow(map);

        ArrayList<CommentResponseDTO> list = bbsMapper.commentViewRow(map);

        if(response.isPresent()){
            response.get().setComment(list);
        }

        return response;
    }

    public void createComment(CommentRequestDTO params){
        System.out.println("debug >>> service createComment " + bbsMapper);

        bbsMapper.createComment(params);
    }

    public List<CommentResponseDTO> findComment(Map<String, Integer> map){
        List<CommentResponseDTO> list = bbsMapper.commentViewRow(map);

        return list;
    }

    public void delete(Map<String, Integer> map) {
        bbsMapper.deleteRow(map);
    }

    public void update(Map<String, Object> map) {
        bbsMapper.updateRow(map);
    }
}
