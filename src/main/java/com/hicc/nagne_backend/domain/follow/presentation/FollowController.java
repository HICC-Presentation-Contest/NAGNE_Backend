package com.hicc.nagne_backend.domain.follow.presentation;

import com.hicc.nagne_backend.domain.follow.application.dto.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.service.SenderGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FollowController {

    private final SenderGetService senderGetService;

    @GetMapping("/followSender/{userId}")
    public List<FollowResponse.FollowInfoResponse> getSender(@PathVariable Long userId){
        return senderGetService.getSender(userId);
    }

}
