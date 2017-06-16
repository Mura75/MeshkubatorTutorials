package prj.test.listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerActivity extends AppCompatActivity
        implements RecyclerItemsClickListener {

    private RecyclerView recyclerView;

    private List<Person> personList;

    private RecyclerPersonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person =
                    new Person("Name " + i, "Surname " + i, new Random().nextInt());
            personList.add(person);
        }

        adapter = new RecyclerPersonAdapter(personList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Card cliked " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLikeClick(int position) {
        Toast.makeText(this, "Liked " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShareClick(int position) {
        Toast.makeText(this, "Share " + position, Toast.LENGTH_SHORT).show();
    }
}
