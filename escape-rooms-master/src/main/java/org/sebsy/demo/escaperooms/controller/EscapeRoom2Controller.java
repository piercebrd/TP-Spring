package org.sebsy.demo.escaperooms.controller;

import org.sebsy.demo.escaperooms.bll.RoomService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller("room2")
public class EscapeRoom2Controller {
    private RoomService roomService;

    public EscapeRoom2Controller(RoomService roomService) {
        this.roomService = roomService;
    }

    public void entreeSalle2() {
        System.out.println(roomService.entreeSalle());
    }

}
