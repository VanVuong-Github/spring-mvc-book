package laivanvuong.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import laivanvuong.dao.BookDao;
import laivanvuong.entity.Book;

@Controller
public class BookController {
	@Autowired
	private BookDao dao;

	@Autowired
	private SessionFactory sessionFactory;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/book/manager")
	public String manager(Model model) {
		model.addAttribute("books", dao.getAll());
		return "manager";
	}

	@GetMapping("/book")
	public String getById(@RequestParam("id") int id, Model model) {
		Book book = dao.getBookById(id);
		model.addAttribute("book", book);
		return "book-detail";
	}

	@GetMapping("/book/list")
	public String list(Model model) {
		model.addAttribute("books", dao.getAll());
		return "book-list";
	}

	@GetMapping("/book/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "book-form";
	}

	@GetMapping("/book/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("book", dao.getBookById(id));
		return "book-form";
	}

	@GetMapping("/book/delete")
	public String delete(@RequestParam("id") int id) {
		dao.deleteBook(id);
		return "redirect: list";
	}

	@PostMapping("/book/save")
	@Transactional
	public String save(@RequestParam("fileUpload") MultipartFile multipartFile,
			@ModelAttribute("book") @Validated Book book, BindingResult bindingResult)
			throws IOException, SQLException {
		if (bindingResult.hasErrors()) {
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				System.err.println(objectError);
				System.err.println(objectError.getCode());
			}
			return "book-form";
		}
		Blob blob = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(multipartFile.getBytes());
		try (InputStream is = blob.getBinaryStream(); ByteArrayOutputStream os = new ByteArrayOutputStream();) {
			byte[] buffer = new byte[1024];
			int read = is.read(buffer);
			while (read != -1) {
				os.write(buffer, 0, read);
				read = is.read(buffer);
			}
			byte[] encode = Base64.getEncoder().encode(os.toByteArray());
			book.setImage(new String(encode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.saveBook(book);
		return "redirect: list";
	}
}
