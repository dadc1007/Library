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
![alt text](assets/notShouldLoanABookIfIsNotAvailable.png)  
![alt text](assets/notShouldLoanABookIfIsNotAvailable_test.png)  
![alt text](assets/notShouldLoanABookIfUserNotExist.png)  
![alt text](assets/notShouldLoanABookIfUserNotExist_test.png)  
![alt text](assets/notShouldLoanABookForTheSameBook.png)  
![alt text](assets/notShouldLoanABookForTheSameBook_test.png)  
![alt text](assets/shouldDecreaseBookCountWhenLoanIsCreated.png)  
![alt text](assets/shouldDecreaseBookCountWhenLoanIsCreated_test.png)  

11. Implementamos las pruebas para el metodo returnLoan y luego verificamos que estan fallen.  

![alt text](assets/shouldIncreasedBookCountWhenLoanIsReturned.png)  
![alt text](assets/shouldIncreasedBookCountWhenLoanIsReturned_Test.png)  
![alt text](assets/shouldReturnLoan.png)  
![alt text](assets/shouldReturnLoan_test.png)  
![alt text](assets/shouldLoanSameBookWhenReturnLoan.png)  
![alt text](assets/shouldLoanSameBookWhenReturnLoan_Test.png)  

12. Implementamos el método addBook. Sobrescribimos el método hashCode en la clase Book para que los libros con el mismo isbn sean tratados como la misma clave en el HashMap de la clase Library. Esto evita duplicados no deseados y permite gestionar correctamente la cantidad de ejemplares de cada libro.  

![alt text](assets/addBook_implementation.png)  
![alt text](assets/hashCode_implementation.png)  

13. Implementamos el método loanABook. Sobrescribimos el método equals en la clase User para que la comparación entre usuarios se realice en función de su id, garantizando que dos objetos User con el mismo id sean tratados como el mismo usuario.    

![alt text](assets/loanABook_implementation.png)  
![alt text](assets/methods_for_loanABook.png)  
![alt text](assets/methods_for_loanABook2.png)  
![alt text](assets/User_equals.png)  

14. Implementamos el método returnLoan. Implementamos el método equals de la clase Loan para poder realizar la comparativa.  

![alt text](assets/returnLoan_implementation.png)  
![alt text](assets/loan_Equals.png)  

13. Ejecutamos las pruebas para verificar que todas pasen exitosamente, asegurándonos de que los cambios implementados cumplen con los requisitos establecidos en TDD.  

![alt text](assets/successful_tests.png)  


x. Agregamos la dependencia de jacoco.  
 ![alt text](assets/jacoco_dependence.png)  