package amjad.mufeez.connect;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personEmail;
        TextView personPhone;
        TextView personLinkedin;
        TextView personGithub;
        TextView personDevpost;
        TextView personIndustry;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personEmail = (TextView)itemView.findViewById(R.id.person_email);
            personPhone = (TextView)itemView.findViewById(R.id.person_phone);
            personLinkedin = (TextView)itemView.findViewById(R.id.person_linkedin);
            personGithub = (TextView)itemView.findViewById(R.id.person_github);
            personDevpost = (TextView)itemView.findViewById(R.id.person_devpost);
            personIndustry = (TextView)itemView.findViewById(R.id.person_industry);
        }
    }
    List<JobSeekProfile> profiles;

    public RVAdapter(List<JobSeekProfile> profiles){
        this.profiles = profiles;
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(profiles.get(i).name);
        personViewHolder.personEmail.setText(profiles.get(i).email);
        personViewHolder.personPhone.setText(profiles.get(i).phone);
        personViewHolder.personLinkedin.setText(profiles.get(i).linkedin);
        personViewHolder.personGithub.setText(profiles.get(i).github);
        personViewHolder.personDevpost.setText(profiles.get(i).devpost);
        personViewHolder.personIndustry.setText(profiles.get(i).industry);

    }

}