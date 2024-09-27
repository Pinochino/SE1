import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Provider;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReadInfoFileTest {

   @BeforeEach
    void setUp() {

   }

   @Test
    public void testReadDepartmentFromFile_Success() throws FileNotFoundException{

       Scanner mockScanner = mock(Scanner.class);

       when(mockScanner.hasNext()).thenReturn(true, true, false);
       when(mockScanner.nextLine()).thenReturn("Dept1", "Dept2");

       List<Department> departments = ReadInfoFile.readDepartmentsFromFile("Department.txt");

       verify(mockScanner, times(2)).nextLine();

       assertNotNull(departments);
       assertEquals(2, departments.size());
       assertEquals("Dept1", departments.get(0).getDepartmentName());
       assertEquals("Dept2", departments.get(1).getDepartmentName());
   }

   @Test
    public void testReadDepartmentsFromFile_FileNotFound(){
       assertThrows(FileNotFoundException.class, () -> {
           ReadInfoFile.readCoursesFromFile("non_existing_file.txt");
       });
   }

   @Test
    public void testReadProfessorsFromFile_EmptyFile() throws FileNotFoundException {

       Scanner mockScanner = mock(Scanner.class);
       when(mockScanner.hasNext()).thenReturn(false);

       List<Professor> professors  = ReadInfoFile.readProfessorsFromFile("empty_professors.txt");

       assertTrue(professors.isEmpty());
   }
}