package laivanvuong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", columnDefinition = "nvarchar(255)")
	@NotBlank(message = "Tên sách không được để trống")
	private String name;
	
	@Column(name = "author", columnDefinition = "nvarchar(255)")
	@NotBlank(message = "Tên tác giả không được để trống")
	private String author;
	
	@NotNull(message = "Năm xuất bản không được để trống")
	@Min(value = 1800, message = "Năm xuất bản phải sau năm 1800")
	@Max(value = 2021, message = "Năm xuất bản phải trước năm hiện tại")
	private Integer publishYear;

	@Min(value = 0, message = "Điểm đánh giá phải lớn hơn 0")
	@Max(value = 10, message = "Điểm đánh giá phải nhỏ hơn 10")
	@NotNull(message = "Điểm đánh giá không được để trống")
	private Float rating;

	@Column(columnDefinition = "nvarchar(max)")
	private String image;

	public Book(int id, String name, String author, Integer publishYear, Float rating, String image) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publishYear = publishYear;
		this.rating = rating;
		this.image = image;
	}

	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publishYear=" + publishYear + ", rating="
				+ rating + ", image=" + image + "]";
	}
	
	
}
