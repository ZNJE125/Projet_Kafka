package com.API.GED.Kafka.Repositories;


import com.API.GED.Kafka.Modeles.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
