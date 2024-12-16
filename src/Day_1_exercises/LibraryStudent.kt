
fun main(){
    val LibraryStudentObj=LibraryStudent()
    val Book1=Book(
        id=1,
        title="Bhagvat Geeta",
        quantity = 10
    )
    val Book2=Book(
        id=2,
        title="Shrimad Ramayana",
        quantity = 5
    )
    LibraryStudentObj.addBook(Book1)
    LibraryStudentObj.addBook(Book2)

    val Student1=Student(
        id=1,
        name="Shubham"
    )
    val Student2=Student(
        id=2,
        name="Kaival"
    )
    val Student3=Student(
        id=3,
        name="Michael"
    )
    LibraryStudentObj.addStudent(Student1)
    LibraryStudentObj.addStudent(Student2)
    LibraryStudentObj.addStudent(Student3)

    LibraryStudentObj.listBooks()
    LibraryStudentObj.listSudents()

    LibraryStudentObj.deleteStudent(id=3)
    LibraryStudentObj.listSudents()

    LibraryStudentObj.lendBook(Book1, Student1 )
    LibraryStudentObj.lendBook(Book2, Student2 )
//    LibraryStudentObj.lendBook(Book2, Student1 )

    LibraryStudentObj.listBooksInCirculation()

    LibraryStudentObj.listBooks()

    LibraryStudentObj.returnBook(Book2,Student1)

    LibraryStudentObj.listBooksInCirculation()

    LibraryStudentObj.listBooks()






}


class LibraryStudent {
    var books: List<Book> = emptyList()
    var students: List<Student> = emptyList()
    var booksInCirculation= mutableListOf<Pair<Book,Student>>()
    init{

    }

    fun addBook(book : Book){
        books = books + book
    }

    fun addStudent(student: Student){
        students = students + student
    }

    fun listBooks(){
        println()
        println("Books available:")
        books.forEach {
            println("${it.id} : ${it.title} : ${it.quantity}")
        }
    }

    fun listSudents(){
        println()
        println("Students List")
        students.forEach {
            println("${it.id} : ${it.name}")
        }
    }

    fun deleteBook(id:Int){
        books = books.filter { it.id != id }
    }

    fun deleteStudent(id:Int){
        students=students.filter { it.id != id }
    }

    fun lendBook(book:Book, student:Student) {
        val availableBook = books.find { it.id == book.id && it.quantity > 0 }
        if (availableBook != null) {
            booksInCirculation.add(book to student)
            books = books.map { b ->
                if (b.id == book.id) b.copy(quantity = b.quantity - 1) else b
            }
        } else {
            println("No available copies of ${book.title} for ${student.name}.")
        }
    }

    fun returnBook(book:Book, student:Student){
        // Remove the book-student pair from circulation
        booksInCirculation.removeAll { it.first == book && it.second == student }
        // Increase the book quantity
        books = books.map { b ->
            if (b.id == book.id) b.copy(quantity = b.quantity + 1) else b
        }
    }

    fun listBooksInCirculation(){
        println()
        println("Books in circulation:")
        booksInCirculation.forEach {
            println("${it.first.title} - ${it.second.name}")
        }
    }

}

data class Book(
    val id: Int,
    val title: String,
    val quantity: Int
)

data class Student(
    val id: Int,
    val name: String
)