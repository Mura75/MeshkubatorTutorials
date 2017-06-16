package prj.test.listexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Murager on 6/16/17.
 */

public class RecyclerPersonAdapter extends RecyclerView.Adapter<RecyclerPersonAdapter.PersonViewHolder> {

    private List<Person> personList;

    private RecyclerItemsClickListener listener;

    public RecyclerPersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    public RecyclerPersonAdapter(List<Person> personList,
                                 RecyclerItemsClickListener listener) {
        this.personList = personList;
        this.listener = listener;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_card, parent, false);
        return new PersonViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.tvSurname.setText(person.getSurname());
        holder.tvName.setText(person.getName());
        holder.tvAge.setText(person.getAge() + "");
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvName;
        TextView tvAge;
        TextView tvSurname;

        Button button;
        Button button2;

        Context context;

        public PersonViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvAge = (TextView)itemView.findViewById(R.id.tvAge);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvSurname = (TextView)itemView.findViewById(R.id.tvSurname);

            button = (Button)itemView.findViewById(R.id.button);
            button2 = (Button)itemView.findViewById(R.id.button2);

            itemView.setOnClickListener(this);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.button) {
                if (listener != null) {
                    listener.onLikeClick(getAdapterPosition());
                }
            }
            else if (view.getId() == R.id.button2) {
                if (listener != null) {
                    listener.onShareClick(getAdapterPosition());
                }
            }
            else {
                if (listener != null) {
                    listener.onItemClick(getAdapterPosition());
                }
            }
        }
    }
}
