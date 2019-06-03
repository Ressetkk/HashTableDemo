# Hash Table Demo App
Here is a simple hashing table demo application made as an assignment project for University of Silesia.

## Description
The application lets you see how does the addressing, searching and removing works in open addressed hash tables.
You can choose between different probing methods that are commonly used for avoiding collisions and even specify the table's capacity.

**Features**

* Adding values to table
* Searching values by given key
* Removing value from given key
* Creating new table with different probing or capacity
* Showing verbose information when using method above
* Showing table schema on the fly

The application supports the following probing methods:

* Linear probing (chosen by default)
* Quadratic probing
* Double hashing

## Requirements
For running the application it is needed to have JRE 8 installed.

For building environment you need to have [OpenJDK 11](https://github.com/ojdkbuild/ojdkbuild) and Gradle installed. Building the `UberJar` is issued by using command `gradle build uberjar` in project root path.
The resulting files will be in `builds/lib` path.

## References
* https://inf.ug.edu.pl/~pmp/Z/ASDwyklad/haszowanie.pdf
* http://www.algolist.net/Data_structures/Hash_table/Open_addressing
* https://courses.csail.mit.edu/6.006/fall11/lectures/lecture10.pdf
* *Thomas H Cormen, Charles E, Leiserson, Ronald L. Rivest*, Introduction to Algorithms, 1990 by the Massachusetts Institute of Technology

**License**

MIT