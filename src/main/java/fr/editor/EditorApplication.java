package fr.editor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class EditorApplication {

    public static void main(String[] args) {
        SpringApplication.run(EditorApplication.class, args);
    }

    @GetMapping("/info")
    public ResponseEntity<String> getAllBooks() {

        return ResponseEntity.ok().body("Hello editor");
    }

}
