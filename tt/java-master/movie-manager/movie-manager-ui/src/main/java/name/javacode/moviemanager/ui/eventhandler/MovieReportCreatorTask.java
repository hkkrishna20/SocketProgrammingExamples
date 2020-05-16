package name.javacode.moviemanager.ui.eventhandler;

import static name.javacode.moviemanager.ui.util.UIUtil.cleanup;
import static name.javacode.moviemanager.ui.util.UIUtil.sleepForSomeTime;

import java.awt.Window;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import name.javacode.moviemanager.delegate.MovieManager;
import name.javacode.moviemanager.domain.Movie;
import name.javacode.moviemanager.domain.Summary;
import name.javacode.moviemanager.ui.AnimatedFrame;
import name.javacode.moviemanager.util.ConfigManager;

public class MovieReportCreatorTask extends SwingWorker<Void, List<Object>> {

	public MovieReportCreatorTask(JButton createButton, File inputDir,
			File outputFile, JLabel messageLabel) {
		this.createButton = createButton;
		this.messageLabel = messageLabel;
		this.w = SwingUtilities.windowForComponent(createButton);

		animator = new AnimatedFrame(w);

		try {
			movieManager = new MovieManager(inputDir, outputFile);
		} catch (Exception ex) {
			this.ex = ex;
			this.cancel(true);
		}
	}

	@Override
	protected Void doInBackground() {
		// List<Object> chunks = new ArrayList<Object>();

		sleepForSomeTime(1000L);

		try {
			w.setEnabled(false);
			animator.setVisible(true);

			Map<String, Set<Movie>> movieSetGroupedByGenre = MovieManager
					.getMovieSetGroupedByGenre();
			Summary summary = MovieManager.getSummary(movieSetGroupedByGenre);

			MovieManager.createSummarySheet(summary);
			
			List<String> genreList = ConfigManager.getGenreList();

			for (String genre : genreList) {
				// chunks.add(movieSetGroupedByGenre.get(genre));
				// chunks.add(genre);

				// publish(chunks);

				MovieManager.createGenreSheet(
						movieSetGroupedByGenre.get(genre), genre);
			}

			sleepForSomeTime(1000L);
		} catch (Exception ex) {
			this.ex = ex;
			this.cancel(true);
		}

		return null;
	}

	@Override
	public void done() {
		String message = null;

		if (!isCancelled()) {
			message = "Successfully created the requested report.";
			cleanup(true, createButton, messageLabel, message, message);
		} else {
			cleanup(false, createButton, messageLabel, ex.getMessage(), null,
					ex);
		}

		animator.setVisible(false);
		animator.dispose();

		w.setEnabled(true);
		w.toFront();
	}

	// @Override
	// @SuppressWarnings("unchecked")
	// protected void process(List<List<Object>> chunks) {
	// SortedSet<Movie> filteredMovieSetByGenre = null;
	// Genre genre = null;
	//
	// for (List<Object> chunk : chunks) {
	// filteredMovieSetByGenre = (SortedSet<Movie>) (chunk.get(0));
	// genre = (Genre) (chunk.get(1));
	//
	// try {
	// MovieManager.createGenreSheet(filteredMovieSetByGenre, genre);
	// } catch (Exception ex) {
	// this.ex = ex;
	// this.cancel(true);
	// }
	// }
	// }
	private JButton createButton;
	@SuppressWarnings("unused")
	private MovieManager movieManager;
	private JLabel messageLabel;
	private Exception ex = null;
	private JFrame animator = null;
	private Window w = null;
}
