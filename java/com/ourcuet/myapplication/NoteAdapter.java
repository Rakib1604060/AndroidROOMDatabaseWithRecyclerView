package com.ourcuet.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes=new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext())
                         .inflate(R.layout.note_card,parent,false);

        return new NoteHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote=notes.get(position);
        holder.textView_id.setText(String.valueOf(currentNote.getPriority()));
        holder.textView_description.setText(currentNote.getDescription());
        holder.textView_title.setText(currentNote.getTitle());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();

    }

    public Note getNoteAt( int position){
        return notes.get(position);

    }

    class  NoteHolder extends RecyclerView.ViewHolder{
          private TextView textView_id;
          private  TextView textView_title;
          private  TextView textView_description;


         public NoteHolder(View itemView) {
             super(itemView);
             textView_id=itemView.findViewById(R.id.text_priority);
             textView_title=itemView.findViewById(R.id.text_view_title);
             textView_description=itemView.findViewById(R.id.textView_description);
         }
     }
}
