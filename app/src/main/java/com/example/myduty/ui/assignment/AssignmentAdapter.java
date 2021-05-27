package com.example.myduty.ui.assignment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myduty.AssignmentDetailAcitivity;
import com.example.myduty.R;
import com.example.myduty.ui.assignment.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class AssignmentAdapter extends ListAdapter<Assignment, AssignmentAdapter.ViewHolder> {

    private  List<Assignment> mValues;

    public AssignmentAdapter(@NonNull DiffUtil.ItemCallback<Assignment> diffCallback) {
        super(diffCallback);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView topicCourse;
        public final TextView deadlineText;
        public final TextView topicText;
        public Button doneButton;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            topicCourse = (TextView) view.findViewById(R.id.task_topic);
            deadlineText = (TextView) view.findViewById(R.id.deadline);
            doneButton = (Button) view.findViewById(R.id.done_btn);
            topicText = (TextView)view.findViewById(R.id.topic);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_assignment_list2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Assignment assignment = getItem(position);
        holder.topicCourse.setText(assignment.getCourse());
        holder.topicText.setText(assignment.getTopic());
        holder.deadlineText.setText(assignment.getDeadline());

        holder.itemView.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Intent intent = new Intent(it.getContext(), AssignmentDetailAcitivity.class);
                intent.putExtra("data1", assignment.getCourse());
                intent.putExtra("data2", assignment.getTopic());
                intent.putExtra("data3", assignment.getDeadline());
                intent.putExtra("data4", assignment.getDescription());
                intent.putExtra("idTugas",assignment.getIdTugas());
                it.getContext().startActivity(intent);
            }
        }));
    }


    static class WordDiff extends DiffUtil.ItemCallback<Assignment> {
        @Override
        public boolean areItemsTheSame(@NonNull Assignment oldItem, @NonNull Assignment newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Assignment oldItem, @NonNull Assignment newItem) {
            return oldItem.getIdTugas()==(newItem.getIdTugas());
        }
    }


}