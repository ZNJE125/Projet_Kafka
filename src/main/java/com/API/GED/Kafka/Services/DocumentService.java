package com.API.GED.Kafka.Services;

import com.API.GED.Kafka.Modeles.Document;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DocumentService {

    private final Map<Integer, Document> documentStore = new ConcurrentHashMap<>();
    private static int idCounter = 1;
    private final DocumentProducer documentProducer;

    public DocumentService(DocumentProducer documentProducer) {
        this.documentProducer = documentProducer;
    }

    public void addDocument(Document document) {
        document.setIdentifiant(idCounter++);
        documentStore.put(document.getIdentifiant(), document);
        //String eventMessage = "CREATE, Document ajouté : " + document.toString();
        documentProducer.sendEvent("CREATE", document.getIdentifiant());
    }

    public Document getDocument(Integer id){
        documentProducer.sendEvent("GET", id);
        return documentStore.get(id);

    }

    public void deleteDocument(Integer id){
        if(documentStore.containsKey(id)){
            documentStore.remove(id);
            documentProducer.sendEvent("DELETE" ,id);
        }


    }

}
