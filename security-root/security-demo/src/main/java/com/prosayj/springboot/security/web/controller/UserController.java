package com.prosayj.springboot.security.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.prosayj.springboot.security.dto.User;
import com.prosayj.springboot.security.dto.UserQuery;
import com.prosayj.springboot.security.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private ProviderSignInUtils providerSignInUtils;


    @PostMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "创建用户服务")
    public User create(@Valid @RequestBody User user, BindingResult error) {
        // System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        if (error.hasErrors()) {
            error.getAllErrors().forEach(data -> System.out.println(data.getDefaultMessage()));
        }
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "修改用户服务")
    public User update(@Valid @RequestBody User user, BindingResult error) {
        if (error.hasErrors()) {
            error.getAllErrors().forEach(data -> System.out.println(data.getDefaultMessage()));
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation(value = "删除用户服务")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }


    //@GetMapping("/{id}")//url路径传值
    @GetMapping("/{id:\\d+}")//url路径传值+正则匹配(只能是数字)
    @ApiOperation(value = "获取用户详情服务")
    @JsonView(User.UserDetailView.class)//JsonView:返回值对象中某些字段不展示
    public User getInfo(@ApiParam("用户id") @PathVariable(name = "id", required = true) String id) {
        System.out.println("进入getInfo服务,userId: " + id);
        User user = new User("tom", "123");
        return user;

        //注意:当使用自定义异常的时候，没有抛出错误信息，因为自定义的异常被ControllerExceptionHandler处理
        //throw new UserNotExistException(id);
        //throw new RuntimeException("user not exist");
    }

    @GetMapping
    //展示全量视图
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户列表查询服务")
    public List<User> query(UserQuery query,
                            @PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {
        System.out.println(ReflectionToStringBuilder.toString(query, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>(3);
        users.add(new User("tom", "123"));
        users.add(new User("jack", "456"));
        users.add(new User("cc", "679"));
        return users;
    }


//    @PostMapping("/regist")
//    public void regist(User user, HttpServletRequest request) {
//
//        //不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
//        String userId = user.getUsername();
////        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
//    }
//
//    @GetMapping("/me")
//    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
//        return user;
//    }
//
//
//


}
