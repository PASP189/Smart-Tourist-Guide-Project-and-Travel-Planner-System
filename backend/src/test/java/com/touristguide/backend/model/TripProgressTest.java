package com.touristguide.backend.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// This class tests the TripProgress class in isolation - no database,
// no web server, just checking that the Java logic itself behaves correctly.
class TripProgressTest {

    @Test
    void triggerSafetyAlertIfNear_returnsTrue_whenAtSameDestination() {
        // ARRANGE: set up the objects we need for this test
        Destination sigiriya = new Destination();
        sigiriya.setId(1L);
        sigiriya.setName("Sigiriya");

        TripProgress progress = new TripProgress();
        progress.setCurrentNearest(sigiriya);

        // ACT: call the actual method we're testing
        boolean result = progress.triggerSafetyAlertIfNear(sigiriya);

        // ASSERT: check the result is what we expect
        assertTrue(result, "Should return true when the tourist is at the same destination");
    }

    @Test
    void triggerSafetyAlertIfNear_returnsFalse_whenAtDifferentDestination() {
        Destination sigiriya = new Destination();
        sigiriya.setId(1L);

        Destination ella = new Destination();
        ella.setId(2L);

        TripProgress progress = new TripProgress();
        progress.setCurrentNearest(sigiriya);

        boolean result = progress.triggerSafetyAlertIfNear(ella);

        assertFalse(result, "Should return false when the tourist is near a different destination");
    }
}