import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrontEndConsole {

	// Explicitly private variables. Explicitly private access modifiers - these
	// will need to be called by 'this.' for access.
	private BackEnd myBackEnd;
	// BufferedReader initialized for User Inputs.
	private BufferedReader inputScanner;

	// public FrontEndConsole is the constructor class. This class contains all the
	// constructors that will be invoked to create the objects from this classes
	// design.This class is only designed to take inputs and nothing else. Contains
	// a single parameter to allow access to the BackEnd.
	public FrontEndConsole(BackEnd backEnd) {

		// Initialized variables to allow them to be called with 'this.'.
		this.myBackEnd = backEnd;
		System.out.println("Best Reads!");
		System.out.println("");
		System.out.println("A Light and Easy Application to explore reviewed Novels!");
		System.out.println("");
		System.out.println(" ___________________________________________________________");
		String readFileName = systemInput("| Welcome! Please make your Selection:                      |");
		while (readFileName.equals("") || !readFileName.equalsIgnoreCase("exit")) {
			readFileName = systemInput("\n" + "Please make a Selection: ");
		}
		this.myBackEnd.saveFile();
	}

	// User Input method, utilising if else if statments. Switch statments would be
	// more readbale and faster for this oepration.
	public String systemInput(String userPrompts) {


		

		String systemInput = null;
		// Try and Catch utilised for exception catching for invalid BufferedReading.
		try {
			if (this.inputScanner == null)
				this.inputScanner = new BufferedReader(new InputStreamReader(System.in));

			System.out.println(userPrompts);

			System.out.println(" ___________________________________________________________");
			System.out.println("| [0] View Book Entries                                     |");
			System.out.println("| [1] Search for Book Entry >> Must be exact Title name <<  |");
			System.out.println("| [2] Add a Book Title                                      |");
			System.out.println("| [3] Edit a Book Entry                                     |");
			System.out.println("| [4] Delete a Book Entry                                   |");
			System.out.println("| [5] Save a Book Entry                                     |");
			System.out.println("| [6] Expand your Book Entry Inventory                      |");
			System.out.println("| [exit] Exit                                               |");
			System.out.println(" ___________________________________________________________");

			systemInput = this.inputScanner.readLine();
			// if else statments for user inputs.
			if (systemInput.equals("0")) {
				this.viewTable();
			} else if (systemInput.equals("1")) {
				this.searchTitle();
			} else if (systemInput.equals("2")) {
				this.addTitle();
			} else if (systemInput.equals("3")) {
				this.editTitle();
			} else if (systemInput.equals("4")) {
				this.deleteEntry();
			} else if (systemInput.equals("5")) {
				this.saveToFile();
			} else if (systemInput.equals("6")) {
				// User Option to Expand Memory if Needed
				this.myBackEnd.expandMaxEntry();
			} else if (systemInput.equalsIgnoreCase("exit")) {
				System.out.println("");
				System.out.println(">>TTYL, Good Bye<<");
			}

		} catch (Exception e) {
			// Throws format exception if nothing or incorrect primitive type is entered.
			System.out.println("");
			String errorMessage = "Error: Incorrect Input";
			System.out.println(errorMessage);

		}
		// Will repeat functions until conditions are met, from above selection.
		return systemInput;

	}

	// Console Table, created using System.out.format, utilizing String and Integer
	// specifiers. Here the formatter is aligning to the Left indicated with '-' and
	// spacing as per number entered, set out as per data type 's' for String.
	public void viewTable() {

		String leftAlignFormat = "| %-7s| %-82s | %-46s | %-18s | %-10s | %-18s | %-15s | %-12s | %-12s | %-16s | %-25s |%n";

		System.out.format(
				"+--------+------------------------------------------------------------------------------------+------------------------------------------------+--------------------+------------+--------------------+-----------------+--------------+--------------+------------------+---------------------------+%n");
		System.out.format(
				"| BookID | Book Title                                                                         | Authors                                        | Average Rating     | ISBN       | Language           | Number of Pages | Rating Count | Review Count | Publication Date | Publisher                 |%n");
		System.out.format(
				"+--------+------------------------------------------------------------------------------------+------------------------------------------------+--------------------+------------+--------------------+-----------------+--------------+--------------+------------------+---------------------------+%n");
		int i = 0;

		while (i < this.myBackEnd.getEntryCounter()) {
			System.out.format(leftAlignFormat, this.myBackEnd.getBook(i).getBookId(),
					this.myBackEnd.getBook(i).getBookTitle().trim(), this.myBackEnd.getBook(i).getAuthorName(),
					this.myBackEnd.getBook(i).getAverageRating(), this.myBackEnd.getBook(i).getIsbn(),
					this.myBackEnd.getBook(i).getLanguage(), this.myBackEnd.getBook(i).getPageCount(),
					this.myBackEnd.getBook(i).getRatingCount(), this.myBackEnd.getBook(i).getTextReviews(),
					this.myBackEnd.getBook(i).getPublicationDate(), this.myBackEnd.getBook(i).getPublisher());
			i++;
		}
		System.out.format(
				"+--------+------------------------------------------------------------------------------------+------------------------------------------------+--------------------+------------+--------------------+-----------------+--------------+--------------+------------------+---------------------------+%n");

		System.out.println("");
		System.out.println("");

	}

	// public addTitle is a user defined method attached to a button, this invokes
	// additional functions if the If statement confirms maxEntryNo has vacant
	// memory by boolean statement isDatabaseFull. Utilizing read functions to take
	// the User input and the add functions to add the records into their specific
	// array type.
	public void addTitle() {
		// Surrounded by Try and Catch to notify User of incorrect Inputs made.
		try {
			if (!myBackEnd.IsDatabaseFull()) {
				// Get input for all parameters
				System.out.println("Please Enter the Book ID Number");
				int bookId = Integer.parseInt(this.inputScanner.readLine());

				System.out.println("Please Enter the Book Title");
				String bookTitle = this.inputScanner.readLine();

				System.out.println("Please Enter the Authors Name");
				String authorName = inputScanner.readLine();

				System.out.println("Please Enter the Average Rating for Book");
				double averageRating = Double.parseDouble(this.inputScanner.readLine());

				System.out.println("Please Enter the ISBN number for Book - Max 10 digit");
				int isbn = Integer.parseInt(this.inputScanner.readLine());

				System.out.println("Please Enter the Language of the Book");
				String language = this.inputScanner.readLine();

				System.out.println("Please Enter the Page Count for the the Book");
				int pageCount = Integer.parseInt(this.inputScanner.readLine());

				System.out.println("Please Enter total Ratings");
				int ratingCount = Integer.parseInt(this.inputScanner.readLine());

				System.out.println("Please Enter total Reviews");
				int textReviews = Integer.parseInt(this.inputScanner.readLine());

				System.out.println("Please Enter Publication Date");
				String publicationDate = this.inputScanner.readLine();

				System.out.println("Please Enter Publisher");
				String publisher = this.inputScanner.readLine();

				this.myBackEnd.addBookTitle(bookId, bookTitle, authorName, averageRating, isbn, language, pageCount,
						ratingCount, textReviews, publicationDate, publisher);
				System.out.println("");
				System.out.println("");
				System.out.println("************Title Entered Successfully************");

			} else {
				System.out.println("\n************Sorry Database is Full************");
			}
			System.out.println("");
			System.out.println("");
			// Will throw exception when blank or incorrect inputs have been entered in the
			// above function.
		} catch (Exception e) {
			System.out.println("");
			String errorMessage = "Error: Incorrect Input";
			System.out.println(errorMessage);
		}
	}

	// searchTitle is a User defined method that traverses the this.getBook(Index)
	// array for a String object match. Using a while and nested if statement to
	// traverse
	// the array index. Commencing at -1 at int matchTitle as index 0 is a current
	// Title array index, if and else statement to confirm Title match or No Title
	// found and print into the console. Must be exact Title Strings without and
	// WhiteSpace.
	public void searchTitle() {

		String bookName = null;
		// Multiple condition while for Input checks.
		while (bookName == null || !bookName.isBlank() || bookName.equals("0")) {
			System.out.println("Please Enter a Book Title");
			// Try and Catch utilised for exception catching for invalid BufferedReading.
			try {
				bookName = inputScanner.readLine().trim();

				int index = 0;
				int matchTitle = -1;
				while (index < this.myBackEnd.getEntryCounter()) {
					if (bookName.contentEquals(this.myBackEnd.getBook(index).getBookTitle())) {
						matchTitle = index;
					}
					index++;
				}
				if (matchTitle != -1) {
					String foundMatch = "Here is the Title\n\n" + "Title: "
							+ this.myBackEnd.getBook(matchTitle).getBookTitle() + "\nAuthor: "
							+ this.myBackEnd.getBook(matchTitle).getAuthorName() + "\nPublication Date: "
							+ this.myBackEnd.getBook(matchTitle).getPublicationDate() + "\nAverage Rating: "
							+ this.myBackEnd.getBook(matchTitle).getAverageRating() + "\n ISBN: "
							+ this.myBackEnd.getBook(matchTitle).getIsbn();
					System.out.println(foundMatch);
					System.out.println("");
				} else if (bookName.isBlank()) {
					System.out.println(">>>>No Title Entered<<<<");
				}
				// Throws exception if Title has not been found.
			} catch (IOException e) {
				System.out.println("");
				String errorMessage = "Error: Incorrect Input has been Entered";
				System.out.println(errorMessage);

			}
		}
	}

	// editTitle is a User defined method that allows the User to select the desired
	// Row Index and change the array object within the array. Using read functions
	// to edit the Rows stored objects.
	// Try and Catch has been placed inside to appropriately catch negative Integer
	// selections.
	public void editTitle() {

		try {
			System.out.println("Please Select the Row You wish to Edit");
			int indexSelection = Integer.parseInt(inputScanner.readLine());
			if (indexSelection < 0) {
				System.out.println("There is no Entries Selected");
				System.out.println("");
				System.out.println("");

			} else if (indexSelection != -1) {

				// Get input for all parameters
				System.out.println("Please Enter the Book ID Number");
				int bookId = Integer.parseInt(inputScanner.readLine());

				System.out.println("Please Enter the Book Title");
				String bookTitle = inputScanner.readLine();

				System.out.println("Please Enter the Authors Name");
				String authorName = inputScanner.readLine();

				System.out.println("Please Enter the Average Rating for Book");
				double averageRating = Double.parseDouble(inputScanner.readLine());

				System.out.println("Please Enter the ISBN number for Book");
				int isbn = Integer.parseInt(inputScanner.readLine());

				System.out.println("Please Enter the Language of the Book");
				String language = inputScanner.readLine();

				System.out.println("Please Enter the Page Count for the the Book");
				int pageCount = Integer.parseInt(inputScanner.readLine());

				System.out.println("Please Enter total Ratings");
				int ratingCount = Integer.parseInt(inputScanner.readLine());

				System.out.println("Please Enter total Reviews");
				int textReviews = Integer.parseInt(inputScanner.readLine());

				System.out.println("Please Enter Publication Date");
				String publicationDate = inputScanner.readLine();

				System.out.println("Please Enter Publisher");
				String publisher = inputScanner.readLine();

				this.myBackEnd.editBookTitle(bookId, bookTitle, authorName, averageRating, isbn, language, pageCount,
						ratingCount, textReviews, publicationDate, publisher, indexSelection);

				System.out.println("");
				System.out.println("************Your Title has been Successfully Changed************");
				System.out.println("");
			}

		} catch (IOException e) {
			System.out.println("");
			String errorMessage = "Error: Input was Empty";
			System.out.println(errorMessage);
		}
	}

	// deleteEntry Method that allows user to select a row index and delete the
	// selected row by invoking the removeTitle method.
	// Utilizing removeEntry method inside of removeTitle method that is called
	// myBackEnd class to delete the selected index row. if statement confirms an
	// array has been selected to delete index. else if and an else statement to
	// confirm entry is present or not selected.
	public void deleteEntry() {

		System.out.println("Please Select the Row You wish to Delete");
		// Try and Catch surrounds BufferReader for excpeiotn catching from incorrect
		// User Input.
		try {
			int indexSelection = Integer.parseInt(inputScanner.readLine());
			int result = this.myBackEnd.removeTitle(indexSelection);

			if (result != -1) {
				System.out.println("");
				System.out.println("************Your Title has been Successfully removed************");
				System.out.println("");

			} else {
				System.out.println("");
				System.out.println("");
			}
			// Will throw exception for incorrect inputs.
		} catch (NumberFormatException | IOException e) {
			System.out.println("");
			String errorMessage = "Error: No Row Selected to be Deleted";
			System.out.println(errorMessage);
		}
	}

	// User Defined WriteToFile, User inputs specificed File Name they would like
	// the file to write to.
	public void saveToFile() {

		String bookName = null;
		while (bookName == null) {
			System.out.println("Please Enter a Book Title");
			// Try and Catch utilised for exception catching for invalid BufferedWriting.
			try {
				bookName = inputScanner.readLine().trim();

				int index = 0;
				int matchTitle = -1;
				// For Loop would be more efficent instead of While due to counting entry
				// counters instead of conditions.
				while (index < this.myBackEnd.getEntryCounter()) {
					if (bookName.contentEquals(this.myBackEnd.getBook(index).getBookTitle())) {
						matchTitle = index;
					}
					index++;
				}
				if (matchTitle != -1) {
					String foundMatch = "Title: " + this.myBackEnd.getBook(matchTitle).getBookTitle() + "\nAuthor: "
							+ this.myBackEnd.getBook(matchTitle).getAuthorName() + "\nPublication Date: "
							+ this.myBackEnd.getBook(matchTitle).getPublicationDate() + "\nAverage Rating: "
							+ this.myBackEnd.getBook(matchTitle).getAverageRating() + "\nISBN: "
							+ this.myBackEnd.getBook(matchTitle).getIsbn() + "\n";

					System.out.println("Please enter the new File name: ");
					String newFile = this.inputScanner.readLine();
					BufferedWriter writeToFile = new BufferedWriter(new FileWriter(newFile + ".csv", true));
					// While loop works for this example as a condition stands.
					while (!foundMatch.isBlank()) {
						writeToFile.write(foundMatch + "\n");
						foundMatch = this.inputScanner.readLine();

					}
					System.out.println(">>>>Successfully Written<<<<");
					writeToFile.close();
				}
			} catch (Exception e) {
				System.out.println("");
				String errorMessage = "Error: " + e.getMessage();
				System.out.println(errorMessage);
			}
		}
		if (bookName.isBlank()) {
			System.out.println("Please enter a Book Title or Ensure there is no whitespace before or after Title.");
		}
	}
}
