package kg.geektech.newsapp40.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kg.geektech.newsapp40.R;
import kg.geektech.newsapp40.databinding.ItemBoardBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    private final int[] images = {R.drawable.rtx3090, R.drawable.rtx3080, R.drawable.rtx2080};
    private final String[] titles = {"RTX 3090", "RTX 3080", "RTX 2080"};
    private final String[] descriptions = {
            "400 000 руб",
            "300 000 руб",
            "100 000 руб"
    };
    private ItemBoardBinding binding;
    private OnStartClickListener clickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public void setClickListener(OnStartClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemBoardBinding binding;

        public ViewHolder(@NonNull ItemBoardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(int position) {
            binding.textTitle.setText(titles[position]);
            binding.textDesc.setText(descriptions[position]);
            binding.ivBoard.setImageResource(images[position]);

            if (position == titles.length - 1) {
                binding.btn.setVisibility(View.VISIBLE);
            } else {
                binding.btn.setVisibility(View.INVISIBLE);
            }
            binding.btn.setOnClickListener(view -> {

            });
        }
    }
}
