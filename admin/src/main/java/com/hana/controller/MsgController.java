package com.hana.controller;

import com.hana.app.data.msg.Msg;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
@Slf4j
@Controller
@RequiredArgsConstructor
public class MsgController {

    final SimpMessagingTemplate template;

    // 화면에서 소켓에서 /receiveall로 보낸다는 뜻
    @MessageMapping("/receiveall") // 모두에게 전송
    public void receiveall(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
        log.info(msg.toString());
        template.convertAndSend("/send",msg); // 화면에서 send라고 기다리는 놈에게 msg를 보낸다
    }
    @MessageMapping("/receiveme") // 나에게만 전송 ex)Chatbot
    public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
        log.info(msg.toString());

        String id = msg.getSendid();
        template.convertAndSend("/send/"+id,msg); // send뒤에 보내는사람id로 기다리는 놈에게 msg를 보낸다
    }
    @MessageMapping("/receiveto") // 특정 Id에게 전송
    public void receiveto(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
        String id = msg.getSendid();
        String target = msg.getReceiveid();
        log.info("-------------------------");
        log.info(msg.toString());
        template.convertAndSend("/send/to/"+target,msg);
    }
}
