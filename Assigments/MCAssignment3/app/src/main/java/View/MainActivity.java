package View;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import Controller.LiveDataProvider;
import Model.ResponseBO;
import Utils.MessageDialog;
import Utils.NetworkHelper;
import pk.edu.pucit.mcassignment3.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MoviesAdapter movieAdapter;
    private Context context = this;
    private boolean networkOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkOk = NetworkHelper.hasNetworkStatus(this);
        MessageDialog messageDialog = new MessageDialog(this);
        if (!networkOk) {
            messageDialog.showAlert();
        } else {
           // startService(new Intent(MainActivity.this, MyService.class));
            new GetServerData().execute();
            recyclerView = findViewById(R.id.recycler_view_show_list_activity_main);
            recyclerView.addItemDecoration(
                    new DividerItemDecoration(this,
                            DividerItemDecoration.VERTICAL));

        }
    }

    public class GetServerData extends AsyncTask<Void, Void, ResponseBO> {

        private ProgressBar progressBar;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar = findViewById(R.id.progress_bar_loading_activity_main);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected ResponseBO doInBackground(Void... voids) {
            try {
                LiveDataProvider liveDataProvider = new LiveDataProvider();
                return liveDataProvider.getServerData();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ResponseBO responseBO) {
            super.onPostExecute(responseBO);
            progressBar.setVisibility(View.INVISIBLE);

            if (responseBO != null && responseBO.getMovieArrayList() != null && responseBO.getMovieArrayList().size() > 0) {
                movieAdapter = new MoviesAdapter(responseBO.getMovieArrayList(), context);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(movieAdapter);

            } else {
                Toast.makeText(getApplicationContext(), "Response is empty, please try again.", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onProgressUpdate(Void... voids) {
            super.onProgressUpdate();
        }
    }
}
