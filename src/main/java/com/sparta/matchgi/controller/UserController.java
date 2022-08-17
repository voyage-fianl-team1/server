package com.sparta.matchgi.controller;

import com.sparta.matchgi.auth.auth.UserDetailsImpl;
import com.sparta.matchgi.dto.*;
import com.sparta.matchgi.service.PostService;
import com.sparta.matchgi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final PostService postService;

    @PostMapping("/api/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequestDto signupRequestDto){
        ResponseEntity<?>  responseEntity = userService.registerUser(signupRequestDto);

        return responseEntity;
    }

    //닉네임 변경
    @PutMapping("/api/users")
    public ResponseEntity<ReviseUserResponseDto> reviseUser(
            @RequestPart ReviseUserRequestDto reviseUserRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        return userService.reviseUser(reviseUserRequestDto, userDetails);
    }

    //비밀번호 변경
    @PutMapping("/api/users/password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto,
                                            @AuthenticationPrincipal UserDetailsImpl userDetails){
        return userService.changePassword(changePasswordDto, userDetails);
    }

    //내 경기 리스트
    @GetMapping("/api/users/requests")
    public ResponseEntity<MyMatchResponseDto> getMyMatch(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return userService.getMyMatch(userDetails);
    }

    @GetMapping("/api/users/posts")
    public ResponseEntity<MyPostResponseDto> getMyPost(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return userService.getMyPost(userDetails);
    }

    @GetMapping("/api/users")
    public ResponseEntity<MyPageResponseDto> getMyPage(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return userService.getMyPage(userDetails);
    }







}
