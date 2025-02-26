package com.API.GED.Kafka.Controllers;

import com.API.GED.Kafka.Modeles.Document;
import com.API.GED.Kafka.Services.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/get/{i}")
    public ResponseEntity<Document> getDocument(@PathVariable("i") Integer id) {
        Document document = documentService.getDocument(id);
        if (document != null) {
            return new ResponseEntity<>(document, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDocument(@RequestBody Document doc) {
        documentService.addDocument(doc);
        return new ResponseEntity<>("Document créé avec succès", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity<String> deleteDocument(@PathVariable("i") Integer id) {
        documentService.deleteDocument(id);
        return new ResponseEntity<>("Document supprimé avec succès", HttpStatus.OK);
    }
}
