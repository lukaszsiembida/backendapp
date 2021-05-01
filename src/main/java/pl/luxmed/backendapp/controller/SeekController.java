package pl.luxmed.backendapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.luxmed.backendapp.dto.EmployeeDto;
import pl.luxmed.backendapp.dto.SeekTextDto;
import pl.luxmed.backendapp.service.SeekService;

import java.util.List;

@RestController
public class SeekController {

    private final SeekService seekService;

    public SeekController(SeekService seekService) {
        this.seekService = seekService;
    }

    @PostMapping("/employees/seek")
    ResponseEntity<List<EmployeeDto>> getSeekListEmployees(@RequestBody SeekTextDto dto) {
        return ResponseEntity.ok(seekService.getSeekListEmployees(dto));
    }
}
