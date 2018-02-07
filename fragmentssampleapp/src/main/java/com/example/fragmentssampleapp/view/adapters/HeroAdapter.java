package com.example.fragmentssampleapp.view.adapters;

import android.arch.lifecycle.LifecycleActivity;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentssampleapp.R;
import com.example.fragmentssampleapp.activity.MainActivity;
import com.example.fragmentssampleapp.db.entities.Hero;
import com.example.fragmentssampleapp.fragment.FragmentThree;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ciro.oyarzun on 30-Jan-18.
 */

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroHolder> {

    private List<Hero> heroes;
    private Context context;


    public HeroAdapter(List<Hero> heroes, Context context) {
        this.heroes = heroes;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    @Override
    public HeroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_item, parent, false);
        return new HeroHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroHolder holder, final int position) {
        holder.tvName.setText(heroes.get(position).getName());
        holder.tvRealName.setText(heroes.get(position).getRealname());
        holder.tvTeam.setText(heroes.get(position).getTeam());
        holder.tvFirst.setText(heroes.get(position).getFirstappearance());
        holder.tvCrea.setText(heroes.get(position).getCreatedby());

        Picasso.with(context).load(heroes.get(position).getImageurl()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).addFragmentOnTop(new FragmentThree());
            }
        });
    }

    public class HeroHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.tv_real_name)
        TextView tvRealName;

        @BindView(R.id.tv_team)
        TextView tvTeam;

        @BindView(R.id.tv_first)
        TextView tvFirst;

        @BindView(R.id.tv_crea)
        TextView tvCrea;

        @BindView(R.id.imageView)
        ImageView imageView;

        public HeroHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
