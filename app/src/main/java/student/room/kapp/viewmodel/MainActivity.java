package student.room.kapp.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        UsersViewModel usersViewModel =
                ViewModelProviders.of(this).get(UsersViewModel.class);
      //  List<User> list =  usersViewModel.getUserList();

        /*Observer<List<User>> observer = new Observer<List<User>>(){

            @Override
            public void onChanged(@Nullable List<User> users) {

            }
        };
        usersViewModel.getUserList().observe(this, observer);*/


        usersViewModel.getUserList().observe(this, new Observer<List<User>>() {
                    @Override
                    public void onChanged(@Nullable List<User> list) {
                        userList = list;
                        for (int i = 0; i < list.size(); i++) {
                            Log.i(TAG, "list of data : " + userList.get(i).getName());
                        }

                    }
                });

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
