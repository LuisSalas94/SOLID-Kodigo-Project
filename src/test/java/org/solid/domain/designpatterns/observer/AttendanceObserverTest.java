package org.solid.domain.designpatterns.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AttendanceObserverTest {

    private AttendanceObserver observer;
    private ByteArrayOutputStream outputStream;
    @BeforeEach
    void setUp() {
        observer = new AttendanceObserver();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testUpdate(){
        // Act
        observer.update();

        // Assert
        String expectedOutput = "The attendance has been updated. Carrying out corresponding actions...\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
