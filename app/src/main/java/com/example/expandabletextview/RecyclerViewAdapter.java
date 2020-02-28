package com.example.expandabletextview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ReyclerViewHolder> {
    private LayoutInflater layoutInflater;
    private HashSet<Integer> expandedPositionSet;
    private Context context;
    private List<Article> articleList;
    public RecyclerViewAdapter(List<Article> articleList, Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        expandedPositionSet = new HashSet<>();
        this.articleList = articleList;
        this.context = context;
    }
    public void setArticleList(List<Article> ArticleList)
    {
        this.articleList = ArticleList;
        notifyDataSetChanged();
    }

    @Override
    public ReyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ReyclerViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ReyclerViewHolder holder, int position) {
        //String s=listItems.get(position);
        String string = "";
        List<String> abs = articleList.get(position).getAbstract();
        for(String s:abs)
        {
            string+=s;
            string+="\n\n\n";
        }
        holder.ArticleType.setText(articleList.get(position).getArticleType());
        holder.content.setText(string);
        float Score = articleList.get(position).getScore();
        Score = (float) (Math.round(Score*100.0)/100.0);
        holder.score.setText("Score- " + String.valueOf(Score));
        holder.title.setText(articleList.get(position).getTitle());
        string = articleList.get(position).getDate();
        String s="";

        for(int i=0;i<Math.min(10, string.length());i++) {
            s=s+ string.charAt(i);
        }
        holder.date.setText(s);
        List<String> authors= articleList.get(position).getAuthors();
        s="Authors:\n";
        for(String author : authors)
        {
            s+=author;
            s+="\n";
        }
        holder.Authors.setText(s);
        holder.updateItem(position);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ReyclerViewHolder extends RecyclerView.ViewHolder {
        private ExpandableLayout expandableLayout;
        private TextView showInfo;
        private TextView content;
        private TextView date;
        private TextView score;
        private TextView title;
        private TextView Authors;
        private TextView ArticleType;
        private ReyclerViewHolder(final View view) {
            super(view);
            expandableLayout = (ExpandableLayout) view.findViewById(R.id.expandable_layout);
            //showInfo = (TextView) view.findViewById(R.id.show_info);
            content = (TextView)view.findViewById(R.id.hidden);
            date = (TextView)view.findViewById(R.id.date);
            score = (TextView)view.findViewById(R.id.score);
            title = (TextView)view.findViewById(R.id.title);
            Authors=(TextView)view.findViewById(R.id.Authors_id);
            ArticleType=(TextView)view.findViewById(R.id.ArtType);
        }

        private void updateItem(final int position) {
            expandableLayout.setOnExpandListener(new ExpandableLayout.OnExpandListener() {
                @Override
                public void onExpand(boolean expanded) {
                    registerExpand(position);
                }
            });
            expandableLayout.setExpand(expandedPositionSet.contains(position));
        }
    }

    private void registerExpand(int position) {
        if (expandedPositionSet.contains(position)) {
            removeExpand(position);
            //textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
            //textView.setText("Show abstract");
        } else {

            addExpand(position);
            //textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0);
            //textView.setText("Hide abstract");
        }
    }

    private void removeExpand(int position) {
        expandedPositionSet.remove(position);
    }

    private void addExpand(int position) {
        expandedPositionSet.add(position);
    }
}