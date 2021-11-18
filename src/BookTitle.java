
public class BookTitle {

	// Explicitly private variables. Explicitly private access modifiers - these
	// will need to be called by 'this.' for access. Declared Global Data types and
	// Classes. Contains a Primitive Data Type int and String Object class.
	private int bookId;
	private String bookTitle;
	private String authorName;
	private double averageRating;
	private long isbn;
	private String language;
	private int pageCount;
	private int ratingCount;
	private int textReviews;
	private String publicationDate;
	private String publisher;

	// This class contains all the constructors that will be invoked to create the
	// objects from this classes design.
	public BookTitle() {
		// initializing Global Variables and declaring the variables.
		this.bookId = 0;
		this.bookTitle = "Unknown";
		this.authorName = "Unknown";
		this.averageRating = 0.0;
		this.isbn = 0;
		this.language = "Unknown";
		this.pageCount = 0;
		this.ratingCount = 0;
		this.textReviews = 0;
		this.publicationDate = "Unknown";
		this.publisher = "Unknown";
	}

	// Getter and Setter explicitly public for accessible from everywhere.
	// Parameters within class to initialize attributes
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	public int getTextReviews() {
		return textReviews;
	}

	public void setTextReviews(int textReviews) {
		this.textReviews = textReviews;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
