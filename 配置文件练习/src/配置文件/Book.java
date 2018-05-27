package 配置文件;

public class Book {
	private Integer id;
	private String name;	
	private String author;
	private Integer price;
	private Integer page;
	
	
	public Book() {

	}


	public Book(Integer id, String name, String author, Integer price, Integer page) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.page = page;
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}

	public String toString() {
		return "编号："+id+"，书名："+name+"，作者："+author+"，价格："+price+"，总页数："+page;
	}
}
