package hello.springmvc.basic.requestMapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
    /**
    회원 목록 조회: GET /mapping/users
    회원 등록: POST /mapping/users
    회원 조회: GET /mapping/users/id1
    회원 수정: PATCH /mapping/users/id1
    회원 삭제: DELETE /mapping/users/id1
     **/

    //@GetMapping("/mapping/users")
    @GetMapping
    public String user(){
        return "get users";
    }

    //@PostMapping("/mapping/users")
    @PostMapping
    public String addUser(){
        return "post users";
    }

    //@GetMapping("/mapping/users/{userId}")
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "get userId=" + userId;
    }

    //@PatchMapping("/mapping/users/{userId}")
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "updatd userId=" + userId;
    }

    //@DeleteMapping("/mapping/users/{userId}")
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        return "delete userId=" + userId;
    }
}
