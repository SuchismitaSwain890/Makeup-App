package com.example.androiappm.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.androiappm.Domain.CategoryDomain;
import com.example.androiappm.R;


import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl="";
        switch (position) {
            case 0: {
                picUrl = "pic_1";
                break;
            }
            case 1: {
                picUrl = "pic_2";
                break;
            }
            case 2: {
                picUrl = "pic_3";
                break;
            }
            case 3: {
                picUrl = "pic_4";
                break;
            }
            case 4: {
                picUrl = "pic_5";
                break;
            }
            case 5: {
                picUrl = "gliter1";
                break;
            }
            case 6: {
                picUrl = "img_13";
                break;
            }
            case 7: {
                picUrl = "img_19";
                break;
            }
            case 8: {
                picUrl = "img_10";
                break;
            }
            case 9: {
                picUrl = "img_24";
                break;
            }
            case 10: {
                picUrl = "img_25";
                break;
            }
            case 11: {
                picUrl = "img_26";
                break;
            }
            case 12: {
                picUrl = "img_9";
                break;
            }
        }

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(picUrl, "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.categoryPic);

    }


    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
