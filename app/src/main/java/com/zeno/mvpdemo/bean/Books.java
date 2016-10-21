package com.zeno.mvpdemo.bean;

import java.util.List;

/**
 * Created by Zeno on 2016/10/18.
 */
public class Books {

    /**
     * Error : 0
     * Time : 0.0225
     * Total : 209
     * Page : 1
     * Books : [{"ID":947185260,"Title":"Head First PHP & MySQL","Description":"If you're ready to create web pages more complex than what you can build with HTML and CSS, Head First PHP & MySQL is the ultimate learning guide to building dynamic, database-driven websites using PHP and MySQL. Packed with real-world examples, this ...","Image":"http://s.it-ebooks-api.info/3/head_first_php__mysql.jpg","isbn":"9780596006303"},{"ID":4061324578,"Title":"PHP & MySQL: Novice to Ninja, 5th Edition","SubTitle":"The Easy Way to Build Your Own Database Driven Website","Description":"PHP & MySQL: Novice to Ninja, 5th Edition is a hands-on guide that will help you build your first database driven website. In the fifth edition of this best-selling book, you'll learn how to use PHP (used on 20 million sites worldwide) to build your ...","Image":"http://s.it-ebooks-api.info/7/php__mysql_novice_to_ninja_5th_edition.jpg","isbn":"9780987153081"},{"ID":2594711238,"Title":"Sams Teach Yourself PHP, MySQL and Apache All in One, 5th Edition","Description":"In just a short time, you can learn how to use PHP, MySQL, and Apache together to create dynamic, interactive websites and applications using the three leading open-source web development technologies. Using a straightforward, step-by-step approach, ...","Image":"http://s.it-ebooks-api.info/12/sams_teach_yourself_php_mysql_and_apache_all_in_one_5th_edition.jpg","isbn":"9780672335433"},{"ID":2279690981,"Title":"PHP & MySQL: The Missing Manual","Description":"If you can build websites with CSS and JavaScript, this book takes you to the next level-creating dynamic, database-driven websites with PHP and MySQL. Learn how to build a database, manage your content, and interact with users through queries and we ...","Image":"http://s.it-ebooks-api.info/3/php__mysql_the_missing_manual.jpg","isbn":"9780596515867"},{"ID":441392374,"Title":"Build Your Own Database Driven Web Site Using PHP & MySQL, 4th Edition","Description":"Build Your Own Database Driven Web Site Using PHP &amp; MySQL, 4th Edition is a practical, hands-on guide to learning all the tools, principles, and techniques needed to build a fully functional database driven web site using PHP &amp; MySQL. This bo ...","Image":"http://s.it-ebooks-api.info/7/build_your_own_database_driven_web_site_using_php.jpg","isbn":"9780980576818"},{"ID":225821771,"Title":"Beginning PHP and MySQL, 4th Edition","SubTitle":"From Novice to Professional","Description":"Beginning PHP and MySQL: From Novice to Professional, Fourth Edition is a major update of W. Jason Gilmore's authoritative book on PHP and MySQL. The fourth edition includes complete coverage of PHP 5.3 features, including namespacing, an update of A ...","Image":"http://s.it-ebooks-api.info/6/beginning_php_and_mysql_from_novice_to_professional_4th_edition.jpg","isbn":"9781430231141"},{"ID":1528037690,"Title":"Learning PHP & MySQL, 2nd Edition","SubTitle":"Step-by-Step Guide to Creating Database-Driven Web Sites","Description":"PHP and MySQL are quickly becoming the de facto standard for rapid development of dynamic, database-driven web sites. This book is perfect for newcomers to programming as well as hobbyists who are intimidated by harder-to-follow books. With concepts ...","Image":"http://s.it-ebooks-api.info/3/learning_php__mysql_2nd_edition.jpg","isbn":"9780596514013"},{"ID":4211610545,"Title":"PHP & MySQL: The Missing Manual, 2nd Edition","SubTitle":"The book that should have been in the box","Description":"If you can build websites with CSS and JavaScript, this book takes you to the next level - creating dynamic, database-driven websites with PHP and MySQL. Learn how to build a database, manage your content, and interact with users. With step-by-step t ...","Image":"http://s.it-ebooks-api.info/3/php__mysql_the_missing_manual_2nd_edition.jpg","isbn":"9781449325572"},{"ID":1752360057,"Title":"PHP & MySQL Web Development All-in-One Desk Reference For Dummies","Description":"PHP &amp; MySQL Web Development All-in-One Desk Reference For Dummies is kind of one-stop shopping for the information you need to get up and running with these tools and put them to good use. It's divided into six handy minibooks that cover setting ...","Image":"http://s.it-ebooks-api.info/9/php__mysql_web_development_all-in-one_desk_reference_for_dummies.jpg","isbn":"9780470167779"},{"ID":4152346111,"Title":"PHP, MySQL, JavaScript & HTML5 All-in-One For Dummies","Description":"PHP, JavaScript, and HTML5 are essential programming languages for creating dynamic websites that work with the MySQL database. PHP and MySQL provide a robust, easy-to-learn, open-source solution for creating superb e-commerce sites and content manag ...","Image":"http://s.it-ebooks-api.info/9/php_mysql_javascript__html5_all-in-one_for_dummies.jpg","isbn":"9781118213704"}]
     */

    private String Error;
    private double Time;
    private String Total;
    private int Page;
    /**
     * ID : 947185260
     * Title : Head First PHP & MySQL
     * Description : If you're ready to create web pages more complex than what you can build with HTML and CSS, Head First PHP & MySQL is the ultimate learning guide to building dynamic, database-driven websites using PHP and MySQL. Packed with real-world examples, this ...
     * Image : http://s.it-ebooks-api.info/3/head_first_php__mysql.jpg
     * isbn : 9780596006303
     */

    private List<BooksEntity> Books;

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public double getTime() {
        return Time;
    }

    public void setTime(double Time) {
        this.Time = Time;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int Page) {
        this.Page = Page;
    }

    public List<BooksEntity> getBooks() {
        return Books;
    }

    public void setBooks(List<BooksEntity> Books) {
        this.Books = Books;
    }

    public static class BooksEntity {
        private String ID;
        private String Title;
        private String Description;
        private String Image;
        private String isbn;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        @Override
        public String toString() {
            return "BooksEntity{" +
                    "ID=" + ID +
                    ", Title='" + Title + '\'' +
                    ", Description='" + Description + '\'' +
                    ", Image='" + Image + '\'' +
                    ", isbn='" + isbn + '\'' +
                    '}';
        }
    }
}
