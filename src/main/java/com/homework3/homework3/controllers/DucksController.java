package com.homework3.homework3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.homework3.homework3.model.Duck;
import com.homework3.homework3.repository.DucksRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.homework3.homework3.repository.DucksRepository;

@RestController
public class DucksController {

    
    @GetMapping("/ducks/{id}/image")
    public ResponseEntity<Resource> getDuckImage(@PathVariable int id) {
        try {
            Path filePath = Paths.get("ducks/images/" + id + ".png");
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                String contentType = Files.probeContentType(filePath);
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    

    @Autowired
    private DucksRepository ducksRepository;

    @GetMapping("/ducks")
    public Iterable<Duck> getAllDucks() {
        return ducksRepository.getAllDucks();
    }

    @GetMapping("/ducks/{id}")
    public ResponseEntity<Duck> getDuck(@PathVariable int id) {
        Duck duck = ducksRepository.getDuck(id);
        if (duck != null) {
            return ResponseEntity.ok(duck);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/ducks")
    public ResponseEntity<Duck> addDuck(@RequestBody Duck duck) {
        Duck savedDuck = ducksRepository.addDuck(duck);
        return new ResponseEntity<>(savedDuck, HttpStatus.CREATED);
    }

    @PostMapping("/ducks/{id}/image")
    public String uploadImage(@PathVariable int id, @RequestParam("image") MultipartFile image) throws IOException {
        byte[] bytes = image.getBytes();
        Path path = Paths.get("ducks/images/" + id + ".png");
        Files.write(path, bytes);
        return "Image uploaded successfully";
    }

    @GetMapping("/ducks/{id}/downloadImage")
    public byte[] downloadImage(@PathVariable int id) throws IOException {
        Path path = Paths.get("ducks/images/" + id + ".png");
        return Files.readAllBytes(path);
    }

    @PostMapping("/ducks/{id}/audio")
    public String uploadAudio(@PathVariable int id, @RequestParam("audio") MultipartFile audio) throws IOException {
        byte[] bytes = audio.getBytes();
        Path path = Paths.get("ducks/audio/" + id + ".mp3");
        Files.write(path, bytes);
        return "Audio uploaded successfully";
    }

    @GetMapping("/ducks/{id}/audio")
    public byte[] downloadAudio(@PathVariable int id) throws IOException {
        Path path = Paths.get("ducks/audio/" + id + ".mp3");
        return Files.readAllBytes(path);
    }

     @GetMapping("/ducks/search")
     public Iterable<Duck> searchDucks(@RequestParam String type) {
         return ducksRepository.search(type);
     }
}
