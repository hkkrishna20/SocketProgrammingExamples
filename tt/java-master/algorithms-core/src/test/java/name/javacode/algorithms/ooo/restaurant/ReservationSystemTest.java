package name.javacode.algorithms.ooo.restaurant;

import static name.javacode.algorithms.ooo.restaurant.Table.SpecialFeature.WINDOW_SIDE;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import name.javacode.algorithms.ooo.restaurant.Table.SpecialFeature;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReservationSystemTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationSystemTest.class);

	@Before
	public void setUp() {
		Table blahTable;
		Table windowSideTable;

		blahTable = new Table(1, 2);
		windowSideTable = new Table(2, 2);
		windowSideTable.setSpecialFeatures(Arrays.asList(new SpecialFeature[] { WINDOW_SIDE }));

		TableManager.setAllTables(new HashSet<Table>(Arrays.asList(new Table[] { blahTable, windowSideTable })));
	}

	/*
	 * @Test public void testMakeReservation() { final Date now = new Date();
	 * 
	 * int reservationID1 = ReservationSystem.makeReservation("Author", 2, now);
	 * 
	 * Reservation r = ReservationSystem.lookUpReservation("Author", now);
	 * 
	 * Assert.assertNotNull(r);
	 * 
	 * int reservationID2 = ReservationSystem.makeReservation("Author", 2, now);
	 * 
	 * r = ReservationSystem.lookUpReservation("Author", now);
	 * 
	 * Assert.assertNotNull(r);
	 * 
	 * Assert.assertTrue(reservationID2 > reservationID1); }
	 * 
	 * @Test(expected = UnableToCompleteReservationException.class) public void
	 * testMakeReservationsUntilTablesExhausted() { while (true) {
	 * ReservationSystem.makeReservation("Author", 2, new Date()); } }
	 * 
	 * @Test public void testCancelReservation() { final Date now = new Date();
	 * 
	 * ReservationSystem.makeReservation("Author", 2, now);
	 * 
	 * int reservationId = ReservationSystem.makeReservation("Author", 2, now,
	 * WINDOW_SIDE);
	 * 
	 * boolean reservationCancelled = ReservationSystem.cancelReservation("Author",
	 * now);
	 * 
	 * Assert.assertTrue(reservationCancelled);
	 * 
	 * Reservation r = ReservationSystem.lookUpReservation("Author", now);
	 * 
	 * Assert.assertEquals(reservationId, r.reservationNumber()); }
	 * 
	 * @Test public void testConcurrentHandling() { ExecutorService executor =
	 * Executors.newFixedThreadPool(2);
	 * 
	 * for (int i = 0; i < 4; ++i) { final Runnable reserver = new
	 * WorkerThread("makeReservation"); executor.execute(reserver);
	 * 
	 * final Runnable canceller = new WorkerThread("cancelReservation");
	 * executor.execute(canceller); }
	 * 
	 * executor.shutdown();
	 * 
	 * while (!executor.isTerminated()) ; }
	 * 
	 */ private static class WorkerThread implements Runnable {
		private final String m;

		private WorkerThread(String m) {
			this.m = m;
		}

		@Override
		public void run() {
			LOGGER.info("{} running.", m);

			try {
				final int sleepTime = ThreadLocalRandom.current().nextInt(6);
				LOGGER.info("{} going to sleep for {}.", m, sleepTime);

				Thread.sleep(sleepTime);

				if (m.equals("makeReservation")) {
					ReservationSystem.makeReservation("Author", 2, new Date());
				} else {
					ReservationSystem.cancelReservation("Author", new Date());
				}
			} catch (InterruptedException e) {
				LOGGER.warn(e.getMessage(), e);
			}
		}
	}
}
