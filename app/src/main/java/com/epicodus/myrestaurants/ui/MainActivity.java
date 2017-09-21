package com.epicodus.myrestaurants.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.myrestaurants.Constants;
import com.epicodus.myrestaurants.R;
import com.epicodus.myrestaurants.SavedRestaurantListActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.http.impl.conn.LoggingSessionOutputBuffer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = RestaurantListActivity.class.getSimpleName();
    //private SharedPreferences mSharedPreferences;
    //private SharedPreferences.Editor mEditor;

    private DatabaseReference mSearchedLocationReference;
    private ValueEventListener mSearchLocationReferenceListener;



    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;

    @Bind(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mEditor = mSharedPreferences.edit();

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindRestaurantsButton) {
            //String location = mLocationEditText.getText().toString();
            //saveLocationToFirebase(location);
            //if(!(location).equals("")) {
                //addToSharedPreferences(location);
            //}
            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
            startActivity(intent);
        }
    }
    //inflate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //response of the app when user selects logout
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_logout){
            logOut();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //the logout method
    public void logOut(){
        FirebaseAuth.getInstance().signOut();
        //ensure they return to login after they log-out
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    //public void saveLocationToFirebase(String location){
        //mSearchedLocationReference.push().setValue(location);
    //}



    public void savedRestaurant(View view){
        Intent intent = new Intent(MainActivity.this, SavedRestaurantListActivity.class);
        startActivity(intent);
    }
              //takes user inputed location as an argument
    //public void addToSharedPreferences(String location){
        //calls upon the editor to add this info to shared preferences
        //mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
        //values passed are the contant stored in constants file and the argument
    //}
}
