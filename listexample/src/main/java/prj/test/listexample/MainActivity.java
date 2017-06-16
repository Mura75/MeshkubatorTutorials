package prj.test.listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private Button buttonAdd;

    private List<String> stringList;

    private List<Person> personList;

    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);

        stringList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            stringList.add("item " + i);
        }

//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(MainActivity.this,
//                        android.R.layout.simple_list_item_1,
//                        android.R.id.text1,
//                        stringList);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, stringList.get(i), Toast.LENGTH_SHORT).show();
//            }
//        });


        personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person =
                    new Person("Name " + i, "Surname " + i, new Random().nextInt());
            personList.add(person);
        }

        personAdapter = new PersonAdapter(this, personList);
        listView.setAdapter(personAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person("Add", "Add", 15);
                personList.add(person);
                personAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                personList.remove(i);
                personAdapter.notifyDataSetChanged();
            }
        });
    }
}
