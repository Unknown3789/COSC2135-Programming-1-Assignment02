import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BackEnd {

	// Explicitly private variables. Explicitly private access modifiers - these
	// will need to be called by 'this.' for access. Declared Global Data types and
	// Classes.
	private BookTitle[] bookList;
	private String filePath;
	private int entryCounter;
	private int maxBookNo;

	// Constructor Class, this class contains all the constructors that will be
	// invoked to create the objects from this classes design.
	public BackEnd() {
		// initialised filePath for hardcoded BufferedReading and BufferWriting.
		this.filePath = "bookList.csv";

		// initializing Global Variables and declaring the variables .
		this.maxBookNo = 22;

		// Creating new Book object within Constructor. Utilizing a while loop however,
		// a for loop would better used as there is specific count needed per array. No
		// real conditions need to be met that warrant a while loop.
		this.bookList = new BookTitle[this.maxBookNo];
		int i = 0;
		while (i < this.maxBookNo) {
			this.bookList[i] = new BookTitle();
			i++;
		}

		// initializing Global Variables Setting the Declared variable counter
		// commencing at index 0.
		this.entryCounter = 0;

		// This function discreetly loads the File data in the background and populates
		// entryCounter.
		this.fileReader();
	}

	// The File is called here as it only needs to be called once and
	// not again after the program is running.
	// BufferedReader is used over FileReader due to its efficiency in terms of
	// performance. BufferedReader IO operations are less and its performance is
	// better, reading in larger chunks over FileReader with reads directly from
	// File in smaller byte sized operations.
	public void fileReader() {

		BufferedReader reader = null;
		// Try and Catch utilised for exception catching for invalid BufferedReading.
		try {
			reader = new BufferedReader(new FileReader("bookList.csv"));
			String currentLine = reader.readLine();

			if (currentLine != null && !currentLine.equals("")) {
				currentLine = reader.readLine();
				// While Loop works well in this example over a for loop, as conditions are
				// being utilised instead of counters.
				while (currentLine != null && !currentLine.equals("")) {
					String[] addBook = currentLine.split(",");
					//expandMaxEntry included in While Loop to Expand memory on start up.
					this.expandMaxEntry();
					this.addBookTitle(Integer.parseInt(addBook[0]), addBook[1].trim(), addBook[2].trim(),
							Double.parseDouble(addBook[3]), Long.parseLong(addBook[4]), addBook[5].trim(),
							Integer.parseInt(addBook[6]), Integer.parseInt(addBook[7]), Integer.parseInt(addBook[8]),
							addBook[9], addBook[10]);
					currentLine = reader.readLine();

				}
			}
			reader.close();

		} catch (Exception e) {
			System.out.println("");
			String errorMessage = "Error: Nothing Entered";
			System.out.println(errorMessage);

		}
	}

	// Class object to add Book Title information. Parameters within class to
	// initialize attributes.
	public void addBookTitle(int bookId, String bookTitle, String authors, double averageRating, long isbn,
			String language, int pageCount, int ratingCount, int textReviews, String publicationDate,
			String publisher) {

		this.bookList[this.entryCounter].setBookId(bookId);
		this.bookList[this.entryCounter].setBookTitle(bookTitle);
		this.bookList[this.entryCounter].setAuthorName(authors);
		this.bookList[this.entryCounter].setAverageRating(averageRating);
		this.bookList[this.entryCounter].setIsbn(isbn);
		this.bookList[this.entryCounter].setLanguage(language);
		this.bookList[this.entryCounter].setPageCount(pageCount);
		this.bookList[this.entryCounter].setRatingCount(ratingCount);
		this.bookList[this.entryCounter].setTextReviews(textReviews);
		this.bookList[this.entryCounter].setPublicationDate(publicationDate);
		this.bookList[this.entryCounter].setPublisher(publisher);
		this.entryCounter++;
	}

	// Class object that allows access to the book array for edit and modifying
	// objects. Parameters within class to initialize attributes.
	public void editBookTitle(int bookId, String bookTitle, String authors, double averageRating, long isbn,
			String language, int pageCount, int ratingCount, int textReviews, String publicationDate, String publisher,
			int index) {
		this.bookList[index].setBookId(bookId);
		this.bookList[index].setBookTitle(bookTitle);
		this.bookList[index].setAuthorName(authors);
		this.bookList[index].setAverageRating(averageRating);
		this.bookList[index].setIsbn(isbn);
		this.bookList[index].setLanguage(language);
		this.bookList[index].setPageCount(pageCount);
		this.bookList[index].setRatingCount(ratingCount);
		this.bookList[index].setTextReviews(textReviews);
		this.bookList[index].setPublicationDate(publicationDate);
		this.bookList[index].setPublisher(publisher);
	}

	// Allows FrontEnd to utilize a selected book array.
	public BookTitle getBook(int index) {
		return this.bookList[index];
	}

	// Boolean method to check if database is full, checked against maxBookNo.
	public boolean IsDatabaseFull() {
		return this.getEntryCounter() >= this.maxBookNo;
	}

	// Utilizing removeTitle method to delete the selected index row. if statement
	// counting down the arrays to the specific index that was deleted.
	public int removeTitle(int index) {
		if (index != -1) {
			this.removeEntry(index);
			return 0;

		}
		return -1;
	}

	// removeEntry(int index) uses a local conditional statement, this creates the
	// base for the new array. With a while loop and if statement to traverse the
	// index selection to copy the 'originalIndex' array and create "anotherArray"
	// minus the skipped array that was selected.
	// A for loop would be more beneficial within this function for readability and
	// neatness of program.
	// ArrayCopy() and For Loops would be more efficient and readable for this
	// class.
	public void removeEntry(int index) {

		BookTitle[] anotherArray = new BookTitle[bookList.length];

		int i = 0;
		int originalIndex = 0;
		while (originalIndex < bookList.length) {
			if (i == index && originalIndex < bookList.length - 1) {
				originalIndex++;
			}

			anotherArray[i] = bookList[originalIndex];

			i++;
			originalIndex++;
		}
		bookList = anotherArray;
		entryCounter--;
	}

	// Hardcoded BufferedWriter that re-writes the file after adding, editing or
	// deleting entries to keep the file up to date. False clause allows for File
	// overwriting.
	public boolean saveFile() {
		// Try and Catch utilised for exception catching for invalid BufferedWriting.
		try {
			BufferedWriter writeFile = new BufferedWriter(new FileWriter(this.filePath, false));
			writeFile.write(
					"bookID,title,authors,average_rating,isbn,language_code,  num_pages,ratings_count,text_reviews_count,publication_date,publisher\n");
			int i = 0;
			while (i < this.entryCounter) {
				writeFile.write(this.bookList[i].getBookId() + ", " + this.bookList[i].getBookTitle() + ", "
						+ this.bookList[i].getAuthorName() + "," + this.bookList[i].getAverageRating() + ","
						+ this.bookList[i].getIsbn() + "," + this.bookList[i].getLanguage() + ","
						+ this.bookList[i].getPageCount() + "," + this.bookList[i].getRatingCount() + ","
						+ this.bookList[i].getTextReviews() + "," + this.bookList[i].getPublicationDate() + ","
						+ this.bookList[i].getPublisher());
				writeFile.write("\n");
				i++;
			}
			// Returning True will complete a successful write.
			writeFile.close();
			return true;

		} catch (Exception e) {
			// Returning a False will throw exception.
			System.out.println("");
			String errorMessage = "Error: " + e.getMessage();
			System.out.println(errorMessage);
			return false;
		}
	}

	// expandMaxEntry creates a new Book Object and Copies the array. This allows
	// for runtime expansion of an array. ArrayCopy() and For Loops would be more
	// efficient and readable for this class.
	public void expandMaxEntry() {

		BookTitle[] temp = new BookTitle[this.maxBookNo + 1];
		int j = 0;
		while (j < bookList.length) {
			temp[j] = bookList[j];
			j++;
		}
		temp[temp.length - 1] = new BookTitle();
		this.maxBookNo++;
		bookList = temp;
	}

	// Getter and Setter explicitly public for accessible from everywhere.
	// Parameters within class to initialize attributes
	public int getEntryCounter() {
		return entryCounter;
	}
}