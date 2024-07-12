package manito.server.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import manito.server.dto.PaperDto;
import manito.server.service.PaperService;
import manito.server.util.HttpServletUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paper")
public class PaperController {
    private final PaperService paperService;

    @PostMapping
    public ResponseEntity<?> create(HttpServletRequest request, @RequestBody PaperDto requestBody) {
        return new ResponseEntity<>(paperService.create(HttpServletUtil.getRequestHeaderDto(request), requestBody),
                HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getPapers(HttpServletRequest request, @PathVariable("userId") Long userid) {
        return new ResponseEntity<>(paperService.readList(HttpServletUtil.getRequestHeaderDto(request), userid), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(HttpServletRequest request, @RequestBody PaperDto requestBody) {
        return new ResponseEntity<>(paperService.update(HttpServletUtil.getRequestHeaderDto(request), requestBody),
                HttpStatus.OK);
    }
}
