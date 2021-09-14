package com.bazarapi.bazar;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BazarRepository extends MongoRepository<Bazar, String> {
}
