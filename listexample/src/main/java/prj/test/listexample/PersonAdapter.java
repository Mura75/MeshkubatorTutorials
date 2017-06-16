package prj.test.listexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Murager on 6/16/17.
 */

public class PersonAdapter extends BaseAdapter {

    private Context context;

    private List<Person> personList;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int i) {
        return personList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_row_person, viewGroup, false);
            holder = new ViewHolder();
            holder.tvName = (TextView)view.findViewById(R.id.tvName);
            holder.tvSurname = (TextView)view.findViewById(R.id.tvSurname);
            holder.tvAge = (TextView)view.findViewById(R.id.tvAge);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }

        Person person = personList.get(i);
        holder.tvAge.setText(person.getAge() + "");
        holder.tvName.setText(person.getName());
        holder.tvSurname.setText(person.getSurname());
        return view;
    }

    public class ViewHolder {
        TextView tvName;
        TextView tvSurname;
        TextView tvAge;
    }
}
