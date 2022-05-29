package com.example.demo;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Map;


@RestController
// value : localhost:8080/posts로 접근할 경우 이 controller에 접근한다.
// produces : 반환타입을 강제
// comsumes : 소비 가능한 미디어 타입을 지정해서 일치할 때만 요청을 매칭
@RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoPostController {

    //샘플을 위하여 서블릿 내부에서 데이터 저장토록 구성. 해당 샘플을 재사용할경우 DB에 데이터 저장을 권장
    ArrayList<DemoEntity> demoEntities= new ArrayList<>();

    //게시글 추가(HTTP 메서드 : POST, 본문 데이터형식 : JSON, 경우 메시지 소비)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    //ResponseEntity 상태코드 제어
    @ApiOperation(value = "Swagger Sample - POST", notes = "게시글 추가(HTTP 메서드 : POST, 본문 데이터형식 : JSON, 경우 메시지 소비)")
    public ResponseEntity<String> createPost(@RequestBody Map<String, String> requestBody){
  
	    System.out.println("createPost");
        //Business Logic 추가
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setPostId(requestBody.get("postId"));
        demoEntity.setTitle(requestBody.get("title"));
        demoEntity.setContents(requestBody.get("contents"));
        demoEntities.add(demoEntity);
        // return new ResponseEntity<Void>(HttpStatus.OK);
        return new ResponseEntity<>("result successful", HttpStatus.OK);
    }
    
    //특정 게시글 조회(HTTP 메서드 : GET, 본문 데이터형식 : 없음, 경우 메시지 소비)
    //ex) localhost:8080/posts/1 
    @GetMapping(value = "/{postId}")
    //PathVariable은 URI에 넘어온 postId 값을 가져오기 위해 사용
    @ApiOperation(value = "Swagger Sample - GET", notes = "특정 게시글 조회(HTTP 메서드 : GET, 본문 데이터형식 : 없음, 경우 메시지 소비)")
    public DemoEntity getPost(@PathVariable String postId){

        System.out.println("ListPost");
        //Business Logic 추가
        DemoEntity demoEntity = new DemoEntity();
        demoEntity=demoEntities.get(Integer.parseInt(postId)-1);
        return demoEntity;
    }
    
    //특정 게시글 업데이트(HTTP 메서드 : PUT, 본문 데이터형식 : 없음, 경우 메시지 소비)
    @PutMapping(value = "/{postId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Swagger Sample - PUT", notes = "특정 게시글 업데이트(HTTP 메서드 : PUT, 본문 데이터형식 : 없음, 경우 메시지 소비)")
    public ResponseEntity<String> updatePost(@PathVariable String postId, @RequestBody Map<String, String> requestBody){

        System.out.println("UpdatePost");
        //Business Logic 추가
        DemoEntity demoEntity = demoEntities.get(Integer.parseInt(postId)-1);
        demoEntity.setPostId(requestBody.get("postId"));
        demoEntity.setTitle(requestBody.get("title"));
        demoEntity.setContents(requestBody.get("contents"));
        return new ResponseEntity<>("result successful", HttpStatus.OK);
    }

    //특정 게시글 삭제(HTTP 메서드 : DELETE, 본문 데이터형식 : 없음, 경우 메시지 소비)
    @DeleteMapping("/{postId}")
    @ApiOperation(value = "Swagger Sample - DELETE", notes = "특정 게시글 삭제(HTTP 메서드 : DELETE, 본문 데이터형식 : 없음, 경우 메시지 소비)")
    public ResponseEntity<String> deletePost(@PathVariable String postId){

        System.out.println("DeletePost");
        //Business Logic 추가
        demoEntities.remove(Integer.parseInt(postId)-1);
        return new ResponseEntity<>("result successful", HttpStatus.OK);
    }
}