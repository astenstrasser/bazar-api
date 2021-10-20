package com.bazarapi.bazar.comments;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentsRepository extends MongoRepository<Comment, String> {
}
