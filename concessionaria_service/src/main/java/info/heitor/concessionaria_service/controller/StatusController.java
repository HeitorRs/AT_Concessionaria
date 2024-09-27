package info.heitor.concessionaria_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class StatusController {

    @GetMapping("/status")
    public String status() {
        return "Service Status: Ativo";
    }
}
