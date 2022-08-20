package com.sparta.matchgi.controller;

import com.sparta.matchgi.auth.auth.UserDetailsImpl;
import com.sparta.matchgi.service.UserRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserRoomController {

    private final UserRoomService userRoomService;


    @GetMapping("/api/users/rooms")
    public ResponseEntity<?> showUserRoom(@RequestParam Long lastActive, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return userRoomService.showUserRoom(lastActive,userDetails);
    }
}
