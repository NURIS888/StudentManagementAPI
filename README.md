This is a system for managing student information in a computerized environment. It is an electronic library cart containing the particulars about the students in an establishment of learning in respect of their first names, last names, date of birth, and current grades attained.

This system is designed to:

* Input students into the system, which means inserting the information of the new students into the system as they join the institution.
* View student information, which means finding a particular student in the system and viewing his or her information by name, last name, major, etc.
* Update information, which means altering a student's information when, for instance, he or she moves to a new address or changes his or her phone number.
* Filter the data; that is, prepare a list of students meeting certain criteria: all students in a particular program, or all students with outstanding debts.
* Delete a student's records, i.e., information is removed from the system about a student after he or she has graduated or otherwise left the institution.

API Endpoints Overview:

GET /students – Retrieve all students
GET /students/123 – Retrieves the student with ID 123
POST /students – Adds new student
PUT /students/123 – Update data for the student, ID 123
DELETE /students/123 – Delete student with ID 123

Additional details:

HTTP Methods: GET, POST, PUT, and DELETE are standard HTTP methods used for interacting with a server.
URL: A uniform resource locator is defined as a unique pointer to information on the world-opening of the Internet. 
