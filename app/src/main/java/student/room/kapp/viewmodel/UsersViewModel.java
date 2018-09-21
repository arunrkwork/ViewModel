package student.room.kapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arunraj on 3/5/2018.
 */

public class UsersViewModel extends ViewModel {

    private MutableLiveData<List<User>> userList;
    public static final String TAG = "ViewModel";

    public LiveData<List<User>> getUserList() {
        Log.d(TAG, "getUserList: ");
        if (userList == null) {
            Log.d(TAG, "getUserList: inner ");
            userList = new MutableLiveData<>();
            loadUsers();
        }
        return userList;
    }

    private void loadUsers() {
        Log.d(TAG, "loadUsers: ");
        List<User> list = new ArrayList<>();
        User user = new User(1, "arun");
        list.add(user);
        user = new User(2, "raj");
        list.add(user);
        user = new User(3, "kumar");
        list.add(user);
        user = new User(4, "arun raj");
        list.add(user);
        user = new User(5, "arun raj kumar");
        list.add(user);
        //userList.postValue(list); // asynchronously
        userList.setValue(list); // synchronously
    }

}
