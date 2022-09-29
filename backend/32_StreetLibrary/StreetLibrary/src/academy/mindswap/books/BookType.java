package academy.mindswap.books;

public enum BookType {
    CLEAN_CODE("Robert C. Martin", "Clean Code"),
    START_WITH_WHY("Simon Sinek", "Start with Why"),
    THE_CHECKLIST_MANIFESTO("Atul Gawande", "The Checklist Manifesto"),
    DONT_MAKE_ME_THINK("Steve Krug", "Don't Make Me Think"),
    CODE_COMPLETE("Steve McConnell", "Code Complete");

    private final String author;
    private final String name;

    BookType(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }
}
