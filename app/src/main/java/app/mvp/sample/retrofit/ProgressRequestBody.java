package app.mvp.sample.retrofit;

import android.os.Handler;
import android.os.Looper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * Developer: Neha Gupta
 * Dated: 16/11/17
 */
public final class ProgressRequestBody extends RequestBody {
    private static final int DEFAULT_BUFFER_SIZE = 2048;
    private static final int HUNDRED = 100;
    private File mFile;
    private UploadCallbacks mListener;

    /**
     * Instantiates a new Progress request body.
     *
     * @param file     the file
     * @param listener the listener
     */
    public ProgressRequestBody(final File file, final UploadCallbacks listener) {
        mFile = file;
        mListener = listener;
    }

    @Override
    public MediaType contentType() {
        return MediaType.parse("*/*");
    }

    @Override
    public long contentLength() throws IOException {
        return mFile.length();
    }

    @Override
    public void writeTo(final BufferedSink sink) throws IOException {
        long fileLength = mFile.length();
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        FileInputStream in = new FileInputStream(mFile);
        long uploaded = 0;
        try {
            int read;
            Handler handler = new Handler(Looper.getMainLooper());
            while ((read = in.read(buffer)) != -1) {
                // update progress on UI thread
                handler.post(new ProgressUpdater(uploaded, fileLength));
                uploaded += read;
                sink.write(buffer, 0, read);
            }
        } finally {
            in.close();
        }
    }

    /**
     * The interface Upload callbacks.
     */
    public interface UploadCallbacks {
        /**
         * On progress update.
         *
         * @param percentage the percentage
         */
        void onProgressUpdate(int percentage);

        /**
         * On error.
         */
        void onError();

        /**
         * On finish.
         */
        void onFinish();
    }

    /**
     * The type Progress updater.
     */
    private final class ProgressUpdater implements Runnable {
        private long mUploaded;
        private long mTotal;

        /**
         * Instantiates a new Progress updater.
         *
         * @param uploaded the uploaded
         * @param total    the total
         */
        private ProgressUpdater(final long uploaded, final long total) {
            mUploaded = uploaded;
            mTotal = total;
        }

        @Override
        public void run() {
            mListener.onProgressUpdate((int) (HUNDRED * mUploaded / mTotal));
        }
    }
}