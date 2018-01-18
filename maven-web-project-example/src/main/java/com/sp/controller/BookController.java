package com.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Book;
import com.sp.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bservice;

	/*---Add new book---*/
	@PostMapping("/book")
	public ResponseEntity<?> save(@RequestBody Book book) {
		long id = bservice.save(book);
		return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	}
	
	 /*---Get a book by id---*/
	   @GetMapping("/book/{id}")
	   public ResponseEntity<Book> get(@PathVariable("id") long id) {
	      Book book = bservice.get(id);
	      return ResponseEntity.ok().body(book);
	   }

	   /*---get all books---*/
	   @GetMapping("/book")
	   public ResponseEntity<List<Book>> list() {
	      List<Book> books = bservice.list();
	      return ResponseEntity.ok().body(books);
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/book/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
		   bservice.update(id, book);
	      return ResponseEntity.ok().body("Book has been updated successfully.");
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/book/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   bservice.delete(id);
	      return ResponseEntity.ok().body("Book has been deleted successfully.");
	   }
}
