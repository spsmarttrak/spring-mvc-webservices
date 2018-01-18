package com.sp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sp.dao.BookDao;
import com.sp.model.Book;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Transactional
	public long save(Book book) {
		
		return bookDao.save(book);
	}

	public Book get(long id) {
		return bookDao.get(id);
	}

	public List<Book> list() {
		 return bookDao.list();
	}
	
	@Transactional
	public void update(long id, Book book) {
		 bookDao.update(id, book);
		
	}
	 @Transactional
	public void delete(long id) {
		 bookDao.delete(id);
		
	}

	

}
