package react.spring.react_spring_pjt.bbs.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react.spring.react_spring_pjt.bbs.service.BbsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/bbs")
public class BbsController {

    @Autowired
    private BbsService bbsService;
    
    // user endpoint : http://ip:port/bbs/index
    @GetMapping("/index")
    public ResponseEntity<Object> landing() {
        System.out.println("client endpoint : /bbs/index");

        List<BbsResponseDTO> list = bbsService.findAll();
        System.out.println("result size = " + list.size());
        if( list.size() == 0) {
            Map<String, String> map = new HashMap<>();
            map.put("info", "저장된 데이터가 존재하지 않습니다.");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody BbsRequestDTO params) {
        System.out.println("client endpoint : /bbs/save");
        System.out.println("params = " + params);

        if(params.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            bbsService.save(params);
            Map<String, String> map = new HashMap<>();
            map.put("info", "저장되었습니다.");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Object> viewList(@PathVariable("id") Integer id) {
        System.out.println("client endpoint : /bbs/view/{id}");

        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        Optional<BbsResponseDTO> response = bbsService.view(map);
        if(response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("해당하는 값이 없습니다.", HttpStatus.OK);
        }
        
    }
    
    
}
