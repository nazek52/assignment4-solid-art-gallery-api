Art Gallery Management System
A. SOLID Documentation

1. SRP – Single Responsibility Principle

Each class has one responsibility:

Artwork and its subclasses manage artwork data and value calculations.

Artist stores artist information.

ArtworkRepository manages data storage (CRUD operations).

ArtworkServiceImpl handles business logic.

ArtworkController manages user interaction (display & input).

Utilities (SortingUtils, ReflectionUtils) provide specific reusable functions.

2. OCP – Open/Closed Principle

Artwork is abstract. Subclasses (Painting, Sculpture) extend functionality without modifying the base class.

New artwork types can be added easily by creating new subclasses.

3. LSP – Liskov Substitution Principle

Anywhere an Artwork is expected, you can substitute a Painting or Sculpture without breaking the code.

Example: List<Artwork> stores both Painting and Sculpture.

4. ISP – Interface Segregation Principle

CrudRepository<T> defines a small, focused set of methods.

Classes only implement what they need.

Service and repository interfaces are clean and focused.

5. DIP – Dependency Inversion Principle

ArtworkServiceImpl depends on the CrudRepository<Artwork> interface, not a concrete class.

Repository is injected via the constructor.

B. Advanced OOP Features

Generics: CrudRepository<T> allows type-safe CRUD for any entity.

Lambdas: Used in ArtworkRepository.findById() and SortingUtils.sortByTitle() for filtering and sorting:

storage.stream().filter(a -> a.getId() == id).findFirst();
list.sort(Comparator.comparing(Artwork::getTitle));


Reflection: ReflectionUtils inspects class fields and methods dynamically.

Interface default/static methods: (Optional) CrudRepository could include default methods for logging or validation in the future.

C. OOP Documentation

Abstract Class + Subclasses:

Artwork (abstract) → Painting, Sculpture.

Composition:

Artwork contains an Artist object (private Artist artist).

Polymorphism:

calculateValue() is called on Artwork reference, behavior differs by subclass:

Artwork a = new Painting(...);
System.out.println(a.calculateValue()); // Painting logic applied


UML Diagram:

        +----------------+
        |    Artist      |
        +----------------+
        | - id:int       |
        | - name:String  |
        +----------------+
        | +getId()       |
        | +getName()     |
        +----------------+
                ^
                |
        +----------------+
        |   Artwork      |<----------------+
        +----------------+                 |
        | - id:int        |                 |
        | - title:String  |                 |
        | - price:double  |                 |
        | - asciiArt:String|                |
        | - artist:Artist |                 |
        +----------------+                 |
        | +calculateValue() abstract        |
        | +getType() abstract               |
        | +getDisplayName()                 |
        +----------------+                 |
                ^                          |
     ---------------------                 |
     |                   |                 |
+-----------+       +-----------+          |
| Painting  |       | Sculpture |          |
+-----------+       +-----------+          |
| - technique:String| - weight:int        |
+-----------+       +-----------+          |
| +calculateValue() | +calculateValue()   |
| +getType()        | +getType()          |
+-------------------+--------------------+

D. Database Section

Schema (artwork table example):

CREATE TABLE artist (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE artwork (
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    asciiArt TEXT,
    artist_id INT,
    type VARCHAR(50),
    FOREIGN KEY (artist_id) REFERENCES artist(id)
);


Sample Inserts:

INSERT INTO artist VALUES (1, 'Vincent van Gogh');
INSERT INTO artist VALUES (2, 'Leonardo da Vinci');

INSERT INTO artwork VALUES 
(1, 'Starry Night', 1000000, '...', 1, 'Painting'),
(2, 'Mona Lisa', 850000, '...', 2, 'Painting');

E. Architecture Explanation

Controller: ArtworkController – receives requests, calls service, prints results.

Service: ArtworkServiceImpl – contains business logic, enforces validation, calculates values.

Repository: ArtworkRepository – handles CRUD operations in memory (future DB support).

Example request/response flow:

Controller receives createArtwork() request.

Service validates artwork, passes to repository.

Repository stores artwork.

Controller prints confirmation.

F. Execution Instructions

Requirements:

Java 17+

MySQL database (if connecting)

JDBC driver (mysql-connector-java)

Compile & Run:

javac -d out src/**/*.java
java -cp out Main

G. Screenshots (Text-based demo in console)

CRUD Operations:

=== CREATING ARTWORKS ===
Artwork created: Painting: Starry Night
Artwork created: Painting: Mona Lisa
Artwork created: Sculpture: The Thinker
...


Validation Failure Example:

ERROR: Invalid input - title cannot be empty
ERROR: Resource not found with id 99


Reflection Output:

Class: Painting
Fields:
- id
- title
- price
- asciiArt
- artist
Methods:
- calculateValue
- getType
- getDisplayName
- getId
...


Sorted Titles:

Mona Lisa
Starry Night
Starry Night (Updated)
The Scream
The Thinker
Venus de Milo
David

H. Reflection Section

What I learned:

How to inspect class structure dynamically.

Difference between superclass and subclass fields/methods.

Challenges:

Handling private fields in reflection.

Managing duplicate IDs in an in-memory repository.

Value of SOLID:

Clean separation of concerns.

Easy extension for new artwork types.

Safe substitutions (LSP) and flexible dependency injection (DIP).
