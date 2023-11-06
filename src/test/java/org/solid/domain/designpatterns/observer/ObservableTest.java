package org.solid.domain.designpatterns.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObservableTest {

    private Observable observable;
    @Mock
    private Observer observer;
    @Mock
    private Observer observer1;
    @Mock
    private Observer observer2;

    @BeforeEach
    void setUp() {
        observable = new Observable();
    }

    @Test
    void testAddObserver() {
        // Act
        observable.addObserver(observer);

        // Assert
        assertTrue(observable.getObserverList().contains(observer));
    }

    @Test
    void testDeleteObserver() {

        observable.addObserver(observer);

        // Act
        observable.deleteObserver(observer);

        // Assert
        assertFalse(observable.getObserverList().contains(observer));
    }

    @Test
    void testNotifyObservers() {

        observable.addObserver(observer1);
        observable.addObserver(observer2);

        // Act
        observable.notifyObservers();

        // Assert
        verify(observer1, times(1)).update();
        verify(observer2, times(1)).update();
    }

    @Test
    void testNotifyObserversWithNoObservers() {

        // Act
        observable.notifyObservers();

        // Assert
        // No exceptions should be thrown when notifying with no observers
    }
}