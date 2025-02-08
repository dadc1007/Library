**Integrantes**   
Daniel Alejandro Diaz Camelo.  
Vicente Garzon Rios.

**Pasos**  
1. Creamos el proyecto maven.  
![alt text](assets/create_maven_proyect.png)  
2. Agregamos las dependencias de JUnit.  
![alt text](assets/JUnit_dependence.png)  
3. Verificamos la verion de java.  
![alt text](assets/java_version.png)  
4. Agregamos el plugin para ejecutar java.  
![alt text](assets/java_plugin.png)  
5. Verificamos que compile correctamente.  
![alt text](assets/mvn_package.png)
6. Agregamos el esqueleto del proyecto.  
![alt text](assets/structure.png)  
7. Creamos las diferentes clases.  
![alt text](assets/book_class.png)  
![alt text](assets/loan_class.png)  
![alt text](assets/loanStatus_enum.png)  
![alt text](assets/user_class.png)  
![alt text](assets/library_class.png)  
8. Creamos la clase de pruebas para Library.  
![alt text](assets/LibraryTest.png)  
9. Implementamos las pruebas para el metodo addBook y luego verificamos que estas fallen.  
![alt text](assets/shouldAddBook.png)  
![alt text](assets/shouldAddBook_test.png)  
![alt text](assets/shouldIncreaseAmountIfBookExists.png)  
![alt text](assets/shouldIncreaseAmountIfBookExists_test.png)  
![alt text](assets/shouldAmountBeOneForNewBook.png)  
![alt text](assets/shouldAmountBeOneForNewBook_test.png)
10. Implementamos las pruebas para el metodo loanBook y luego verificamos que estas fallen. 
![alt text](assets/shouldLoanABook.png)  
![alt text](assets/shouldLoanABook_test.png)  
![alt text](assets/notShouldLoanABookIfUserNotExist.png)  
![alt text](assets/notShouldLoanABookIfUserNotExist_test.png)  
![alt text](assets/notShouldLoanABookForTheSameBook.png)  
![alt text](assets/notShouldLoanABookForTheSameBook_test.png)  


x. Agregamos la dependencia de jacoco.  
 ![alt text](assets/jacoco_dependence.png)  