package com.bazarapi.bazar.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comments")
public class CommentsController {

  @Autowired
  CommentsRepository commentsRepository;

  @PostMapping()
  public ResponseEntity<Comment> createComment(@RequestBody Comment comment) throws NoSuchElementException {
    Comment createdComment = commentsRepository.insert(comment);

    return ResponseEntity.created(URI.create(String.format("/comments/%s", createdComment.get_id()))).body(createdComment);
  }

}
